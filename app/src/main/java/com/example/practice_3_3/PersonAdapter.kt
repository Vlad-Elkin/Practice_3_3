package com.example.practice_3_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(private val persons:List<Person>)
    :RecyclerView.Adapter<PersonAdapter.PersonHolder>() {

    class PersonHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var gender_imageView: ImageView = itemView.findViewById(R.id.gender_imageView)
        var name_textView: TextView = itemView.findViewById(R.id.name_textView)
        var phoneNumber_textView: TextView = itemView.findViewById(R.id.phoneNumber_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_item,parent,false)
        return PersonHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        when(persons[position].sex){
            Gender.MALE -> holder.gender_imageView.setImageResource(R.drawable.male_person)
            Gender.FEMALE -> holder.gender_imageView.setImageResource(R.drawable.female_person)
            Gender.UNKNOWN -> holder.gender_imageView.setImageResource(R.drawable.unknown_person)
        }
        holder.name_textView.text = persons[position].name
        holder.phoneNumber_textView.text = persons[position].phoneNumber
    }

    override fun getItemCount(): Int = persons.size

}