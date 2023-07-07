package com.aou.productapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aou.productapp.api.ApiManager
import com.aou.productapp.model.ProductResponse
import com.aou.productapp.model.ProductsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {


    val productsLiveData = MutableLiveData<List<ProductsItem?>?>()
    val progressVisible = MutableLiveData<Boolean>()
    val messageLiveData = MutableLiveData<String>()

    fun getProducts() {

        progressVisible.value = true
        ApiManager.getApis()
            .getProducts()
            .enqueue(object : Callback<ProductResponse> {


                override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                    progressVisible.value = false
                    messageLiveData.value = t.localizedMessage
                }

                override fun onResponse(
                    call: Call<ProductResponse>,
                    response: Response<ProductResponse>
                ) {
                    progressVisible.value = false
                    //adapter.changeData(response.body()?.products)
                    productsLiveData.value = response.body()?.products
                }

            }
            )
    }


}