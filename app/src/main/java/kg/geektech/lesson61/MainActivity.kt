package kg.geektech.lesson61

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.lesson61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>

    companion object{
        const val KEY = "key"
        const val KEY_BACK = "keyBack"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            if (binding.editText.text.toString().isEmpty()){
                Toast.makeText(this,getString(R.string.enter_text),Toast.LENGTH_SHORT).show()
            }else{
                Intent(this,SecondActivity::class.java).apply {
                    putExtra(KEY,binding.editText.text.toString())
                    registerForActivityResult.launch(this)
                }
            }

        }

        registerForActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()
        ) { result ->
            binding.editText.setText(result.data?.getStringExtra(KEY_BACK))
        }
    }
}
