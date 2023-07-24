package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMain2Binding = ActivityMain2Binding.inflate(layoutInflater) // layout binding class 생성
        setContentView(binding.root) // binding.root에  해당하는 layout을 표시하도록 설정

        if(intent.hasExtra("MSG")){
            val message = intent.getStringExtra("MSG")
            binding.tvGetMSG.text = message // sub activity의 존재하는 textview에다가 넘어저 옴
        }

        binding.btnGoBack.setOnClickListener{
            finish()
        }
    }
}