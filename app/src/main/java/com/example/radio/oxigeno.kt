package com.example.radio

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class oxigeno : AppCompatActivity() {
    private lateinit var BPlayPause:Button
    private lateinit var BBack:Button
    private lateinit var Mplayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oxigeno)

        BPlayPause=findViewById(R.id.buttonPlayPause)
        BBack = findViewById(R.id.buttonBack)
    }

    private fun RadioOxigeno(){
        val url = "https://us-b4-p-e-ft6-audio.cdn.mdstrm.com/live-audio-aw/5fada54116646e098d97e6a5"
        Mplayer = MediaPlayer().apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(url)
            prepare()
        }
        Mplayer.setOnPreparedListener {
            PlayOxigeno(this)
        }
    }

    private fun PlayOxigeno(context: Context){

    }
}