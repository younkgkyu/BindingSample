//package com.yklee.test;
//
//import android.databinding.DataBindingUtil;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//import com.yklee.test.databinding.ActivityMainBinding;
//import com.yklee.test.viewmodel.MainViewModel;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
//        ActivityMainBinding databinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//
//        MainViewModel mainViewModel = new MainViewModel(this);
//        databinding.setMainViewModel(mainViewModel);
//
//        initialize(databinding);
//
//    }
//
//    private void initialize(final ActivityMainBinding dataBinding) {
//
//        Toolbar toolbar = dataBinding.toolbar;
//        setSupportActionBar(toolbar);
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
