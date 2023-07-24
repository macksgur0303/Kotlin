package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater) // layout binding class 생성
        setContentView(binding.root) // binding.root에  해당하는 layout을 표시하도록 설정

        binding.ivProfile.setImageResource(R.drawable.robot)
        binding.vtnToast.setOnClickListener{
            Toast.makeText(this@MainActivity, "버튼이 입력 되었습니다", Toast.LENGTH_SHORT).show()
        }
    }
}