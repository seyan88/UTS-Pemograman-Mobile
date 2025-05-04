package com.example.mecomic

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class AdapterList (private val itemLists: kotlin.collections.List<ItemList>) : RecyclerView.Adapter<AdapterList.ViewHolder>() {
    class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView  = itemView.findViewById(R.id.item_image)
        val judul: TextView = itemView.findViewById(R.id.title)
        val subJudul: TextView = itemView.findViewById(R.id.sub_tittle)
        val link: TextView = itemView.findViewById(R.id.link_Alternatif)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterList.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: AdapterList.ViewHolder, position: Int) {
        val item = itemLists[position]
        holder.judul.text = item.judul
        holder.subJudul.text = item.subJudul
        holder.link.text = item.link
        Glide.with(holder.imageView.context).load(item.imageUrl).into(holder.imageView)

        // Buat link bisa diklik
        holder.link.setOnClickListener {
            val url = item.link
            val context = holder.link.context
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            // Pastikan ada aplikasi yang bisa menangani intent
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            }
        }
    }
    override fun getItemCount(): Int {
    return itemLists.size
    }
}