package com.qmmichael.emprio.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qmmichael.emprio.R
import com.qmmichael.emprio.databinding.MainFragmentBinding
import com.qmmichael.emprio.ui.brand_list.BrandListActivity
import com.qmmichael.emprio.ui.maps.MapsActivity

class MainFragment : Fragment() {

  private val viewModel by lazy {
      ViewModelProviders.of(this).get(MainViewModel::class.java)
  }
  private lateinit var binding: MainFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? =
    DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false)
        .also {
          binding = it
        }.root

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    binding.viewModel = viewModel
    binding.goMapButton.setOnClickListener {
      startActivity(Intent(activity, MapsActivity::class.java))
    }
    binding.goBrandListBtn.setOnClickListener {
      startActivity(Intent(activity, BrandListActivity::class.java))
    }
  }

  companion object {
    fun newInstance() = MainFragment()
  }
}