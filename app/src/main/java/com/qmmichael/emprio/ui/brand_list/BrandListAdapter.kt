package com.qmmichael.emprio.ui.brand_list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.qmmichael.emprio.R
import com.qmmichael.emprio.data.model.Brand
import com.qmmichael.emprio.databinding.BrandListItemBinding

class BrandListAdapter(
  private val onClickBrand: (Brand) -> Unit
) : RecyclerView.Adapter<BrandListAdapter.BrandListViewHolder>() {
  val brands = ArrayList<Brand>()

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): BrandListViewHolder =
    BrandListViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.brand_list_item,
            parent,
            false
        )
    )

  override fun onBindViewHolder(
    holder: BrandListViewHolder,
    position: Int
  ) {
    val brand = brands[position]
    holder.binding.brand = brand
    holder.binding.root.setOnClickListener {
      onClickBrand(brand)
    }

    Glide.with(holder.binding.root)
        .load(brand.image_url)
        .apply {
          RequestOptions()
              .placeholder(R.drawable.ic_store)
              .error(R.drawable.ic_store)
              .circleCrop()
        }
        .into(holder.binding.icon)
  }

  override fun getItemCount(): Int = brands.size

  inner class BrandListViewHolder(val binding: BrandListItemBinding) : RecyclerView.ViewHolder(
      binding.root
  )
}
