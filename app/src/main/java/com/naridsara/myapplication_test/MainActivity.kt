package com.naridsara.myapplication_test

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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

        viewModel.responseRestaurants().observe {
            Log.d(TAG, "onCreate: $it")
            it.forEach {
                Log.d(TAG, "onCreate: ${it.restaurantsName}")
            }
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