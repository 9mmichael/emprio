package com.qmmichael.emprio.ui.brand_list

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.qmmichael.emprio.R
import com.qmmichael.emprio.data.model.Brand
import com.qmmichael.emprio.databinding.BrandListItemBinding

class BrandListAdapter : RecyclerView.Adapter<BrandListAdapter.BrandListViewHolder>() {
  val items = ArrayList<Brand>()

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
    holder.binding.brand = items[position]
  }

  override fun getItemCount(): Int = items.size

  inner class BrandListViewHolder(val binding: BrandListItemBinding) : RecyclerView.ViewHolder(
      binding.root
  )
}
