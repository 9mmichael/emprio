package com.qmmichael.emprio.ui.shop_list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.qmmichael.emprio.R
import com.qmmichael.emprio.data.dummy_data.DummyBrandList
import com.qmmichael.emprio.util.setContentFragment

class ShopListActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.shop_list_activity)
    val brandId = intent.getIntExtra(KEY_BRAND_ID, 0)
    setContentFragment(R.id.containerLayout) { ShopListFragment.newInstance(brandId) }
    setUpActionBar()
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
    android.R.id.home -> {
      finish()
      true
    }
    else -> super.onOptionsItemSelected(item)
  }

  private fun setUpActionBar() {
    val brandId = intent.getIntExtra(KEY_BRAND_ID, 0)
    supportActionBar?.title = DummyBrandList().brandList.elementAtOrNull(brandId - 1)?.name ?: ""
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
  }

  companion object {
    private const val KEY_BRAND_ID = "KEY_BRAND_ID"
  }
}
