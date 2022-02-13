package com.example.intent_220211

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAME = 1005

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smsBtn.setOnClickListener {
            val inputPhoneNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("smsto:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "미리 내용 입력")

            startActivity(myIntent)


        }


        callBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_CALL, myUri)

            startActivity(myIntent)

        }


//        DIAL 액션 예제

        dialNBtn.setOnClickListener {

//            phoneNumEdt에 입력한 전호번호를 받아서 해당번호에 전화 연결
            val inputPhoneNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)

        }







        editNickNameBtn.setOnClickListener {

            val myIntent = Intent(this, EditNickName::class.java)
            startActivityForResult(myIntent, REQUEST_FOR_NICKNAME)

        }

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        돌아온 이유가 닉네임을 받으러 다녀온게 맞는지?
        if (requestCode == REQUEST_FOR_NICKNAME){

//            추가질문 : 확인을 눌러서 돌아온게 맞는지?
            if (resultCode == RESULT_OK){

//                실제로 첨부된 새 닉네임을 꺼내서 텍스트뷰에 반영

                val newName = data?.getStringExtra("nickname")
                nickNameTxt.text = newName

            }

        }

    }

}