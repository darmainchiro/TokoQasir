package id.ajiguna.tokoqasir.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import id.ajiguna.tokoqasir.R

@BindingAdapter("loadImage")
fun loadImage(imageView: ImageView, urlString: String?) {
    urlString?.let {
        Glide.with(imageView)
            .load(urlString)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_error)
            .into(imageView)
    }
}