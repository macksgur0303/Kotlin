package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.content.Context

class UserAdapter (val context: Context, val Userlist: ArrayList<User>) : BaseAdapter() {
    override fun getCount(): Int {
        return Userlist.size // Userlist 배열 크기 확인
    }

    override fun getItem(position: Int): Any {
        return Userlist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null)

        val profile = view.findViewById<ImageView>(R.id.ivProfile)
        val name = view.findViewById<TextView>(R.id.tvName)
        val age = view.findViewById<TextView>(R.id.tvAge)
        val greet = view.findViewById<TextView>(R.id.tvGreet)

        val user = Userlist[position]

        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        return view

    }
}