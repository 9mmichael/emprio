package com.qmmichael.emprio.ui.brand_list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.qmmichael.emprio.R
import com.qmmichael.emprio.util.setContentFragment

class BrandListActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.brand_list_activity)
    setContentFragment(R.id.containerLayout) { BrandListFragment.newInstance() }
  }
}
