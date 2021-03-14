package com.example.ass1db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_all_user.*

class AllUser : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_user)
        getAllUser()
    }
    fun getAllUser() {
        val Users = mutableListOf<UserModel>()
        db!!.collection("Users").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val id = document.id
                        val data = document.data
                        val name = data["name"] as String?
                        val phone = data["phone"] as String?
                        val address = data["address"] as String?

                        Users.add(UserModel(id, name,phone,address))
                    }
                    recycle_All_user.layoutManager = LinearLayoutManager(this)
                    recycle_All_user.setHasFixedSize(true)
                    val userAdapter = UserAdapter(this, Users)
                    recycle_All_user.adapter = userAdapter
                }
            }
    }

}