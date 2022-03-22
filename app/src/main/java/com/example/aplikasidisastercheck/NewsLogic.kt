package com.example.aplikasidisastercheck

fun checkNewsContainCovid(data: List<ArticlesItem>?): List<ArticlesItem>? {
    var dataList = arrayListOf<ArticlesItem>()

    data!!.forEach{
        if(it.content?.contains("COVID", ignoreCase = true) == true ||
            it.title?.contains("COVID", ignoreCase = true) == true ||
            it.description?.contains("COVID", ignoreCase = true) == true
        )
            dataList.add(it)
    }

    return dataList
}