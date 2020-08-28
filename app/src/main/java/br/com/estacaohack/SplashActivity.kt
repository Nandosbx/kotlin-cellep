package br.com.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    // it is a method in the cycle of activity's life
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Open Login Activity after 5 seconds.
        Handler(Looper.getMainLooper()).postDelayed({
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        },
            5000)
    }
}