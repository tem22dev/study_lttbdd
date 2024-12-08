package com.example.study.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.study.AppConstants
import com.example.study.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set view layout

    }

    fun handleLogin(view: View) {
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)

        val email: String = edtEmail.text.toString()
        val password: String = edtPassword.text.toString()

        // Tạo một Bundle để chứa dữ liệu
        val loginBundle = Bundle().apply {
            putString(AppConstants.USER_INFO_KEY, "$email - $password")
        }

        // Tạo intent để chuyển sang HomeActivity và thêm Bundle vào
        val loginIntent = Intent(this, HomeActivity::class.java).apply {
            putExtras(loginBundle)
        }

        startActivity(loginIntent)
    }

}