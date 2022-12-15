package com.terekhovaekaterina.android_homework

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.AbsSavedState
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val OTHER_NAME: Int = 1

class MainActivity : BaseActivity() {

    companion object {
        private val COUNTER_KEY = "COUNTER_KEY"
    }

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button? = findViewById<Button>(R.id.registrationButton)
        button?.setOnClickListener {
            Log.i("MainActivity", "Button 'Enter' was clicked")

            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)

        }

    }

//    private fun add(){
//        counter += 1
//        updateCounter()
//    }
//
//    private fun updateCounter(){
//        findViewById<TextView>(R.id.mainCounterText)?.apply{
//                text = counter.toString()
//        }
//    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putInt(COUNTER_KEY, counter)
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.getInt(COUNTER_KEY, 0)
        // updateCounter()
        super.onRestoreInstanceState(savedInstanceState)
    }
}



abstract class BaseActivity : AppCompatActivity(){

    private val tag :String
        get() = this::class.qualifiedName?: ""

    override fun onCreate(savedInstanceState: Bundle?){
        Log.d(tag,"onCreate $savedInstanceState")
        super.onCreate(savedInstanceState)
    }

    override fun onRestart() {
        Log.d(tag, "onRestart")
        super.onRestart()
    }

    override fun onStart() {
        Log.d(tag,"onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(tag, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(tag, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(tag, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(tag, "onDestroy")
        super.onDestroy()
    }



}