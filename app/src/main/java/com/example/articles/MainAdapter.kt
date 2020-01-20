package com.example.articles

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_article_item.view.*

class MainAdapter(val homeFeed : HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRaw = layoutInflater.inflate(R.layout.layout_article_item, parent, false)
        return CustomViewHolder(cellForRaw)
    }

    override fun getItemCount(): Int = homeFeed.response.results.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val articleTitle = homeFeed.response.results[position]
        holder.itemView.title.text = articleTitle.fields.headline

        val thumbnailImageview = holder.itemView.image
        Picasso.get().load(articleTitle.fields.thumbnail).into(thumbnailImageview)

        holder.description = articleTitle


    }
}

class CustomViewHolder(view: View, var description : Items? = null):RecyclerView.ViewHolder(view){
    companion object{
        val description_link = "description_link"
    }
    init{
        view.setOnClickListener{
            val intent = Intent(view.context,DescriptionActivity::class.java)
            intent.putExtra(description_link, description?.fields?.shortUrl)

            view.context.startActivity(intent)
        }
    }
}



