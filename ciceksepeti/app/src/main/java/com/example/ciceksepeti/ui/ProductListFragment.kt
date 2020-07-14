package com.example.ciceksepeti.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepeti.Base.*
import com.example.ciceksepeti.response.Product
import com.example.ciceksepeti.ui.adapter.ProductListAdapter
import com.example.ciceksepeti.databinding.FragmentProductListBinding
import kotlinx.android.synthetic.main.fragment_product_list.*


class ProductListFragment : Fragment() {
    lateinit var binding: FragmentProductListBinding

    lateinit var viewModel: ProductListViewModel
    private var productList: List<Product>? = null
    private lateinit var productListAdapter: ProductListAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(
            ProductListViewModel::class.java
        )
        productListAdapter =
            ProductListAdapter(viewModel)
        handleLiveData()
        initViews()

        viewModel.setProductList(productList)
        viewModel.getProductList()

    }

    private fun initViews() {

        with(binding) {
            aViewModel = viewModel


            recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,
                false)
            recycler_view.adapter = productListAdapter
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun handleLiveData() {
        observe(viewModel.actionLiveData) {
                when (it) {
                    is Loading -> {
                    }

                    is HasError -> when (it.type) {
                    }

                    is ContentLoaded<*> -> when(it.type) {
                        ProductListViewModel.DataType.PROD_LIST ->productListAdapter.setProducts(it.data as List<Product>)
                    }

                    is ItemClicked<*> -> handleOnClick(it)
                }
            }
    }
    @Suppress("UNCHECKED_CAST")
    private fun handleOnClick(action: ItemClicked<*>) {

        when (action.type!!) {

        }
    }
}