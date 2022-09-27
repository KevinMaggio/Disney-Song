package com.redhunter.disneysong.ui.competitors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.redhunter.disneysong.databinding.ActivityCompetitorsBinding
import com.redhunter.disneysong.model.CompetitorData
import com.redhunter.disneysong.model.Competitors
import com.redhunter.disneysong.ui.PlayActivity

class CompetitorsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCompetitorsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompetitorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        checkField()
        actions()
    }

    fun getBundle(): String {
        return intent.getStringExtra("quantity").toString()
    }

    fun actions(){
        binding.enter.setOnClickListener {
            chargeList()
            val intent= Intent(this,PlayActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
    fun init(){
        binding.competitor1.visibility= View.GONE
        binding.competitor2.visibility= View.GONE
        binding.competitor3.visibility= View.GONE
        binding.competitor4.visibility= View.GONE
        binding.competitor5.visibility= View.GONE
        binding.competitor6.visibility= View.GONE
        binding.competitor7.visibility= View.GONE
        binding.competitor8.visibility= View.GONE
    }
    private fun chargeList(){
        checkEmpty(binding.competitor1.text.toString())
        checkEmpty(binding.competitor2.text.toString())
        checkEmpty(binding.competitor3.text.toString())
        checkEmpty(binding.competitor4.text.toString())
        checkEmpty(binding.competitor5.text.toString())
        checkEmpty(binding.competitor6.text.toString())
        checkEmpty(binding.competitor7.text.toString())
        checkEmpty(binding.competitor8.text.toString())
    }

    private fun checkEmpty(value:String){
        if (value.isNotEmpty()){
            Competitors.data.add(CompetitorData( value,0))
        }
    }

    fun checkField(){
        when(getBundle()){
            "1" ->{binding.competitor1.visibility= View.VISIBLE}
            "2" ->{binding.competitor1.visibility= View.VISIBLE
                binding.competitor2.visibility= View.VISIBLE}
            "3" ->{binding.competitor1.visibility= View.VISIBLE
                binding.competitor2.visibility= View.VISIBLE
                binding.competitor3.visibility= View.VISIBLE}
            "4" ->{binding.competitor1.visibility= View.VISIBLE
                binding.competitor2.visibility= View.VISIBLE
                binding.competitor3.visibility= View.VISIBLE
                binding.competitor4.visibility= View.VISIBLE}
            "5" ->{binding.competitor1.visibility= View.VISIBLE
                binding.competitor2.visibility= View.VISIBLE
                binding.competitor3.visibility= View.VISIBLE
                binding.competitor4.visibility= View.VISIBLE
                binding.competitor5.visibility= View.VISIBLE}
            "6" ->{binding.competitor1.visibility= View.VISIBLE
                binding.competitor2.visibility= View.VISIBLE
                binding.competitor3.visibility= View.VISIBLE
                binding.competitor4.visibility= View.VISIBLE
                binding.competitor5.visibility= View.VISIBLE
                binding.competitor6.visibility= View.VISIBLE}
            "7" ->{binding.competitor1.visibility= View.VISIBLE
                binding.competitor2.visibility= View.VISIBLE
                binding.competitor3.visibility= View.VISIBLE
                binding.competitor4.visibility= View.VISIBLE
                binding.competitor5.visibility= View.VISIBLE
                binding.competitor6.visibility= View.VISIBLE
                binding.competitor7.visibility= View.VISIBLE}
            "8" ->{
                binding.competitor1.visibility= View.VISIBLE
                binding.competitor2.visibility= View.VISIBLE
                binding.competitor3.visibility= View.VISIBLE
                binding.competitor4.visibility= View.VISIBLE
                binding.competitor5.visibility= View.VISIBLE
                binding.competitor6.visibility= View.VISIBLE
                binding.competitor7.visibility= View.VISIBLE
                binding.competitor8.visibility= View.VISIBLE
            }
        }
    }
}