package com.example.aplikasidisastercheck

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity: AppCompatActivity() {
    lateinit var rvNews: RecyclerView
    lateinit var viewAdapterTesting: ViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_layout)

        Log.e("*****", "kimak123")
        rvNews = findViewById(R.id.rvNews)
        viewAdapterTesting = ViewAdapter()
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
        rvNews.setLayoutManager(layoutManager)
        rvNews.adapter = viewAdapterTesting

        NetworkConfig().getService()
            .getDataCity()
            .enqueue(object : Callback<InfoFaskes> {
                override fun onFailure(call: Call<InfoFaskes>, t: Throwable) {
                    Toast.makeText(this@NewsActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<InfoFaskes>,
                    response: Response<InfoFaskes>
                ) {
                    val infoFaskes: InfoFaskes? = response.body()
                    viewAdapterTesting.setDataList(infoFaskes?.data)
                }
            })
        Log.e("*****", "kimak321")
    }
}