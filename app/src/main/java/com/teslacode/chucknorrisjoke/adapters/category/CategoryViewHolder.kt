package com.teslacode.chucknorrisjoke.adapters.category

import android.view.View
import android.widget.TextView
import com.teslacode.chucknorrisjoke.R
import com.teslacode.viper.others.bindView
import com.teslacode.viper.viewholders.ViperRecyclerViewHolder

/**
 * Created by adefruandta on 11/22/17.
 */

class CategoryViewHolder(itemView: View) : ViperRecyclerViewHolder<String>(itemView) {

    private val tvCategory: TextView by bindView(R.id.tvCategory)

    override fun onBind(data: String) {
        super.onBind(data)

        tvCategory.text = data
    }
}
