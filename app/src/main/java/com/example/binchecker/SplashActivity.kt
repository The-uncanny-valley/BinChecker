package com.example.binchecker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val splashDelay: Long = 3000 // 3 секунды

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sunImage = findViewById<ImageView>(R.id.sun)
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_star)
        sunImage.startAnimation(rotateAnimation)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashDelay)
    }
}