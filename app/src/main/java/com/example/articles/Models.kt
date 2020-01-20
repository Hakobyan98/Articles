package com.example.articles

data class HomeFeed(val response : Res)
data class Res(val pageSize : Int, val pages : Int, val results : List<Items>)
data class Items(val fields : Fields)
data class Fields(val headline : String, val shortUrl : String, val thumbnail : String)







