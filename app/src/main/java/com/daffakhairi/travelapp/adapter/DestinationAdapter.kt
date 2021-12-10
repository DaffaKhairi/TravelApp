package com.daffakhairi.travelapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffakhairi.travelapp.MainActivity
import com.daffakhairi.travelapp.data.Destinations
import com.daffakhairi.travelapp.databinding.RowItemDestinationBinding
import com.daffakhairi.travelapp.ui.HomeFragment

class DestinationAdapter (private val listDestination: ArrayList<Destinations>) : RecyclerView.Adapter<DestinationAdapter.myViewHolder>() {

    inner class myViewHolder(val binding : RowItemDestinationBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = myViewHolder (
        RowItemDestinationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.binding.apply {
            with(listDestination[position]){
                tvTitleItem.text = listDestination[position].title
                tvDescItem.text = listDestination[position].desc
                tvRatingsItem.text = listDestination[position].rating
                tvDateDepart.text = listDestination[position].dateDepart
                tvDateReturn.text = listDestination[position].dateReturn
                Glide.with(imageDestination.context).load(photo).into(imageDestination)
            }
        }
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, MainActivity::class.java)
//            intent.putExtra(HomeFragment, listDestination[position])
            it.context.startActivity(intent)
//            Toast.makeText(, "", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listDestination.size
}