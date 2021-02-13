package com.shon.workservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shon.services.ServiceEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startService(Intent(this,TestService::class.java))
    }

    override fun onResume() {
        super.onResume()


        Thread {
            for (i in 0..10) {
                ServiceEvent.sendEvent(i)
                Thread.sleep(1000)
            }
        }.start()
    }
}