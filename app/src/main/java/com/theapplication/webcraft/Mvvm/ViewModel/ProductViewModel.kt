package com.theapplication.webcraft.Mvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theapplication.webcraft.Mvvm.Model.DataModel
import com.theapplication.webcraft.Mvvm.Retrofit.ProductInstance
import com.theapplication.webcraft.Mvvm.Retrofit.ProductResponse
import kotlinx.coroutines.launch

class ProductViewModel:ViewModel() {
    private val productApi = ProductInstance.productApi
    private val _productResult = MutableLiveData<ProductResponse<DataModel>>()
    val productResult: LiveData<ProductResponse<DataModel>> = _productResult




    fun getdata(){
        _productResult.value = ProductResponse.loading
        viewModelScope.launch {
            try {
                val response = productApi.getproduct()
                if (response.isSuccessful){
                    response.body()?.let {
                        _productResult.value=ProductResponse.Sucess(it)
                    }
                }
                else{
                    _productResult.value=ProductResponse.Errors("Something went wrong")
                }
            }
            catch (e:Exception){
                _productResult.value=ProductResponse.Errors("Something went wrong")
            }
        }
        }
}