package com.qmmichael.emprio.ui.brand_list

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qmmichael.emprio.R
import com.qmmichael.emprio.data.model.Brand
import com.qmmichael.emprio.databinding.BrandListFragmentBinding

class BrandListFragment : Fragment() {
  private val viewModel by lazy {
    ViewModelProviders.of(this).get(BrandListViewModel::class.java)
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
    val dummyBrandList = listOf(
        Brand("", "freitag"),
        Brand("", "aaa"),
        Brand("", "bbb")
    )
    val adapter = BrandListAdapter()

    adapter.apply {
      items.clear()
      items.addAll(dummyBrandList)
      notifyDataSetChanged()
    }

    binding.recyclerView.adapter = adapter
    binding.recyclerView.layoutManager = LinearLayoutManager(context)

  }

  companion object {
    fun newInstance() = BrandListFragment()
  }
}
