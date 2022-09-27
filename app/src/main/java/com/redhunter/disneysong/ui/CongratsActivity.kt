package com.redhunter.disneysong.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.redhunter.disneysong.LoginActivity
import com.redhunter.disneysong.databinding.ActivityCongratsBinding
import com.redhunter.disneysong.model.CompetitorData
import com.redhunter.disneysong.model.Competitors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CongratsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCongratsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showView()
        actions()
    }

    private fun showView() {
        val result = Competitors.data.maxWithOrNull(compareBy { it.point })
        binding.winner.text = result?.name.toString()
    }

    private fun actions() {
        binding.root.setOnClickListener {
            Competitors.data.clear()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

}