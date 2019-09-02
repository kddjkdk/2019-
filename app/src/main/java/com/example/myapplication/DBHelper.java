package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    static String DB_NAME = "user.db";

    String sql;

    public DBHelper(Context context){
        super(context,DB_NAME,null,1);
    }

    public void onCreate(SQLiteDatabase db){                        //객체 생성시 중복되지 않게 테이블을 생성
        sql = "create table if not exists user("+
                "_No integer primary key autoincrement,"+
                "id text,"+
                "pw text,"+
                "name text,"+
                "phone text,"+
                "e_mail text)";
        try{
            db.execSQL(sql);
        }catch (Exception e){
            Log.e("DB","E");
        }
    }

    public void onUpgrade(SQLiteDatabase db,int oldversion, int newversion){
        //데이터베이스 버전을 확인 후 높은 버전으로 업그레이드
        if(oldversion<newversion){
            sql = "drop table user";
            try {
                db.execSQL(sql);
            }catch (Exception e){
                Log.e("DB", "e");
            }
        }
    }

    public void insertdata(String id, String pw, String name, String phone, String e_mail){     //회원가입 페이지에서 입력된 데이터들을 테이블에 저장
        SQLiteDatabase db = getWritableDatabase();
        sql = "insert into user(id, pw, name, phone, e_mail) values("+
                "'"+id+"','"+pw+"','"+name+"','"+phone+"','"+e_mail+"')";

        try {
            db.execSQL(sql);
        }catch (Exception e){
            Log.e("DB", "e");
        }
    }

    public boolean select(String id, String pw){    //로그인 시 아이디 패스워드 비교 후 결과 값 리턴
        SQLiteDatabase db = getReadableDatabase();
        sql = "select * from user";
        Cursor cursor = db.rawQuery(sql, null);

        int cnt_id=0;
        int cnt_pw=0;

        while (cursor.moveToNext()){
            if(id.equals(cursor.getString(1))){
                cnt_id = 1;
            }
            if(pw.equals(cursor.getString(2))){
                cnt_pw = 1;
            }
        }

        if (cnt_id == 1 && cnt_pw == 1) {
            return true;
        }else{
            return false;
        }
    }
}
