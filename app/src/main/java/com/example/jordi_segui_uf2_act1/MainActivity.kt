package com.example.jordi_segui_uf2_act1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.mario_wa_sfx)

        val playButton1 = findViewById<Button>(R.id.playButton_sound1)
        val stopButton1 = findViewById<Button>(R.id.stopButton_sound1)

        playButton1.setOnClickListener{
            mediaPlayer.start() 
            Log.d("miau", "Botó pressionat")
        }
        stopButton1.setOnClickListener{
            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()
                mediaPlayer.prepare() // Necessari per tornarlo a activar, es prepara per quan el cridin.
            }
        }
    }
}