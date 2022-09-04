package com.project.logintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.project.logintest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var auth: FirebaseAuth? = null //파이어베이스 인증

    //유저 정보 불러오기 (아이디, 닉네임 등)
    private var user: FirebaseUser? = null
    private lateinit var UserDB: DatabaseReference //실시간 데이터베이스
    private var userID: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        user = FirebaseAuth.getInstance().currentUser
        UserDB = FirebaseDatabase.getInstance().getReference("User")
        userID = user!!.uid

        UserDB.child(userID!!).addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val nickname = snapshot.child("Nickname").value.toString()
                binding.userNameTextView.text = "${nickname.toString()}"
                //val nickname = snapshot.value
                //binding.userNameTextView.text = "${nickname.toString()}"
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}