package app.el_even.com.exo1.api

import android.net.Uri
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import app.el_even.com.exo1.data.GithubRepo
import app.el_even.com.exo1.result.GithubAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("getListData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<GithubRepo>?) {
    val adapter = recyclerView.adapter as GithubAdapter
    adapter.submitList(data)
}

@BindingAdapter("displaySrc")
fun bindImage(imageView: ImageView, imgSrc: String?) {
    imgSrc?.let {
        val uri = it.toUri().buildUpon().scheme("https").build()
        Picasso.get().load(uri).into(imageView)
    }

}