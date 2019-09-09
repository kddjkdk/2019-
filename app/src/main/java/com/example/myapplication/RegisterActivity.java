package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity{

    DBHelper dbHelper = new DBHelper(this);
    private EditText e_id,e_pw,e_name,e_phone,e_email;
    private Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // 액티비티 시작 시 처음으로 실행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 아이디 값 찾기
        e_id = (EditText)findViewById(R.id.id);
        e_pw = (EditText)findViewById(R.id.pw);
        e_name = (EditText)findViewById(R.id.name);
        e_phone = (EditText)findViewById(R.id.phone);
        e_email = (EditText)findViewById(R.id.email);

        cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }


    public void onComplete(View v){

        final String id, pw, name, phone, email; // editText
        //EditText에 현재 입력되는 값을 가져옴
        id = e_id.getText().toString();
        pw = e_pw.getText().toString();
        name = e_name.getText().toString();
        phone = e_phone.getText().toString();
        email = e_email.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response =response.replace(".",":");
                //제이슨, 에이젝슨사용... 운반할때 포장해서 넘겨줌. 받을때 포장을 풀어줌:  파싱
                Log.v(response, "----response----");
                    try {
                        JSONObject jsonObject = new JSONObject(response);               // 성공 여부 알기위해사용
                        boolean success = jsonObject.getBoolean("success");     // 서버통신 성공 여부 알려줌
                        if (success) {
                            Toast.makeText(getApplicationContext(), "회원등록 성공", Toast.LENGTH_SHORT).show();
                            Log.e("push", "push");
                            Intent intent = new Intent(RegisterActivity.this, logina.class);
                            startActivity(intent);
                        } else { // 회원등록에 실패한 경우
                            Toast.makeText(getApplicationContext(), "회원 등록 실패", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("push", "error");
                    }
            }
        };
        RegisterRequest registerRequest = new RegisterRequest(id, pw, name, phone, email, responseListener);
        RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
        queue.add(registerRequest);

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
