package com.naridsara.myapplication_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.adedom.library.Dru
import com.adedom.library.ExecuteQuery
import com.naridsara.myapplication_test.model.Restaurants

class RestaurantsDetailActivity : BaseActivity() {

    private lateinit var viewModel: RestaurantsDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants_detail)
        val Restaurants_id = intent.getIntExtra("Restaurants_id",0)

        viewModel = ViewModelProvider(this).get(RestaurantsDetailViewModel::class.java)

        viewModel.responseRestaurantsDetail().observe {
            toast(it.restaurantsId.toString())
        }

        viewModel.requestRestaurantsDetail(Restaurants_id)

    }
}

























