package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var UserList = arrayListOf<User>(
        User(R.drawable.filename, "문찬혁", "28", "안녕하세요"),
        User(R.drawable.filename, "문찬혁", "28", "안녕하세요"),
        User(R.drawable.filename, "문찬혁", "28", "안녕하세요"),
        User(R.drawable.filename, "문찬혁", "28", "안녕하세요"),
        User(R.drawable.filename, "문찬혁", "28", "안녕하세요"),
        User(R.drawable.filename, "문찬혁", "28", "안녕하세요"),
        User(R.drawable.filename, "문찬혁", "28", "안녕하세요")
    )
    override fun onCreate(savedInstanceState: Bundle?) { // activity의 시작지점
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater) // layout binding class 생성
        setContentView(binding.root) // binding.root에  해당하는 layout을 표시하도록 설정

//        val item = arrayOf("사과", "배", "딸기", "키위", "문찬혁")
//        // context란 한 activity의 모든정보를 담고있다
//        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        val Adapter = UserAdapter(this, UserList)
        binding.listView.adapter = Adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener{
            parent, view, position, id-> val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }

    }
}