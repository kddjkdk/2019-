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

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pw, et_name, et_phone, et_email;
    private Button btn_cancel, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 액티비티 시작 시 처음으로 실행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 아이디 값 찾기
        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);

        btn_register = findViewById(R.id.btn_regitster2);
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText에 현재 입력되어있는 값을 가져옴
                String userID = et_id.getText().toString();
                String userPass = et_id.getText().toString();
                String userName = et_id.getText().toString();
                String userPhone = et_id.getText().toString();
                String userEmail = et_id.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) { //서버통신 완료 알려줌
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {    //회원가입 성공
                                Toast.makeText(getApplicationContext(), "회원 가입 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {  // 회원가입 실패
                                Toast.makeText(getApplicationContext(), "회원 가입 실패", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //서버로  volley를 이용해서 요청
                RegisterRequest registerRequest = new RegisterRequest(userID,userPass,userName,userPhone,userEmail, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }



    public void hom(View v){ // 클릭이벤트. 버튼에 OnClick하고 이름을 맞춰줘야한다
        Intent intent001 = new Intent(this,MainActivity.class); // Intent라는 함수 사용법. Intent intent이름 = new Intent(this,불러올페이지이름.class)
        startActivity(intent001); // intent이름 을 시작하겠다.
    }       // 만약 추가하고싶다면 java > com.example.myapplication에 마우스 오른쪽버튼 new > activity로 추가하면됨.
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
}