package com.example.ciceksepeti.ui
import com.example.ciceksepeti.Base.*
import com.example.ciceksepeti.RestClient
import com.example.ciceksepeti.response.Product
import com.example.ciceksepeti.response.ProductList

class ProductListViewModel : BaseViewModel() {
    internal enum class DataType : BaseDataType {
        PROD_LIST
    }

    private var product: List<Product> = ArrayList()


    fun getProductList() {

            loadList { data, errorMsg ->
                actionMutable.value = Loading(false)

                data?.let {
                    product = it.result.data.products
                    actionMutable.value = ContentLoaded(product, DataType.PROD_LIST)
                } ?: run { actionMutable.value = HasError(errorMsg, HasError.DataType.NONE) }
            }
    }


    internal fun setProductList(list: List<Product>?) {
        product = list ?: ArrayList()
    }
}



fun loadList(onComplete: (data: ProductList?, errorMsg: String?) -> Unit) {
    RestClient.getResult(RestClient.productListService.getProductList()) {
        onComplete(it.data, it.error.toString())
    }
}