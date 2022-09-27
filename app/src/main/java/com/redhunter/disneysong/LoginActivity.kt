package com.redhunter.disneysong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.redhunter.disneysong.databinding.ActivityLoginBinding
import com.redhunter.disneysong.ui.competitors.CompetitorsActivity

class LoginActivity : AppCompatActivity() {

    private var quantity = MutableLiveData(1)
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observers()
        actions()

    }

    private fun observers() {
        quantity.observe(this, {
            binding.quantity.text = it.toString()
        })
    }

    private fun actions() {
        binding.btNext.setOnClickListener {
            if (quantity.value!! <= 7) {
                quantity.postValue(quantity.value?.plus(1))
            }
        }
        binding.btPrevious.setOnClickListener {
            if (quantity.value!! > 1) {
                quantity.postValue(quantity.value?.minus(1))
            }
        }
        binding.btEnter.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("quantity", quantity.value.toString())
            val intent= Intent(this, CompetitorsActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }
    }
}