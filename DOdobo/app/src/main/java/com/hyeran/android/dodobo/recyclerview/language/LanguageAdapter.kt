package com.hyeran.android.dodobo.recyclerview.language

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R

// DataClass와 ViewHolder 연결
class LanguageAdapter(private var languageItems: ArrayList<LanguageItem>) : RecyclerView.Adapter<LanguageViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_language, parent, false)
        return LanguageViewHolder(mainView)
    }

    override fun getItemCount(): Int = languageItems.size

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.language.text = languageItems[position].language
    }
}
