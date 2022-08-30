package com.example.clothingapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.clothingapp.R
import com.example.clothingapp.ui.activities.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val ivShop = findViewById<ImageView>(R.id.iv_shop)
        ivShop.alpha = 0f
        ivShop.animate().setDuration(1500).alpha(1f).withEndAction {
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()

        }
    }
}