package com.theapplication.webcraft.Mvvm.Retrofit

import com.theapplication.webcraft.Mvvm.Model.DataModel
import retrofit2.http.GET


interface ProductApi {
    @GET("Todo")
    suspend fun getproduct():retrofit2.Response<DataModel>
}