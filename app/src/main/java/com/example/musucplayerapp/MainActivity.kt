package com.example.musucplayerapp

import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.musucplayerapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var playerView = binding.playerViewPv
        val player = ExoPlayer.Builder(this).build()

        playerView.player = player

        val mediaItem = MediaItem.fromUri(Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"))

        player.setMediaItem(mediaItem)
        player.prepare()

        binding.PlayButtonBtn.setOnClickListener {
            player.play()
        }

        binding.StopButtonBtn.setOnClickListener {
            player.pause()
        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
//    }
}