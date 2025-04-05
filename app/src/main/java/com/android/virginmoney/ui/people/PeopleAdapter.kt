package com.athenafriday.virginmoney.ui.people

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.virginmoney.R
import com.android.virginmoney.data.model.Person

class PeopleAdapter : ListAdapter<Person, PeopleAdapter.PersonViewHolder>(PersonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
        private val emailTextView: TextView = itemView.findViewById(R.id.email_text_view)
        private val phoneTextView: TextView = itemView.findViewById(R.id.phone_text_view)
        private val jobTitleTextView: TextView = itemView.findViewById(R.id.job_title_text_view)

        @SuppressLint("SetTextI18n")
        fun bind(person: Person) {
            nameTextView.text = "${person.firstName} ${person.lastName}"
            emailTextView.text = person.email
            phoneTextView.text = person.phone
            jobTitleTextView.text = person.jobTitle

            // Set content descriptions for accessibility
            nameTextView.contentDescription = itemView.context.getString(R.string.name_content_description)
            emailTextView.contentDescription = person.email
            phoneTextView.contentDescription = person.phone
            jobTitleTextView.contentDescription = person.jobTitle
        }
    }
}

class PersonDiffCallback : DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.id == newItem.id // Assume `id` is a unique identifier
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}
