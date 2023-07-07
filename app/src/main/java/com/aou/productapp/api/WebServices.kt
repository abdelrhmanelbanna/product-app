package com.aou.productapp.api

import com.aou.productapp.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface WebServices {


    @GET("products")
    fun getProducts(): Call<ProductResponse>

}