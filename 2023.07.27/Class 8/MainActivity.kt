package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // layout binding class 생성
        setContentView(binding.root) // binding.root에  해당하는 layout을 표시하도록 설정

        binding.webView.settings.javaScriptEnabled = true // 자바 스크립트 허용

        /////////////////////// web view에서 새 창이 뜨지 않도록 방지하는 구문 //////////////////////////////

        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()

        ///////////////////////////////////////////////////////////////////////////////////////////////

        binding.webView.loadUrl("http://www.naver.com") // 링크 주소를 load 함
    }


    override fun onBackPressed() { // backbtn 누를 시 수행할 logic 구현
        if(binding.webView.canGoBack()) // 웹 사이트에서 뒤로 갈 페이지가 존재한다면
        {
            binding.webView.goBack()
        }
        else
        {
            onBackPressedDispatcher.onBackPressed() // 본래의 백버튼 기능 수행
            // Deprecated된 멤버 대신 onBackPressedDispatcher.onBackPressed() 사용
        }
    }

    override fun onPause() {
        super.onPause()
        binding.webView.onPause()
    }

    override fun onResume() {
        super.onResume()
        binding.webView.onResume()
    }
}