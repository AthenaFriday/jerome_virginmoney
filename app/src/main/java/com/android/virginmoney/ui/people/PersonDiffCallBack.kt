package com.android.virginmoney.ui.people

import androidx.recyclerview.widget.DiffUtil
import com.android.virginmoney.data.model.Person

class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id // Assume `id` is a unique identifier
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}
