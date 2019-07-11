package com.qmmichael.emprio.data.dummy_data

import com.qmmichael.emprio.data.model.Shop
import com.qmmichael.emprio.data.model.ShopList

class DummyShopList {
  private val freitagShopList = ShopList(
      1, listOf(
      Shop("FREITAG STORE TOKYO", "東京都中央区銀座１丁目１３−１２"),
      Shop("FREITAG STORE TOKYO SHIBUYA", "東京都渋谷区神宮前６丁目１９−１８"),
      Shop("FREITAG STORE OSAKA", "大阪府大阪市中央区南船場４丁目６−１０")
  )
  )
  private val aaaShopList = ShopList(2, listOf(Shop("aaa shop", "aaa address")))
  private val bbbShopList = ShopList(3, listOf(Shop("bbb shop", "bbb address")))
  val shopList = listOf(freitagShopList, aaaShopList, bbbShopList)
}
