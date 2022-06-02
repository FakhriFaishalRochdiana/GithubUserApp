package com.zaniva.githubuserappv3.connection

import com.zaniva.githubuserappv3.BuildConfig
import com.zaniva.githubuserappv3.data.UserResponses
import com.zaniva.githubuserappv3.data.Responses
import com.zaniva.githubuserappv3.data.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Query {
    @GET("search/users")
    @Headers("Authorization: token ${BuildConfig.SECRET_KEY}")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<Responses>

    @GET("users/{username}")
    @Headers("Authorization: token ${BuildConfig.SECRET_KEY}")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<UserResponses>

    @GET("users/{username}/followers")
    @Headers("Authorization: token ${BuildConfig.SECRET_KEY}")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token ${BuildConfig.SECRET_KEY}")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}