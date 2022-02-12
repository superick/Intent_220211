package com.example.intent_220211

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendMessageBtn.setOnClickListener {

//            입력한 내용을 변수에 저장

            val inputMessage = messgeEdt.text.toString()

//            비행기 티켓 발권
            val myIntent = Intent(this, messageAct::class.java)

//            수하물 첨부

            myIntent.putExtra("message", inputMessage)

//            실제 출발

            startActivity(myIntent)


       }

        moveToOtherBtn.setOnClickListener {
//            다른 화면으로 이동

            val myIntent = Intent(this,OtherActivity::class.java)
            startActivity(myIntent)


        }
    }
}