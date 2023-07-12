package com.example.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()

    }

    private fun getNews() {
        val apiEndpoint = Services.buildService(ApiInterface::class.java)
        val call: Call<NewsList> = apiEndpoint.getNews()
        call.enqueue(object : Callback<NewsList> {
            override fun onResponse(
                call: Call<NewsList>,
                response: Response<NewsList>
            ) {
                if(response.isSuccessful){
                    val news: NewsList? = response.body()
//                    if (news != null) {
                        Log.e("NewsList", response.body().toString())
//                    }
                } else {
                    Log.e("response error", "Ooops! There was an error in getting your response ${response.errorBody()
                        ?.string()}")
                }
            }

            override fun onFailure(call: Call<NewsList>, t: Throwable) {
                Log.e("error", "Ooops! there is an error $t")
            }

        })

    }

}