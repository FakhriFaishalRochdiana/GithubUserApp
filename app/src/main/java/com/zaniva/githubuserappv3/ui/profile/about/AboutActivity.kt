package com.zaniva.githubuserappv3.ui.profile.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zaniva.githubuserappv3.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        val ab = supportActionBar
        ab?.title = "About"

    }
}