package com.qmmichael.emprio.ui.shop_list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.qmmichael.emprio.data.dummy_data.DummyShopList
import com.qmmichael.emprio.databinding.ShopListFragmentBinding

class ShopListFragment : Fragment() {
  private lateinit var binding: ShopListFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    ShopListFragmentBinding.inflate(
        inflater,
        container,
        false
    ).also {
      binding = it
    }.root

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    val brandId = arguments?.getInt(KEY_BRAND_ID)
    val shopList = DummyShopList().shopList

    val adapter = ShopListAdapter {
      Toast.makeText(context, it.title, Toast.LENGTH_SHORT)
          .show()
    }
    binding.recyclerView.layoutManager = LinearLayoutManager(context)
    binding.recyclerView.adapter = adapter

    brandId?.let {
      adapter.shops.addAll(shopList.elementAtOrNull(it - 1)?.shops ?: listOf())
      adapter.notifyDataSetChanged()
    }
  }

  companion object {
    private const val KEY_BRAND_ID = "KEY_BRAND_ID"
    fun newInstance(brandId: Int) = ShopListFragment().apply {
      arguments = Bundle().apply {
        putInt(KEY_BRAND_ID, brandId)
      }
    }
  }
}
