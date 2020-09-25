package com.tutorialsbuzz.customtoolbarlayout

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import kotlinx.android.synthetic.main.search_layout.*
import kotlinx.android.synthetic.main.actionbar_layout_content.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        // set display options of the ActionBar
        actionBar?.apply {
            setDisplayShowTitleEnabled(false)
            setDisplayShowHomeEnabled(false)
            setDisplayShowCustomEnabled(true)
            setCustomView(R.layout.actionbar_layout_content)
        }

        //moreOption icon clickListener
        moreOption.setOnClickListener({
            showPopupMenu()
        })

        //searchView TextChangeListener
        searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(
                charSequence: CharSequence?, p1: Int, p2: Int, p3: Int
            ) {
            }

            override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (charSequence?.isEmpty()!!)
                    close_icon.visibility = View.GONE
                else
                    close_icon.visibility = View.VISIBLE
            }
        })

        //close icon click
        close_icon.setOnClickListener({
            searchView.setText("")
        })
    }

    private fun showPopupMenu() {
        val popupMenu = PopupMenu(this, moreOption)
        popupMenu.inflate(R.menu.popup_menu)
        popupMenu.show();
    }
}