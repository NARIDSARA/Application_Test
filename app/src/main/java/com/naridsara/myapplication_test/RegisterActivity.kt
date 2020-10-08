package com.naridsara.myapplication_test
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity() {
    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        viewModel.responseRegister().observe {
            Edt_Name.setText("")
            Edt_SurName.setText("")
            Edt_UserName.setText("")
            Edt_email.setText("")
            Edt_password.setText("")
            Edt_Re_password.setText("")
            Edt_Tel.setText("")
            Edt_HouseNumber.setText("")
            Edt_Moo.setText("")
            Edt_District.setText("")
            Edt_SubDistrict.setText("")
            Edt_province.setText("")
            Edt_PostalCode.setText("")
            toast("Register Success")
        }

            viewModel.responseValidateUsername().observe {
                it
                val customer_email = Edt_email.getContents()
                if (it) {
                    toast("Email repeat")
                } else {
                    viewModel.requestValidateEmail(customer_email)
                }
            }
            viewModel.responseValidateEmail().observe { it ->
                val customer_tel = Edt_Tel.getContents()
                if (it) {
                    toast("Tel repeat")
                } else {
                    viewModel.requestValidateTel(customer_tel)
                }
            }
            viewModel.responseValidateTel().observe {
                if (it) {
                    toast("Tel repeat")
                } else {
                    val customer_name = Edt_Name.getContents()
                    val customer_surname = Edt_SurName.getContents()
                    val customer_username = Edt_UserName.getContents()
                    val customer_email = Edt_email.getContents()
                    val customer_password = Edt_password.getContents()
                    val customer_repassword = Edt_Re_password.getContents()
                    val customer_tel = Edt_Tel.getContents()
                    val customer_housenumber = Edt_HouseNumber.getContents()
                    val customer_moo = Edt_Moo.getContents()
                    val customer_district = Edt_District.getContents()
                    val customer_subdistrict = Edt_SubDistrict.getContents()
                    val customer_province = Edt_province.getContents()
                    val customer_postalcode = Edt_PostalCode.getContents()
                    viewModel.requestRegister(customer_name, customer_surname, customer_username, customer_email, customer_password, customer_repassword, customer_tel, customer_housenumber, customer_moo, customer_district, customer_subdistrict, customer_province, customer_postalcode)
                }
            }
            viewModel.responseToast().observe {
                toast(it)
            }
        Btn_Register.setOnClickListener {
            val customer_username = Edt_UserName.getContents()
            viewModel.requestValidateUsername(customer_username)
        }

           // companion object {
          //  private const val TAG = "RegisterActivity"
        }
        }

