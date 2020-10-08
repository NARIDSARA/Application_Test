package com.naridsara.myapplication_test

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.library.Dru
import com.naridsara.myapplication_test.model.Restaurants
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        if (ConnectDB.getConnection() == null) {
            Dru.failed(baseContext)
        } else {
            Dru.completed(baseContext)
        }
        Btn_Add_Restaurants.setOnClickListener {
            startActivity(Intent(baseContext, AddRestaurantsActivity::class.java))
        }
        val adt = RestaurantsAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }
        adt.onClick = {
            //toast(it.restaurantsName)
            startActivity(Intent(baseContext, RestaurantsDetailActivity::class.java))
            Intent(baseContext, RestaurantsDetailActivity::class.java).apply {
                putExtra("Restaurants_id",it.restaurantsId)
                startActivity(this)
            }
        }

        viewModel.responseRestaurants().observe {
//            Log.d(TAG, "onCreate: $it")
//            it.forEach {
//                Log.d(TAG, "onCreate: ${it.restaurantsName}")
//
//            }
            adt.setList(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.requestRestaurants()
    }

    companion object{
        private const val TAG = "MainActivity"
    }
}