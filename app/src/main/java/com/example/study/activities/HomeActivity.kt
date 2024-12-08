package com.example.study.activities

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.study.AppConstants
import com.example.study.R

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Status bar trong suốt trong các phiên bản
        setContentView(R.layout.activity_home) // Set view layout

//      Cập nhật màu sắc biểu tượng trên thanh status bar có độ tương phản
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
            true

        getDataFromBundle()
    }

    private fun getDataFromBundle() {
        val loginExtras = intent.extras
        if (loginExtras != null) {
            val userInfo = loginExtras.getString(AppConstants.USER_INFO_KEY)

            val textView = findViewById<TextView>(R.id.textView)
            val welcomeMsg = "Chào mừng $userInfo đến với Đại học Kiên Giang"
            textView.text = welcomeMsg
        }
    }
}