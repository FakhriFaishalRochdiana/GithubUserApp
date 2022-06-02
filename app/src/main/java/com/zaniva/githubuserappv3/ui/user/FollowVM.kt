package com.zaniva.githubuserappv3.ui.user

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zaniva.githubuserappv3.connection.Connection
import com.zaniva.githubuserappv3.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowVM : ViewModel(){
    val list = MutableLiveData<ArrayList<User>>()

    fun set (un: String){
        Connection.apiIns
            .getFollowers(un)
            .enqueue(object : Callback<ArrayList<User>>{
                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>
                ) {
                    if (response.isSuccessful){
                        list.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    Log.d("onFailure", t.message.toString())
                }

            })
    }

    fun get() : LiveData<ArrayList<User>>{
        return list
    }

}