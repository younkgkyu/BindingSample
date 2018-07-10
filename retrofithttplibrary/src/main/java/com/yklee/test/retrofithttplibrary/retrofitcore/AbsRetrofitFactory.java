package com.yklee.test.retrofithttplibrary.retrofitcore;

import com.yklee.test.retrofithttplibrary.NetworkConst;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yeonggyu.lee on 2018-03-22.
 */

public abstract class AbsRetrofitFactory {

    public Retrofit get() {

        OkHttpClient httpClient = getClient();
        final NetworkHeader header = getHeader();

        if (httpClient == null) {
            OkHttpClient.Builder httpBuilder = new OkHttpClient().newBuilder();

            httpBuilder.connectTimeout(5, TimeUnit.SECONDS);
            httpBuilder.writeTimeout(5, TimeUnit.SECONDS);
            httpBuilder.readTimeout(5, TimeUnit.SECONDS);

            if (header != null && !header.isHeader()) {
                httpBuilder.addInterceptor(new Interceptor(){

                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        Request original = chain.request();
                        Request.Builder builder = original.newBuilder();
                        builder.method(original.method(), original.body());

                        Map<String, String> headers = header.getHeaderMap();
                        Iterator<String> keys = headers.keySet().iterator();
                        while (keys.hasNext()) {
                            String key = keys.next();
                            builder.header(key, headers.get(key));
                        }

                        return chain.proceed(builder.build());
                    }
                });
            }

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            httpBuilder.addInterceptor(interceptor);

            if (NetworkConst.DEFAULT_URL.startsWith("https")) {
                ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256).build();
                try {
                    HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                        @Override
                        public boolean verify(String s, SSLSession sslSession) {
                            return true;
                        }
                    };
                    httpClient = httpBuilder.sslSocketFactory(new TLSSocketFactory(), new UnsafeTrustManager()).hostnameVerifier(hostnameVerifier).connectionSpecs(Collections.singletonList(spec)).build();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                httpClient = httpBuilder.build();
            }
        }

        Converter.Factory factory = null;

        if(getConverterFactory() == null) {
            factory = GsonConverterFactory.create();
        } else {
            factory = getConverterFactory();
        }

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(getDefaultUrl())
                .addConverterFactory(factory)
                .build();

        return retrofit;
    }

    protected abstract OkHttpClient getClient();
    protected abstract Converter.Factory getConverterFactory();
    protected abstract NetworkHeader getHeader();
    protected abstract String getDefaultUrl();
}
