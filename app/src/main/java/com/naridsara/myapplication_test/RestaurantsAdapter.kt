package com.naridsara.myapplication_test

import android.view.View
import com.naridsara.myapplication_test.model.Restaurants
import kotlinx.android.synthetic.main.item_list_restaurants.view.*

class RestaurantsAdapter : BaseRecyclerView<Restaurants>() {
    override fun getLayout(): Int = R.layout.item_list_restaurants


    override fun View.onBindViewHolder(data: Restaurants) {
        tv_Restaurants_name.text = data.restaurantsName
        tv_Restaurants_latitude.text = data.restaurantsLatitude.toString()
        tv_Restaurants_longitude.text = data.restaurantsLongitude.toString()
        mIv_Pic_restaurants.setImageCircle(data.restaurantsImage)
    }
}