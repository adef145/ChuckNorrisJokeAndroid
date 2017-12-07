package com.adefruandta.chucknorrisjoke.adapters.category

import android.view.View
import android.widget.TextView
import com.adefruandta.chucknorrisjoke.R
import com.adefruandta.viper.others.bindView
import com.adefruandta.viper.viewholders.ViperRecyclerViewHolder

/**
 * Created by adefruandta on 11/22/17.
 */

class CategoryViewHolder(itemView: View) : ViperRecyclerViewHolder<String>(itemView) {

    // region Attributes

    private val tvCategory: TextView by bindView(R.id.tvCategory)

    // endregion

    // region ViperRecyclerViewHolder

    override fun onBind(data: String) {
        super.onBind(data)

        tvCategory.text = data
    }

    // endregion
}
