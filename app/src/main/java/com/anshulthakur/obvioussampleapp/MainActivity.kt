package com.anshulthakur.obvioussampleapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.anshulthakur.obvioussampleapp.adapters.GridViewAdapter
import com.anshulthakur.obvioussampleapp.extensions.showMessage
import com.anshulthakur.obvioussampleapp.model.NasaPictureData
import com.anshulthakur.obvioussampleapp.model.PicturesData
import com.anshulthakur.obvioussampleapp.utils.OnItemClick
import com.anshulthakur.obvioussampleapp.utils.TimeUtils
import com.anshulthakur.obvioussampleapp.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity(), OnItemClick {

    val adapter by lazy { GridViewAdapter(this) }

    val nasaPictureData by lazy { ArrayList<NasaPictureData>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAdapter()
        getData()
    }

    private fun setAdapter() {
        rvMainGrid.layoutManager = GridLayoutManager(this, 2)
        rvMainGrid.adapter = adapter
    }

    @SuppressLint("SimpleDateFormat")
    private fun getData() {
        val jsonData: String? = Utils.getJsonFromAssets(this, "data.json")
        if (jsonData != null) {
            val listType = object : TypeToken<List<NasaPictureData>>() {}.type
            val parsedData: List<NasaPictureData> = Gson().fromJson(jsonData, listType)
            //Reorder the list to get latest on top
            val sortedList = parsedData.sortedByDescending { TimeUtils.getMillisFromStringDate(it.date) }
            //to send list to next activity
            nasaPictureData.addAll(sortedList)
            adapter.addData(nasaPictureData)
        } else {
            showMessage(this, "Failed to load Json data.")
        }
    }

    override fun onItemClick(any: Any) {
        when (any) {
            is PicturesData -> {
                //Show details of the image with animation
                val bundle: Bundle? = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(this, any.view, any.view.transitionName)
                        .toBundle()
                val intent = Intent(this@MainActivity, FullScreenActivity::class.java)
                intent.putExtra("pictureData", nasaPictureData)
                intent.putExtra("position", any.position)
                startActivity(intent, bundle)
            }
        }
    }
}
