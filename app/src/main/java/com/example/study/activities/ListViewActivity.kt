package com.example.study.activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.study.R
import com.example.study.showToast

class ListViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view) // Set view layout

        val listView = findViewById<ListView>(R.id.listView)
        val items = resources.getStringArray(R.array.list_array)
        val adapter = ArrayAdapter(
            this,
            R.layout.activity_my_list,
            R.id.textView,
            items
        )

        listView.adapter = adapter

        // parent: AdapterView<*> - chính là ListView.
        // view: View - View của item được click.
        // position: Int - Vị trí của item trong danh sách.
        // id: Long - ID của item được click.

        listView.setOnItemClickListener{parent, view, position, id ->
            val selectedItem = items[position]
            Log.i("parent", parent.toString())
            Log.i("view", view.toString())
            Log.i("id", id.toString())
            Log.i("position", position.toString())
//            showToast(selectedItem)
            showPopupMenu(view, selectedItem)
        }

    }

    private fun showPopupMenu(view: View, selectedItem: String) {
        val popupMenu = PopupMenu(this, view)
        menuInflater.inflate(R.menu.menu_item, popupMenu.menu)

        // Xử lý click vào menu item
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_profile -> {
                    showToast("Ho so")
                    true
                }

                R.id.action_settings -> {
                    showToast("Cài đặt")
                    true
                }

                R.id.action_logout -> {
                    showToast("Đăng xuất")
                    true
                }

                else -> false
            }
        }
        popupMenu.show()
    }

}