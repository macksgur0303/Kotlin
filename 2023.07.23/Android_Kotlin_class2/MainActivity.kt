package com.example.androidkotlinclass2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidkotlinclass2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { //activity가 최초 실행될때 수행
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater) // layout binding class 생성
        setContentView(binding.root) // binding.root에  해당하는 layout을 표시하도록 설정

        binding.btnGetText.setOnClickListener{ // Edit text에 입력되어 있는 값을 가져와서 text view에 뿌려준다
            var resultText = binding.etId.text.toString() // Edit text에 입력되어 있는 값
            binding.tvResult.text = resultText // 입력된 값을 text view에 set 해준다
        }
    }
}