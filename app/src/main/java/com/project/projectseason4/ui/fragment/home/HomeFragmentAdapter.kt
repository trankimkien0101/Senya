package com.project.projectseason4.ui.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.projectseason4.R
import com.project.projectseason4.data.Attraction
import com.project.projectseason4.databinding.ViewHolderAttractionBinding
import com.squareup.picasso.Picasso

class HomeFragmentAdapter(
    private val onClickedCallback:() -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val attraction = ArrayList<Attraction>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return AttractionViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AttractionViewHolder).onBind(attraction[position],onClickedCallback)
    }

    override fun getItemCount(): Int {
        return attraction.size
    }
    fun setData(attraction: List<Attraction>){
        this.attraction.clear()
        this.attraction.addAll(attraction)
        notifyDataSetChanged()
    }

    inner class AttractionViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_attraction,parent,false)
    ){
        private val binding = ViewHolderAttractionBinding.bind(itemView)
        fun onBind(attraction: Attraction, onClicked:()->Unit){
            binding.titleTextView.text = attraction.title
            Picasso.get().load(attraction.image_urls).into(binding.headerImageView)
            binding.monthsToVisitTextView.text= attraction.months_to_visit
            binding.root.setOnClickListener {
                onClicked()
            }

        }
    }

}