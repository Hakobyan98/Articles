package com.example.articles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_main.layoutManager = LinearLayoutManager(this)

        fetchJson()
    }

    fun fetchJson(){
        val url = "https://content.guardianapis.com/search?q=12%20years%20a%20slave&format=json&tag=film%2Ffilm%2Ctone%2Freviews&from-date=2010-01-01&show-tags=contributor&show-fields=starRating%2Cheadline%2Cthumbnail%2Cshort-url&order-by=relevance&api-key=da3e84a8-a10c-403d-9817-863e081ee713"
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                val homeFeed = Gson().fromJson(body, HomeFeed::class.java)
                runOnUiThread{ recyclerview_main.adapter = MainAdapter(homeFeed) }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("failed")
            }
        })
    }

}


