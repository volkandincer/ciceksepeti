package com.example.ciceksepeti.service

import com.example.ciceksepeti.response.ProductList
import retrofit2.Call
import retrofit2.http.GET

interface ProductListService {
    @GET("product/ch/dynamicproductlist")
    fun getProductList(): Call<ProductList>
}