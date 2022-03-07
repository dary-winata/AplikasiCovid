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

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.news_layout)

        Log.e("*****", "kimak123")
        rvNews = findViewById(R.id.rvNews)
        viewAdapterTesting = ViewAdapter()
        val layoutManager: LinearLayoutManager = LinearLayoutManager(this)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
        rvNews.setLayoutManager(layoutManager)
        rvNews.adapter = viewAdapterTesting
        Log.e("*****", "kimak123")

        NetworkConfig().getService()
            .getDataCity()
            .enqueue(object : Callback<List<InfoFaskes>> {
                override fun onFailure(call: Call<List<InfoFaskes>>, t: Throwable) {
                    Toast.makeText(this@NewsActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    Log.e("&&&&", "kimak")
                }

                override fun onResponse(
                    call: Call<List<InfoFaskes>>,
                    response: Response<List<InfoFaskes>>
                ) {
                    tesitng()
                    response.body()?.forEach { Log.e("*", it.nama) }
                    viewAdapterTesting.setDataList(response.body())
                }
            })
        Log.e("*****", "kimak321")
    }

    fun tesitng(){
        Toast.makeText(this@NewsActivity, "Berhasil", Toast.LENGTH_SHORT).show()
    }
}