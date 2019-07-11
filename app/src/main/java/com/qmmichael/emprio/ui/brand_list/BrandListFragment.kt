package com.qmmichael.emprio.ui.brand_list

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qmmichael.emprio.R
import com.qmmichael.emprio.data.dummy_data.DummyBrandList
import com.qmmichael.emprio.databinding.BrandListFragmentBinding
import com.qmmichael.emprio.ui.shop_list.ShopListActivity

class BrandListFragment : Fragment() {
  private val viewModel by lazy {
    ViewModelProviders.of(this)
        .get(BrandListViewModel::class.java)
  }
  private lateinit var binding: BrandListFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    DataBindingUtil.inflate<BrandListFragmentBinding>(
        inflater,
        R.layout.brand_list_fragment,
        container,
        false
    ).also { binding = it }.root

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    val dummyBrandList = DummyBrandList().brandList
    val adapter = BrandListAdapter {
      val intent = Intent(activity, ShopListActivity::class.java)
      intent.putExtra(KEY_BRAND_ID, it.brand_id)
      startActivity(intent)
    }

    adapter.apply {
      brands.clear()
      brands.addAll(dummyBrandList)
      notifyDataSetChanged()
    }

    binding.recyclerView.adapter = adapter
    binding.recyclerView.layoutManager = LinearLayoutManager(context)

  }

  companion object {
    private const val KEY_BRAND_ID = "KEY_BRAND_ID"
    fun newInstance() = BrandListFragment()
  }
}
