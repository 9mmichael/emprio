package com.qmmichael.emprio.ui.shop_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.qmmichael.emprio.data.model.Shop
import com.qmmichael.emprio.databinding.ShopListItemBinding
import com.qmmichael.emprio.ui.shop_list.ShopListAdapter.ShopListViewHolder

class ShopListAdapter(
  private val onClickShop: (Shop) -> Unit
) : RecyclerView.Adapter<ShopListViewHolder>() {
  val shops = ArrayList<Shop>()

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ShopListViewHolder =
    ShopListViewHolder(
        ShopListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

  override fun onBindViewHolder(
    holder: ShopListViewHolder,
    position: Int
  ) {
    val shop = shops[position]
    holder.binding.shop = shop
    holder.binding.root.setOnClickListener {
      onClickShop(shop)
    }
  }

  override fun getItemCount(): Int = shops.size

  inner class ShopListViewHolder(val binding: ShopListItemBinding) : RecyclerView.ViewHolder(
      binding.root
  )
}
