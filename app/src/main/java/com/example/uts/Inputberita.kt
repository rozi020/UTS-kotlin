package com.example.uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_inputberita.*
import org.json.JSONArray

class Inputberita : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inputberita)

        btn_kembali.setOnClickListener{
            startActivity(Intent(this@Inputberita,MainActivity::class.java))
            finish()
        }
        btn_tambah.setOnClickListener{
            var data_judulberita :String = judul_berita.text.toString()
            var data_waktuberita :String = waktu_berita.text.toString()
            var data_penulisberita :String = penulis_berita.text.toString()
            var data_isiberita :String = isi_berita.text.toString()
            postkeserver(data_judulberita, data_waktuberita, data_penulisberita , data_isiberita)

            startActivity(Intent(this@Inputberita,MainActivity::class.java))
        }
    }
    fun postkeserver(data1:String,data2:String,data3:String,data4:String){
        AndroidNetworking.post("http://192.168.0.8/berita/inputberita.php")
            .addBodyParameter("judul_berita",data1)
            .addBodyParameter("waktu_berita",data2)
            .addBodyParameter("penulis_berita",data3)
            .addBodyParameter("isi_berita",data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError) {

                }
            })
    }

}


