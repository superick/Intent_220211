package com.example.intent_220211

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        okBtn.setOnClickListener {

            val inputNewNickname = newNickNameEdt.text.toString()

            val resultInetent = Intent()
            resultInetent.putExtra("nickname", inputNewNickname)
            setResult(RESULT_OK, resultInetent)
            finish()


        }



    }
}