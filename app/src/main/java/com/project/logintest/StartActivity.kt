package com.project.logintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.logintest.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonClickEvent()
    }

    private fun buttonClickEvent() = with(binding) {
        registerOwnerButton.setOnClickListener {
            val intent = Intent(this@StartActivity, JoinOwner::class.java)
            startActivity(intent)
        }
        registerUserButton.setOnClickListener {
            val intent = Intent(this@StartActivity, JoinUser::class.java)
            startActivity(intent)
        }
        loginButton.setOnClickListener {
            val intent = Intent(this@StartActivity, Login::class.java)
            startActivity(intent)
        }
    }
}