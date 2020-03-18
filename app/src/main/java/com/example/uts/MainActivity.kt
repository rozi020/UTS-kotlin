package com.example.uts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_logout.setOnClickListener{
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@MainActivity,Login::class.java))
            finish()
        }
        data.setOnClickListener{
            startActivity(Intent(this@MainActivity,Databerita::class.java))
            finish()
        }
        tambah.setOnClickListener{
            startActivity(Intent(this@MainActivity,Inputberita::class.java))
            finish()
        }
    }
}
