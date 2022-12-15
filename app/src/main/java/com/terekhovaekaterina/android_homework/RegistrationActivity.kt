package com.terekhovaekaterina.android_homework

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button


class RegistrationActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


//        fun getLogin() {
//            val login = enterLogin.text.toString()
//        }
//
//        fun getPassword() {
//            val password = enterPassword.text.toString()
//        }

        val enterButton: Button? = findViewById<Button>(R.id.EnterButton)
        enterButton?.setOnClickListener {
            Log.i("RegistrationActivity", "Button 'Enter' was clicked")
//            getLogin()
//            getPassword()

            val intent = Intent(this, SuccessfullRegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}