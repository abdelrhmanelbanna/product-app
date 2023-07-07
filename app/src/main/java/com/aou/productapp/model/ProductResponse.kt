package com.aou.productapp.model

data class ProductResponse(
	val total: Int? = null,
	val limit: Int? = null,
	val skip: Int? = null,
	val products: List<ProductsItem?>? = null
)

data class ProductsItem(
	val discountPercentage: Any? = null,
	val thumbnail: String? = null,
	val images: List<String?>? = null,
	val price: Int? = null,
	val rating: Any? = null,
	val description: String? = null,
	val id: Int? = null,
	val title: String? = null,
	val stock: Int? = null,
	val category: String? = null,
	val brand: String? = null
)

