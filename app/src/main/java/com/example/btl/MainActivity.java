package com.example.btl;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.btl.Database.DiemDatabase;
import com.example.btl.Database.QuestionDatabase;
import com.example.btl.utity.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    QuestionDatabase questionDatabase;
    DiemDatabase diemDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionDatabase =new QuestionDatabase(MainActivity.this);
        for(int i = 0; i< 10000; i++){
            questionDatabase.deleteCauHoi(i);
        }

        Question question1=new Question("Điền vào chỗ hỏi chấm: 1+4=? ","3","4","5","6","C",1);
        Question question2=new Question("Điền vào chỗ hỏi chấm: 1+6=? ","7","8","5","6","A",1);
        Question question3=new Question("Điền vào chỗ hỏi chấm: 1+4-3=? ","3","4","2","5","C",2);
        Question question4=new Question("Điền vào chỗ hỏi chấm: 1X4=? ","3","4","5","6","B",3);
        Question question5=new Question("Điền vào chỗ hỏi chấm: 1+4X5=? ","20","21","22","23","B",4);
        Question question6=new Question("Điền vào chỗ hỏi chấm: 1+4-11=? ","-3","-4","-5","-6","D",6);
        Question question7=new Question("Điền vào chỗ hỏi chấm: 4+4-2X2 ","3","4","5","6","B",5);
        Question question8=new Question("Điền vào chỗ hỏi chấm: 1+4=? ","3","4","5","6","C",7);
        Question question9=new Question("Điền vào chỗ hỏi chấm: 1+6=? ","7","8","5","6","A",8);
        Question question10=new Question("Có bao nhiêu số có một chữ số : ","10","9","8","90","A",9);
        Question question11=new Question("Số liền trước số lớn nhất có một chữ số là số: ","8","9","10","11","B",10);
        Question question12=new Question("Số liền sau số lớn nhất có hai chữ số là số: ","10","9","99","100","D",11);
        Question question13=new Question("Số ở giữa số 25 và 27 là số: ","28","24","26","30","C",12);
        Question question14=new Question("Kết quả của phép tính 56 + 13 – 30 ","29","39","49","59","B",13);
        Question question15=new Question("Số điền vào chỗ chấm trong phép tính ……….+15 – 20 = 37 là:","37","40","42","39","C",14);
        Question question16=new Question("Nhà bà có tất cả 64 quả bưởi và na, trong đó số quả na là 24, vậy số quả bưởi là:","88 quả","40 quả","24 quả","50 quả","B",15);
        Question question17=new Question("Số 45 là số liền sau số: ","40","44","46","50","B",2);
        Question question18=new Question("Hà có 35 lá cờ, Hà cho An 5 lá cờ và cho Lan 10 lá cờ, số lá cờ Hà còn lại:","30","25","20","15","C",3);
        Question question19=new Question("Số liền sau số bé nhất có hai chữ số là: ","9","11","10","12","B",4);
        Question question20=new Question("Dãy số nào sau đây được xếp theo thứ tự ừ bé đến lớn: ","95; 83; 65; 52; 20","25; 30; 42; 86; 60","24; 32; 65; 82; 90","12; 15; 42; 52; 25","C",6);
        Question question21=new Question("Hình tam giác là hình có:","2 cạnh","3 cạnh","5 cạnh","4 cạnh","B",6);
        Question question22=new Question("Hôm nay là thứ năm ngày 8 thì hôm kia là ngày:","Thứ bảy ngày 10","Thứ ba ngày 10","Thứ ba ngày 6" ,"Thứ tư ngày 7","C",14);
        Question question23=new Question("Đoạn thẳng AB dài 18 cm, đoạn thẳng BC dài 25 cm, vậy đoạn thẳng BC ..... . đoạn thẳng AB:","Ngắn hơn","Dài hơn","Bằng nhau","Cả 3 đều sai","B",5);
        questionDatabase.insertCauHoi(question1);
        questionDatabase.insertCauHoi(question2);
        questionDatabase.insertCauHoi(question3);
        questionDatabase.insertCauHoi(question4);
        questionDatabase.insertCauHoi(question5);
        questionDatabase.insertCauHoi(question6);
        questionDatabase.insertCauHoi(question7);
        questionDatabase.insertCauHoi(question8);
        questionDatabase.insertCauHoi(question9);
        questionDatabase.insertCauHoi(question10);
        questionDatabase.insertCauHoi(question11);
        questionDatabase.insertCauHoi(question12);
        questionDatabase.insertCauHoi(question13);
        questionDatabase.insertCauHoi(question14);
        questionDatabase.insertCauHoi(question15);
        questionDatabase.insertCauHoi(question16);
        questionDatabase.insertCauHoi(question17);
        questionDatabase.insertCauHoi(question18);
        questionDatabase.insertCauHoi(question19);
        questionDatabase.insertCauHoi(question20);
        questionDatabase.insertCauHoi(question21);
        questionDatabase.insertCauHoi(question22);
        questionDatabase.insertCauHoi(question23);
    }

    public void choiGame(View view) {
        Intent intent=new Intent(this,maingame.class);
        startActivity(intent);
    }

    public void huongDan(View view) {
        Intent intent=new Intent(this,guildance.class);
        startActivity(intent);
    }

    public void btnBangXepHang(View view) {
        Intent intent=new Intent(this,Bang_xep_hang.class);
        startActivity(intent);
    }

    public void btnThoat(View view) {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Cảnh báo");
        alertDialog.setMessage("Bạn có chắc chắn muốn thoát không?");
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(1);
            }
        });
        alertDialog.create().show();
    }
}