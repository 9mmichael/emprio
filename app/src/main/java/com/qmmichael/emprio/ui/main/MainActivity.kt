package com.qmmichael.emprio.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.qmmichael.emprio.R
import com.qmmichael.emprio.util.setContentFragment

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)
    setContentFragment(R.id.containerLayout) { MainFragment.newInstance() }
    setUpActionBar()
  }

  private fun setUpActionBar() {
    supportActionBar?.title = "home"
  }
}
