package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) { // activity이 처음 실행될때 한번 수행한다 (초기화)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // layout binding class 생성
        setContentView(binding.root) // binding.root에  해당하는 layout을 표시하도록 설정

        //TODO: 저장된 데이터를 로드

        loadData() // editText 저장되어 있던 값을 setText
    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        binding.etHello.setText(pref.getString("name", "-1")) // 첫번째 인자에는 저장할 당시의 키 값을, 두번째 인자에는 키 값에 데이터가 존재하지 않을 경우 대체 대이터 추가
    }


    override fun onDestroy() { // activity이 종료되는 시점이 다가올때 호출
        super.onDestroy()

        saveData() // editText 값을 저장
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() // 수정모드
        edit.putString("name", binding.etHello.text.toString()) // 첫번째 인자에는 키 값을, 두번째 인자에는 실제 담아둘 값
        edit.apply() // 저장완료

    }
}