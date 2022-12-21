package com.terekhovaekaterina.android_homework.Presentation.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.terekhovaekaterina.android_homework.Presentation.common.BaseActivity
import com.terekhovaekaterina.android_homework.Presentation.details.DetailsActivity
import com.terekhovaekaterina.android_homework.Presentation.details.FilmDetailActivity
import com.terekhovaekaterina.android_homework.Presentation.search_result.Film
import com.terekhovaekaterina.android_homework.R




class SuccessfullRegistrationActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successfull_registration)

        val nextButton: Button? = findViewById<Button>(R.id.NextButton)
        nextButton?.setOnClickListener {
            Log.i("DetailsActivity", "Button 'Далее' was clicked")

            openDetail()

        }

    }


    private fun openDetail(){
        val film = Film(
            "Властелин колец",
            2003
        )

        startActivity(Intent(this, DetailsActivity::class.java)
            .apply{
                putExtra(FilmDetailActivity.FILM_DETAIL_ARGUMENT_KEY, film)
            }
      )
    }

}