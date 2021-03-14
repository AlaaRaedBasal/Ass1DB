package com.example.ass1db

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.useritem.view.*

class UserAdapter (var act: Activity, var data:MutableList<UserModel>)
    :RecyclerView.Adapter<UserAdapter.ViewHolder>() {
       var db= FirebaseFirestore.getInstance()

        class ViewHolder(item: View) : RecyclerView.ViewHolder(item)  {
            val username = item.username
            val phonenumber = item.phonenumber
            val address = item.address


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            var inflate = LayoutInflater.from(act).inflate(R.layout.useritem, parent, false)
            return ViewHolder(inflate)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder:ViewHolder, position: Int) {
            holder.username.text = data[position].name
            holder.phonenumber.text = data[position].phone
            holder.address.text = data[position].address

        }}