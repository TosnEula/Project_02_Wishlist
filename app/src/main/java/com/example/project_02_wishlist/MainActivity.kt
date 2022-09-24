package com.example.project_02_wishlist

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishListRV = findViewById<RecyclerView>(R.id.wishListRV)        //Defining a variable to get the recycle view from activity_main
        val wishListItems : MutableList<WishListItem> = ArrayList()     //Create an array of list of wishlist items to pass to the adapter
        val adapter = WishListItemAdapter(wishListItems)         //create the adapter for recycle view
        wishListRV.adapter = adapter
        wishListRV.layoutManager = LinearLayoutManager(this)

        //Define a variable for the submit button
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        //Define variables for the edit text fields
        val itemPrice = findViewById<EditText>(R.id.priceET)
        val itemUrl = findViewById<EditText>(R.id.itemUrlET)
        val itemName = findViewById<EditText>(R.id.itemNameET)



        submitBtn.setOnClickListener(){
            hideKeyboard()
            var newListItem = WishListItem(itemName.text.toString(), itemPrice.text.toString(), itemUrl.text.toString())
            wishListItems.add(newListItem)
            itemName.text.clear()
            itemPrice.text.clear()
            itemUrl.text.clear()
            adapter.notifyDataSetChanged()
        }


    }
}