package com.redhunter.disneysong.ui

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.redhunter.disneysong.LoginActivity
import com.redhunter.disneysong.R
import com.redhunter.disneysong.databinding.ActivityPlayBinding
import com.redhunter.disneysong.model.CompetitorData
import com.redhunter.disneysong.model.Competitors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayBinding
    private val viewModel by viewModels<SongViewModel>()
    private var state = true
    private var image = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)


        observer()
        actions()

    }

    private fun calls() {
        viewModel.getSong()
        viewModel.getResult()
    }

    private fun observer() {
        viewModel.dataSong.observe(this, {
            playMusic(it.song)
            image = it.image
        })

        viewModel.imageSong.observe(this, {
            binding.btnPlay.isEnabled = true
            state = false
        })
    }

    private fun actions() {
        binding.btnPlay.setOnClickListener {
            if (state) {
                calls()
                binding.btnPlay.isEnabled = false
                chanceIcon(R.drawable.ic_question)
                if (image != 0) {
                    reveledSong(R.drawable.background_play)
                }
            } else {
                chanceIcon(R.drawable.ic_play)
                reveledSong(image)
                initRecycler(Competitors.data)
                showModal()
                state = true

            }
        }

        binding.modal.close.setOnClickListener {
            binding.modal.root.visibility = View.GONE
        }

        binding.btnClose.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
                finish()
        }
        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,CongratsActivity::class.java))
            finish()
        }


    }

    private fun initRecycler(competitors: List<CompetitorData>) {
        val adapter = CompetitorAdapter(competitors, onclickListener = { onClick(it) })
        binding.modal.rvCompetitors.adapter = adapter
    }

    private fun onClick(competitor: String) {
        Competitors.data.forEach {
            if (it.name == competitor) {
                it.point += 1
            }
        }
        binding.modal.root.visibility = View.GONE
    }

    private fun showModal() {
        CoroutineScope(Dispatchers.IO).launch {
            Thread.sleep(2000)
            runOnUiThread {
                binding.modal.root.visibility = View.VISIBLE
            }
        }
    }

    private fun reveledSong(image: Int) {
            binding.imageSong.animate().apply {
                rotationYBy(360f)
            }.withEndAction {
                binding.imageSong.setImageResource(image)
            }
    }

    private fun chanceIcon(image: Int) {
        binding.btnPlay.animate().apply {
            rotationYBy(360f)
        }.withEndAction {
            binding.btnPlay.setImageResource(image)
        }
    }

    private fun playMusic(song: Int) {
        val reproducer = MediaPlayer.create(this, song)
        CoroutineScope(Dispatchers.IO).launch {
            reproducer.start()
        }
    }

}