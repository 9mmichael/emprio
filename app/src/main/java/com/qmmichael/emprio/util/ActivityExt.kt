package com.qmmichael.emprio.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

fun FragmentActivity.setContentFragment(containerId: Int, f: () -> Fragment) : Fragment? {
  val manager = supportFragmentManager
  val fragment = manager?.findFragmentById(containerId)

  fragment?.let { return it }
  return f().apply { manager?.beginTransaction()?.add(containerId, this)?.commit() }
}