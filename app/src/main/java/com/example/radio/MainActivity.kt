package com.example.radio

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaParser
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.security.AccessControlContext

class MainActivity : AppCompatActivity() {
    private lateinit var Bplay:Button
    private lateinit var Bpause:Button
    private lateinit var Bnext:Button
    private lateinit var MPlayer:MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Bplay = findViewById(R.id.buttonPlay)
        Bpause = findViewById(R.id.buttonPause)
        Bnext = findViewById(R.id.buttonNext)
        RadioOnda()
        Next()

    }

    private fun RadioOnda(){
        val url = "https://streaming.gometri.com/stream/8011/stream/1/"

        MPlayer = MediaPlayer()
        MPlayer.setDataSource(url)
        MPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        MPlayer.prepareAsync()

        MPlayer.setOnPreparedListener {
            Play(this)
        }
    }

    private fun Play(context: Context){
        Bplay.setOnClickListener {
            MPlayer.start()
           Toast.makeText(context, "En play.....", Toast.LENGTH_SHORT).show()
        }
        Bpause.setOnClickListener {
            MPlayer.pause()
            Toast.makeText(context, "En pause.....", Toast.LENGTH_SHORT).show()

        }
    }

    private fun Next(){
        Bnext.setOnClickListener {
            val int = Intent(this,oxigeno::class.java)
            this.startActivity(int)
            MPlayer.release()
        }
    }
}