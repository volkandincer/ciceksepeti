package com.example.ciceksepeti

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ciceksepeti.ui.ProductListFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RestClient.initialize()

        val fragment: Fragment = ProductListFragment()
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, fragment, "")
            .addToBackStack(null).commit()

    }
}

