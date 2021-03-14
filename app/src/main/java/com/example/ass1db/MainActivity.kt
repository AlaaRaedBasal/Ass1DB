package com.example.ass1db

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseFirestore.getInstance()

        save_btn.setOnClickListener {

            val name = userNameET.text.toString()
            val phone = phoneET.text.toString()
            val address = addressET.text.toString()


            val product: MutableMap<String, Any> = HashMap()
            product["name"] = name
            product["phone"] = phone
            product["address"] = address
            db.collection("Users")
                .add(product)
                .addOnSuccessListener { Log.d("TAG", "Data added success") }
                .addOnFailureListener { Log.d("TAG", "Data added Faild") }
            val intent = Intent(baseContext, AllUser::class.java)
            startActivity(intent)

        }

    }
}