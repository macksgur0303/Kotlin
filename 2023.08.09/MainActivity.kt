package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission

class MainActivity : AppCompatActivity() {

    // var 변수, val 한번지정된 값(변경될일 x), lateinit 후에 초기화 한다
    val REQUEST_IMAGE_CAPTURE = 1 // 카메라 사진 촬영 요청 코드
    lateinit var curPhotoPath: String // 문자열 형태의 사진 경로 값

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // layout binding class 생성
        setContentView(binding.root) // binding.root에  해당하는 layout을 표시하도록 설정

        setPermission() // 권환을 체크하는 메소드 수행

    }

    // 테드 퍼미션 설정
    private fun setPermission() {
        val permission = object : PermissionListener {

            override fun onPermissionGranted() { // 설정해놓은 위험권환이 허용되었을때 수행
                Toast.makeText(this@MainActivity, "권환이 허용 되었습니다", Toast.LENGTH_SHORT).show()
            }
            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) { // 설정해놓은 위험권환이 거절 되었을때 수행
                Toast.makeText(this@MainActivity, "권환이 거부 되었습니다", Toast.LENGTH_SHORT).show()
            }
        }

        TedPermission.with(this)
            .setPermissionListener(permission)
            .setRationaleMessage("카메라 앱을 사용하시려면 권환을 허용해주세요.")
            .setDenieMessage("권환을 거부하셨습니다. 권환을 허용해주세요")
            .setPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
            .check()
    }
}