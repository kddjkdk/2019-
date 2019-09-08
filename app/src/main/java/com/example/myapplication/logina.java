package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class logina extends AppCompatActivity {
    private EditText e_id, e_pw;
    private Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logina);

        e_id = findViewById(R.id.id);
        e_pw = findViewById(R.id.pw);
        btn_login = findViewById(R.id.Login1);
        btn_register = findViewById(R.id.register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String id = e_id.getText().toString();
                String pw = e_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONObject jsonObject = new JSONObject(response);   // 성공 여부 알기위해사용
                            boolean success = jsonObject.getBoolean("success");     // 서버통신 성공 여부 알려줌
                            if (success) {
                                 // 서버로부터 id, pw 검사
                                String userID= jsonObject.getString("ID");
                                String userPass= jsonObject.getString("Password");
                                 Toast.makeText(getApplicationContext(), "로그인 성공",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(logina.this, MainActivity.class);
                                // 넣은 값들 가지고 다음페이지로...
                                intent.putExtra("ID", userID);
                                intent.putExtra("Pass", userPass);
                            } else { // 회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(id, pw, responseListener);
                RequestQueue queue = Volley.newRequestQueue(logina.this);
                queue.add(loginRequest);
            }
        });
    }




    public void hom(View v){ // 클릭이벤트. 버튼에 OnClick하고 이름을 맞춰줘야한다
        Intent intent001 = new Intent(this,MainActivity.class); // Intent라는 함수 사용법. Intent intent이름 = new Intent(this,불러올페이지이름.class)
        startActivity(intent001); // intent이름 을 시작하겠다.
    }// 만약 추가하고싶다면 java > com.example.myapplication에 마우스 오른쪽버튼 new > activity로 추가하면됨.

        //메뉴 및 로그인
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
    public void signUp(View v) {  // 회원가입 버튼 클리 시 수행
        Intent intent007 = new Intent(this, RegisterActivity.class);
        startActivity(intent007);
    }

}
