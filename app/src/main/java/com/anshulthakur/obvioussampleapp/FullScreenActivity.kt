package com.anshulthakur.obvioussampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anshulthakur.obvioussampleapp.adapters.CustomViewPagerAdapter
import com.anshulthakur.obvioussampleapp.model.NasaPictureData
import kotlinx.android.synthetic.main.activity_full_screen.*

class FullScreenActivity : AppCompatActivity() {

    val adapter by lazy { CustomViewPagerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)

        supportActionBar?.title = "Image Details"
        setViewPager()
    }

    private fun setViewPager() {
        viewPager.adapter = adapter
        val list = intent.getSerializableExtra("pictureData") as List<NasaPictureData>
        adapter.addData(list)

        val pos = intent.getIntExtra("position", 0)
        viewPager.setCurrentItem(pos)
    }
}
