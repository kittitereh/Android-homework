//package com.terekhovaekaterina.android_homework
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import androidx.activity.viewModels
//import by.kirich1409.viewbindingdelegate.viewBinding
//import com.terekhovaekaterina.android_homework.Presentation.common.BaseActivity
//import com.terekhovaekaterina.android_homework.Presentation.details.FilmDetailActivity
//import com.terekhovaekaterina.android_homework.Presentation.registration.RegistrationActivity
//import com.terekhovaekaterina.android_homework.Presentation.search.SearchActivity
//import com.terekhovaekaterina.android_homework.Presentation.search_result.Film
//import com.terekhovaekaterina.android_homework.Presentation.search_result.SearchResultViewModel
//import com.terekhovaekaterina.android_homework.databinding.TopMemeLayoutBinding
//
//class TopMemesActivity: BaseActivity() {
//
//    private val ViewModel by viewModels<SearchResultViewModel>()
//    private val viewBoolean by viewBinding(TopMemeLayoutBinding::bind)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        viewBinding.mainSearch.setOnclickListener{
//            openSearch()
//        }
//
//        val button: Button? = findViewById<Button>(R.id.registrationButton)
//        button?.setOnClickListener {
//            Log.i("MainActivity", "Button 'Enter' was clicked")
//
//            val intent = Intent(this, RegistrationActivity::class.java)
//            startActivity(intent)
//
//        }
//
//        findViewById<Button>(R.id.test_button)?.setOnClickListener {
//            openDetail()
//        }
//
//        findViewById<Button>(R.id.search_button)?.setOnClickListener {
//            openSearch()
//        }
//    }
//
//    private fun openSearch() {
//        startActivity(Intent(this, SearchActivity::class.java))
//    }
//
//    private fun openDetail() {
//        val film = Film(
//            "Властелин колец",
//            2003
//        )
//
//        startActivity(
//            Intent(this, FilmDetailActivity::class.java)
//                .apply {
//                    putExtra(FilmDetailActivity.FILM_DETAIL_ARGUMENT_KEY, film)
//                },
//        )
//
//    }
//}




