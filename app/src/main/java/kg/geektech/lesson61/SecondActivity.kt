package kg.geektech.lesson61

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.lesson61.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editText.setText(intent.getStringExtra(MainActivity.KEY))
        binding.btnGo.setOnClickListener {
            setResult(RESULT_OK,Intent().putExtra(MainActivity.KEY_BACK,binding.editText.text.toString()))
            finish()
        }
    }
}