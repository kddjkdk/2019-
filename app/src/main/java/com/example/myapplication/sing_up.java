package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class sing_up extends AppCompatActivity{

    DBHelper dbHelper = new DBHelper(this);
    String id, pw, name, phone, email; // editText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

    }
@Override
public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(sing_up.this,logina.class);
        finish();
        startActivity(intent);

}
    public void onComplete(View v){
        EditText e_id = (EditText)findViewById(R.id.id);
        id = e_id.getText().toString();
        EditText e_pw = (EditText)findViewById(R.id.pw);
        pw = e_pw.getText().toString();
        EditText e_name = (EditText)findViewById(R.id.name);
        name = e_name.getText().toString();
        EditText e_phone = (EditText)findViewById(R.id.phone);
        phone = e_phone.getText().toString();
        EditText e_email = (EditText)findViewById(R.id.email);
        email = e_email.getText().toString();

        dbHelper.insertdata(id, pw, name, phone, email);

        new AlertDialog.Builder(this)
                .setTitle("회원가입 결과")
                .setMessage("회원가입에 성공하셨습니다.")
                .setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dlg, int sumthin) {

                        Log.d("메시지 출력", "닫기누름");
                        onBackPressed();
                    }
                })
                .show();

    }
    public void hom(View v){ // 클릭이벤트. 버튼에 OnClick하고 이름을 맞춰줘야한다
        Intent intent001 = new Intent(this,MainActivity.class); // Intent라는 함수 사용법. Intent intent이름 = new Intent(this,불러올페이지이름.class)
        startActivity(intent001); // intent이름 을 시작하겠다.
    }// 만약 추가하고싶다면 java > com.example.myapplication에 마우스 오른쪽버튼 new > activity로 추가하면됨.

    public void lo_co(View v){
        Intent intent002 = new Intent(this,logina.class);
        startActivity(intent002);
    }
    public void myp(View v){
        Intent intent003 = new Intent(this,MyPagea.class);
        startActivity(intent003);
    }
    public void stream(View v) {
        Intent intent004 = new Intent(this, Streaminga.class);
        startActivity(intent004);
    }
    public void Pers(View v) {
        Intent intent005 = new Intent(this, Perchasea.class);
        startActivity(intent005);
    }
    public void comu(View v) {
        Intent intent006 = new Intent(this, Communitya.class);
        startActivity(intent006);
    }
}
