package com.example.study.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.study.AppConstants
import com.example.study.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Status bar trong suốt trong các phiên bản
        setContentView(R.layout.activity_main) // Set view layout

//      Cập nhật màu sắc biểu tượng trên thanh status bar có độ tương phản
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
            true

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