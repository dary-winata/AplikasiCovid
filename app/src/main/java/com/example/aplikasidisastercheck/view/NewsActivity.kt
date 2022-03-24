package com.example.aplikasidisastercheck.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasidisastercheck.News
import com.example.aplikasidisastercheck.R
import com.example.aplikasidisastercheck.ViewAdapter
import com.example.aplikasidisastercheck.checkNewsContainCovid
import com.example.aplikasidisastercheck.model.retrofit.GeneralRetrofit
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

        GeneralRetrofit().NewsCovid().getNewsHealthIndonesia()
            .enqueue(object : Callback<News> {
                override fun onFailure(call: Call<News>, t: Throwable) {
                    Toast.makeText(this@NewsActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<News>,
                    response: Response<News>
                ) {
                    val news: News? = response.body()
                    val test = checkNewsContainCovid(news?.articles)
                    viewAdapterTesting = ViewAdapter(checkNewsContainCovid(news?.articles))
                    rvNews.adapter = viewAdapterTesting
                }
            })
    }
}