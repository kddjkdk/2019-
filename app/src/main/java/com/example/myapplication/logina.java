package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class logina extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logina);

        findViewById(R.id.Login1).setOnClickListener(this);
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.Login1:
                new AlertDialog.Builder(this)
                        .setTitle("로그인 결과")
                        .setMessage("로그인에 성공하셨습니다.")
                        .setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dlg, int sumthin) {
                                logina.super.onDestroy(); // 해당 페이지의 다음 방문 기록 삭제
                            }
                        })
                        .show();
                break;
        }
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
    public void signUp(View v) {
        Intent intent007 = new Intent(this, sing_up.class);
        startActivity(intent007);
    }

}
