package com.naridsara.myapplication_test

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        Btn_LogIng.setOnClickListener {
            val username = Edt_UserName.getContents()
            val password = Edt_Password.getContents()
            viewModel.requestLogin(username, password)
        }

        viewModel.responseLogin().observe {
            if (it) {
                startActivity(Intent(baseContext, MainActivity::class.java))
            } else {
                toast("ชื่อผู้ใช้ไม่ถูกต้อง")
            }
        }

        Btn_Register.setOnClickListener { startActivity(Intent(baseContext, RegisterActivity::class.java)) }
        viewModel.responseToast().observe {
           toast(it)
    }
    }
}