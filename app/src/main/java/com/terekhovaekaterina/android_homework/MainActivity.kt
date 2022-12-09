package com.terekhovaekaterina.android_homework

import android.os.Bundle
import android.util.Log
import android.view.AbsSavedState
import androidx.appcompat.app.AppCompatActivity

const val OTHER_NAME: Int = 1

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OTHER_NAME
    }
}


abstract class BaseActivity : AppCompatActivity(){

    val tag :String
        get() = this::class.qualifiedName?: ""

    override fun onCreate(savedInstanceState: Bundle?){
        Log.d(tag,"onCreate")
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