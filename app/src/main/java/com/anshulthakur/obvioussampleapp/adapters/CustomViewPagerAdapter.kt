package com.anshulthakur.obvioussampleapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.anshulthakur.obvioussampleapp.model.NasaPictureData
import androidx.core.widget.NestedScrollView
import com.anshulthakur.obvioussampleapp.R
import com.anshulthakur.obvioussampleapp.extensions.loadImageFromUrl
import com.anshulthakur.obvioussampleapp.utils.TimeUtils
import kotlinx.android.synthetic.main.layout_full_screen_image.view.*


/*
*Created By Anshul Thakur on 2/9/2020.
*/
class CustomViewPagerAdapter:PagerAdapter(){

    val list = ArrayList<NasaPictureData>()

    fun addData(newList:List<NasaPictureData>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
       return view === obj
    }

    @SuppressLint("SetTextI18n")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val layout = inflater.inflate(R.layout.layout_full_screen_image,container,false)

        layout.apply{
            tvTitle.text = list[position].title
            tvDescription.text = list[position].explanation
            tvAuthor.text = "(${list[position].copyright})"
            tvTime.text = TimeUtils.getReadableTimeFromString(list[position].date)
            tvThumbImage.loadImageFromUrl(context,list[position].url)

            if(list[position].copyright==null){
                tvAuthor.visibility = View.GONE
            }else{
                tvAuthor.visibility = View.VISIBLE
            }
        }



        container.addView(layout)
        return layout
    }

    override fun getCount(): Int = list.size

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as NestedScrollView)
    }
}