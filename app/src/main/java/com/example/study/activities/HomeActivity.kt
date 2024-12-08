package com.example.study.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.study.AppConstants
import com.example.study.R

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home) // Set view layout

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