package at.willhaben.multiscreenflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import at.willhaben.multiscreenflow.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLoginActivity.setOnClickListener {
            logIn()
            setResult(RESULT_OK)
            finish()
        }
    }
}