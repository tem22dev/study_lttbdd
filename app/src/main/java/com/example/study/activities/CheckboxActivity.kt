package com.example.study.activities

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.example.study.R
import com.example.study.showToast

class CheckboxActivity: AppCompatActivity() {

    private lateinit var androidCheckbox: CheckBox
    private lateinit var javaCheckBox: CheckBox
    private lateinit var cCheckBox: CheckBox
    private lateinit var allCheckBox: CheckBox
    private lateinit var btnCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox) // Set view layout
        init()
    }

    // Listener nhận sự kiện khi các CheckBox thay đổi trạng thái
    private val checkBoxListener = CompoundButton.OnCheckedChangeListener {buttonView, isChecked ->
        when (buttonView) {
            allCheckBox -> {
                detachListeners()
                setAllCheckBoxesState(isChecked)
                attachListeners()
            }
            else -> {
                showToast("${buttonView.text}: ${if (isChecked) "Checked" else "Unchecked"}")
                updateAllCheckBoxState()
            }
        }

        toggleButtonState()
    }

    // Gán listener cho tất cả CheckBox
    private fun attachListeners() {
        androidCheckbox.setOnCheckedChangeListener(checkBoxListener)
        javaCheckBox.setOnCheckedChangeListener(checkBoxListener)
        cCheckBox.setOnCheckedChangeListener(checkBoxListener)
        allCheckBox.setOnCheckedChangeListener(checkBoxListener)
    }

    // Loại bỏ listener khỏi tất cả CheckBox
    private fun detachListeners() {
        androidCheckbox.setOnCheckedChangeListener(null)
        javaCheckBox.setOnCheckedChangeListener(null)
        cCheckBox.setOnCheckedChangeListener(null)
        allCheckBox.setOnCheckedChangeListener(null)
    }

    // Cập nhật trạng thái CheckBox "All" dựa trên trạng thái các CheckBox con
    private fun updateAllCheckBoxState() {
        allCheckBox.setOnCheckedChangeListener(null)
        allCheckBox.isChecked = androidCheckbox.isChecked && javaCheckBox.isChecked && cCheckBox.isChecked
        allCheckBox.setOnCheckedChangeListener(checkBoxListener)
    }

    // Đặt trạng thái cho tất cả CheckBox con
    private fun setAllCheckBoxesState(state: Boolean) {
        androidCheckbox.isChecked = state
        javaCheckBox.isChecked = state
        cCheckBox.isChecked = state
    }

    private fun toggleButtonState() {
        btnCheck.isEnabled = allCheckBox.isChecked || androidCheckbox.isChecked || javaCheckBox.isChecked || cCheckBox.isChecked
    }

    // Hàm khởi tạo
    private fun init() {
        androidCheckbox = findViewById(R.id.android)
        javaCheckBox = findViewById(R.id.java)
        cCheckBox = findViewById(R.id.c)
        allCheckBox = findViewById(R.id.all)
        btnCheck = findViewById(R.id.button)
        toggleButtonState()
        attachListeners()
    }
}