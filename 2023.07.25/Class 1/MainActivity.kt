package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater) // layout binding class 생성
        setContentView(binding.root) // binding.root에  해당하는 layout을 표시하도록 설정

        binding.btnA.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java) // 다음 화면으로 이동하기 위한 인텐트 객체 생성
            intent.putExtra("MSG", binding.tvSendMSG.text.toString()) // 텍스트 값을 받은 뒤 MSG라는 키로 잠금
            startActivity(intent) // intent에 저장되어 있는 activity 쪽으로 이동한다
            finish() // 자기 자신 activity를 파괴한다
        }
    }
}