package com.development.mercebauza.crumble

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var imgCookie: ImageView
    private lateinit var lblName: TextView
    private lateinit var lblStory: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaring variables with type ImageView and TextView

        //In activity_main we have defined the ids, so we find them with findViewById
        imgCookie = findViewById(R.id.imgCookie)
        lblName = findViewById(R.id.lblName)
        lblStory = findViewById(R.id.lblStory)
        val btnLike: Button =  findViewById(R.id.btnLike)
        val btnDislike: Button =  findViewById(R.id.btnDislike)

        val cookie = Cookie("Mr Peanut", R.drawable.peanut_cookie, "Loves to code", "mmmm!! yummy","ecs!! disgusting" )

        showCookie(cookie)

        btnLike.setOnClickListener{
            Toast.makeText(this@MainActivity, cookie.likedMessage, Toast.LENGTH_SHORT).show()
        }

        btnDislike.setOnClickListener{
            Toast.makeText(this@MainActivity, cookie.dislikeMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun showCookie(cookie:Cookie){
        imgCookie.setImageResource(cookie.image)
        lblName.text = cookie.name
        lblStory.text = cookie.story
    }

    data class Cookie(val name: String, val image: Int, val story: String, val likedMessage: String, val dislikeMessage: String)

}
