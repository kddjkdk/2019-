package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Communitya;
import com.example.myapplication.MainActivity;
import com.example.myapplication.MyPagea;
import com.example.myapplication.Perchasea;
import com.example.myapplication.R;
import com.example.myapplication.Streaminga;
import com.example.myapplication.logina;

public class BattleG extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_g);

        findViewById(R.id.back).setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.back:
                this.finish();
                break;
        }
    }
    public void hom(View v){ // 클릭이벤트. 버튼에 OnClick하고 이름을 맞춰줘야한다
        Intent intent001 = new Intent(this, MainActivity.class); // Intent라는 함수 사용법. Intent intent이름 = new Intent(this,불러올페이지이름.class)
        startActivity(intent001); // intent이름 을 시작하겠다.
    }// 만약 추가하고싶다면 java > com.example.myapplication에 마우스 오른쪽버튼 new > activity로 추가하면됨.

    public void lo_co(View v){
        Intent intent002 = new Intent(this, logina.class);
        startActivity(intent002);
    }
    public void myp(View v){
        Intent intent003 = new Intent(this, MyPagea.class);
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
