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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            if (binding.editText.text.toString().isEmpty()){
                Toast.makeText(this,"Введите текст",Toast.LENGTH_SHORT).show()
            }else{
                Intent(this,SecondActivity::class.java).apply {
                    putExtra("text",binding.editText.text.toString())
                    registerForActivityResult.launch(this)
                }
            }

        }

        registerForActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()
        ) { result ->
            binding.editText.setText(result.data?.getStringExtra("key"))
        }
    }
}
