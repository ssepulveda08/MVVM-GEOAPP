package com.ssepulveda.geoapp.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: Boolean) {
    view.visibility = if(visibility) View.VISIBLE else View.GONE
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    view.text = text?.value ?: ""
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
    adapter.notifyDataSetChanged()
}

@BindingAdapter("setImageGlide")
fun setImageGlide(imageView:  ImageView, url: String) {
    Picasso.get().load(url).into(imageView)
}

