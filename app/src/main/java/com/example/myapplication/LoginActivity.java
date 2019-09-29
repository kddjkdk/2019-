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

public class LoginActivity extends AppCompatActivity {
    private EditText et_id, et_pw;
    private Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register1);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = et_id.getText().toString();
                String userPass = et_id.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {    // 로그인 성공
                                String id = jsonObject.getString("userID");
                                String pw = jsonObject.getString("userPass");

                                Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("userID", id);
                                intent.putExtra("userPass", pw);
                                startActivity(intent);
                            } else {  // 로그인 실패
                                Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
             LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
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
        Intent intent002 = new Intent(this, LoginActivity.class);
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
