package com.example.aplikasidisastercheck

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity: AppCompatActivity() {
    lateinit var rvNews: RecyclerView
    lateinit var viewAdapterTesting: ViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_layout)

        rvNews = findViewById(R.id.rvNews)
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
        rvNews.setLayoutManager(layoutManager)

        NetworkConfig().NewsCovid()
            .getNewsHealthIndonesia()
            .enqueue(object : Callback<News> {
                override fun onFailure(call: Call<News>, t: Throwable) {
                    Toast.makeText(this@NewsActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<News>,
                    response: Response<News>
                ) {
                    val news: News? = response.body()
                    viewAdapterTesting = ViewAdapter(checkNewsContainCovid(news?.articles))
                    rvNews.adapter = viewAdapterTesting
                }
            })
    }
}