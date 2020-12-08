package com.base.projectmovies.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.base.projectmovies.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions



@BindingAdapter("listImage")
fun bindImage(imageView: ImageView, url: String?) {
    Glide
        .with(imageView.context)
        .load(url)
        .centerCrop()
        .apply(RequestOptions.bitmapTransform(RoundedCorners(12)))
        .placeholder(R.drawable.place_holder)
        .into(imageView)
}

@BindingAdapter("app:autoStartMarquee")
fun setAutoStartMarquee(textView: TextView, autoStartMarquee: Boolean) {
    textView.isSelected = autoStartMarquee
}