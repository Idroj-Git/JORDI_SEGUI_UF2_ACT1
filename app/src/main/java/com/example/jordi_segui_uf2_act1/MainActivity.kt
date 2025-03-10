package com.example.jordi_segui_uf2_act1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log

class MainActivity : AppCompatActivity() {
    //private lateinit var wahMediaPlayer: MediaPlayer
    //private lateinit var doomMediaPlayer: MediaPlayer
    private lateinit var upMediaPlayer: MediaPlayer
    private val activeWahPlayers = mutableListOf<MediaPlayer>()
    private val activeDoomPlayers = mutableListOf<MediaPlayer>()
    private val activeUpPlayers = mutableListOf<MediaPlayer>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //wahMediaPlayer = MediaPlayer.create(this, R.raw.mario_wa_sfx)
        //doomMediaPlayer = MediaPlayer.create(this, R.raw.doom_heavymetal_music)
        upMediaPlayer = MediaPlayer.create(this, R.raw.up_married_life)

        val playButtonWah = findViewById<Button>(R.id.playButton_soundMario)
        val stopButtonWah = findViewById<Button>(R.id.stopButton_soundMario)

        val playButtonDoom = findViewById<Button>(R.id.playButton_soundDoom)
        val stopButtonDoom = findViewById<Button>(R.id.stopButton_soundDoom)

        val playButtonUp = findViewById<Button>(R.id.playButton_soundUp)
        val stopButtonUp = findViewById<Button>(R.id.stopButton_soundUp)


        // WAH PLAYER / Create
        playButtonWah.setOnClickListener{
            val wahMediaPlayer = MediaPlayer.create(this, R.raw.mario_wa_sfx)
            wahMediaPlayer.setOnCompletionListener {
                it.release()
                activeWahPlayers.remove(it)
            }
            wahMediaPlayer.start()
            activeWahPlayers.add(wahMediaPlayer)
            Log.d("miau", "Botó de WAH pressionat")
        }
        stopButtonWah.setOnClickListener{
            activeWahPlayers.forEach{ wahMediaPlayer ->
                if (wahMediaPlayer.isPlaying){
                    wahMediaPlayer.stop()
                    wahMediaPlayer.prepare()
                    Log.d("wahStop", "Botó de pausa WAH pressionat")
                }
            }
            //if (wahMediaPlayer.isPlaying){
              //  wahMediaPlayer.stop()
                //wahMediaPlayer.prepare() // Necessari per tornarlo a activar, es prepara per quan el cridin.
            //}
        }

        // DOOM PLAYER / Create
        playButtonDoom.setOnClickListener{
            val doomMediaPlayer = MediaPlayer.create(this, R.raw.doom_heavymetal_music)
            doomMediaPlayer.setOnCompletionListener {
                it.release()
                activeDoomPlayers.remove(it)
            }
            doomMediaPlayer.start()
            activeDoomPlayers.add(doomMediaPlayer)
            Log.d("doomPlay", "Botó de Doom pressionat")
        }
        stopButtonDoom.setOnClickListener{
            activeDoomPlayers.forEach{ doomMediaPlayer ->
                if (doomMediaPlayer.isPlaying){
                    doomMediaPlayer.stop()
                    doomMediaPlayer.prepare()
                    Log.d("wahStop", "Botó de pausa DOOM pressionat")
                }
            }
        }

        // UP PLAY / Create
        playButtonUp.setOnClickListener{
            val upMediaPlayer = MediaPlayer.create(this, R.raw.up_married_life)
            upMediaPlayer.setOnCompletionListener {
                it.release()
                activeUpPlayers.remove(it)
            }
            upMediaPlayer.start()
            activeUpPlayers.add(upMediaPlayer)
            Log.d("upPlay", "Botó de UP pressionat")
        }
        stopButtonUp.setOnClickListener {
            activeUpPlayers.forEach{ upMediaPlayer ->
                if (upMediaPlayer.isPlaying){
                    upMediaPlayer.stop()
                    upMediaPlayer.prepare()
                    Log.d("wahStop", "Botó de pausa UP pressionat")
                }
            }
        }
    }
}