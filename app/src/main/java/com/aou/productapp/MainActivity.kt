package com.aou.productapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aou.productapp.databinding.ActivityMainBinding
import com.aou.productapp.model.ProductsItem

class MainActivity : AppCompatActivity() {


    lateinit var viewModel: ProductViewModel
    lateinit var viewDataBinding: ActivityMainBinding

    val adapter = ProductAdapter(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        subscribeToLiveData()
        initViews()

        viewModel.getProducts()
    }

    fun subscribeToLiveData() {

        viewModel.productsLiveData.observe(this, {
            showProducts(it)
        })

        viewModel.progressVisible.observe(this, { isVisible ->

            viewDataBinding.progressBar.isVisible = isVisible
        })

        viewModel.messageLiveData.observe(this, { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
    }

    fun showProducts(productList: List<ProductsItem?>?) {

        adapter.changeData(productList)

    }


    fun initViews() {
        viewDataBinding.recyclerView.adapter = adapter

    }


}