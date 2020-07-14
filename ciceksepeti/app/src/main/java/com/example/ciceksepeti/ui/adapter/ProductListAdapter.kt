package com.example.ciceksepeti.ui.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ciceksepeti.response.Product
import com.example.ciceksepeti.R
import com.example.ciceksepeti.ui.ProductListViewModel
import com.example.ciceksepeti.databinding.ItemBinding

class ProductListAdapter (val listViewModel: ProductListViewModel):
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    private var productList: List<Product> = ArrayList()

    fun setProducts(data: List<Product>) {
        productList = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemBinding = DataBindingUtil.inflate<ItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item, parent, false)
        return ProductViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position], position)
    }

    inner class ProductViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(pro: Product, pos: Int) {
            with(binding) {
                product = pro
                viewModel = listViewModel
                position = pos
                old.paintFlags = old.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

                executePendingBindings()
            }
        }
    }
}