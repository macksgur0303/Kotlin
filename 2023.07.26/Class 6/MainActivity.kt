package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.core.view.GravityCompat
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // layout binding class 생성
        setContentView(binding.root) // binding.root에  해당하는 layout을 표시하도록 설정

        binding.btnNavi.setOnClickListener{
            binding.layoutDrawer.openDrawer(GravityCompat.START) // START : left, END : right
        }

        binding.naviView.setNavigationItemSelectedListener(this) // 네비게이션 아이템에 클릭 속성 부여
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { // 네이게이션 메뉴 아이템 클릭시 실행
        when (item.itemId)
        {
            R.id.acess -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.send -> Toast.makeText(applicationContext, "메세지", Toast.LENGTH_SHORT).show()

        }
        binding.layoutDrawer.closeDrawers() //네이게이션 view 닫기
        return false

    }

    override fun onBackPressed() {

        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START))
        {
            binding.layoutDrawer.closeDrawers()//네이게이션 view 닫기
        }
        else
            super.onBackPressed() // 일반 백버튼 기능 실행
    }
}