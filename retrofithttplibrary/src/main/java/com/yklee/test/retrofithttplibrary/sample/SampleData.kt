package com.yklee.test.retrofithttplibrary.sample

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by yeonggyu.lee on 2018-03-16.
 */
data class SampleData(
    @SerializedName("login")
    @Expose
    val login: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("avatar_url")
    @Expose
    val avatarUrl: String,
    @SerializedName("gravatar_id")
    @Expose
    val gravatarId: String,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("html_url")
    @Expose
    val htmlUrl: String,
    @SerializedName("followers_url")
    @Expose
    val followersUrl: String,
    @SerializedName("following_url")
    @Expose
    val followingUrl:String,
    @SerializedName("gists_url")
    @Expose
    val gistsUrl: String,
    @SerializedName("starred_url")
    @Expose
    val starredUrl: String,
    @SerializedName("subscriptions_url")
    @Expose
    val subscriptionsUrl: String,
    @SerializedName("organizations_url")
    @Expose
    val organizationsUrl: String,
    @SerializedName("repos_url")
    @Expose
    val reposUrl: String,
    @SerializedName("events_url")
    @Expose
    val eventsUrl: String,
    @SerializedName("received_events_url")
    @Expose
    val receivedEventsUrl: String,
    @SerializedName("type")
    @Expose
    val type: String,
    @SerializedName("site_admin")
    @Expose
    val siteAdmin: String,
    @SerializedName("contributions")
    @Expose
    val contributions: Int)