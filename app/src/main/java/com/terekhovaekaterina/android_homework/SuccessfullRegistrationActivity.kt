package com.terekhovaekaterina.android_homework

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button


class SuccessfullRegistrationActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successfull_registration)

        val nextButton: Button? = findViewById<Button>(R.id.NextButton)
        nextButton?.setOnClickListener {
            Log.i("RegistrationActivity", "Button 'Enter' was clicked")

            val intent = Intent(this, SuccessfullRegistrationActivity::class.java)
            startActivity(intent)

        }

    }

}