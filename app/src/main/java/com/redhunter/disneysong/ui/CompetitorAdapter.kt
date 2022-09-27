package com.redhunter.disneysong.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.redhunter.disneysong.R
import com.redhunter.disneysong.databinding.ItemCompetitorBinding
import com.redhunter.disneysong.model.CompetitorData

class CompetitorAdapter(private val competitors:List<CompetitorData>,private val onclickListener : (String) -> Unit): RecyclerView.Adapter<CompetitorHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitorHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.item_competitor,parent,false)
        return CompetitorHolder(view)
    }

    override fun onBindViewHolder(holder: CompetitorHolder, position: Int) {
        holder.render(competitors[position], onclickListener)
    }

    override fun getItemCount(): Int {
        return competitors.size
    }
}

class CompetitorHolder(view:View):RecyclerView.ViewHolder(view){

    private val binding= ItemCompetitorBinding.bind(view)
    fun render(competitor:CompetitorData, OnclickListener : (String) -> Unit){
        binding.competitorName.setOnClickListener { OnclickListener(competitor.name) }
        binding.competitorName.text= competitor.name
    }
}