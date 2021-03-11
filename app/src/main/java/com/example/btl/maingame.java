package com.example.btl;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.btl.Database.QuestionDatabase;
import com.example.btl.utity.Question;
import com.example.btl.utity.TienThuong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class maingame extends AppCompatActivity {
     QuestionDatabase questionDatabase;
    private TextView txtQuestion;
    private Button btnA, btnB, btnC, btnD;
    public  int QuestionCount = 1;
    public  int random = 0;
    private TextView txtsocauhoi;
    private Dialog dialog;
    private ListView lvstienthuong;
    private ArrayList<String> arrTienThuong;
    private Context context;
    boolean check;
    Button btnDanhSach,btn5050,btnSwitch,btnPhone;
    TienThuong tienThuong;
    CountDownTimer timer;
    CountDownTimer time;
    List<Question> list;
    int ml;
    Button btnTom;
    Button btnDoraemon;
    Button btnProfessor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maingame);
        anhXa();
        unit();
        setUp();
        lvstienthuong.setVisibility(View.GONE);
        questionDatabase =new QuestionDatabase(maingame.this);

        //------------------------------------------------------------------------------------------
        //QuestionCount = 1;
        Random();
        list = questionDatabase.getQuestionByID(random);
        txtQuestion.setText(list.get(0).getCauHoi());
        btnA.setText(list.get(0).getA());
        btnB.setText(list.get(0).getB());
        btnC.setText(list.get(0).getC());
        btnD.setText(list.get(0).getD());
        //------------------------------------------------------------------------------------------
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time=new CountDownTimer(3000,500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        btnA.setBackgroundColor(Color.parseColor("#FF8800"));
                    }

                    @Override
                    public void onFinish() {
                        if(list.get(0).getANSWER().equals("A")){
                            timer=new CountDownTimer(1000,1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    btnA.setBackgroundColor(Color.parseColor("#33b5e5"));
                                }

                                @Override
                                public void onFinish() {
                                    QuestionCount++;
                                    if(QuestionCount<=15){
                                        Random();
                                        list = questionDatabase.getQuestionByID(random);
                                        txtQuestion.setText(list.get(0).getCauHoi());
                                        btnA.setText(list.get(0).getA());
                                        btnB.setText(list.get(0).getB());
                                        btnC.setText(list.get(0).getC());
                                        btnD.setText(list.get(0).getD());
                                        cancel();
                                        if(!check)
                                        {
                                            btnB.setVisibility(View.VISIBLE);
                                            btnC.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    else {
                                        LuuTen();
                                    }
                                }
                            }.start();
                        }
                        else{
                            LuuTen();
                        }
                        cancel();
                    }
                }.start();
            }
        });
        //------------------------------------------------------------------------------------------
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time=new CountDownTimer(3000,500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        btnB.setBackgroundColor(Color.parseColor("#FF8800"));
                    }

                    @Override
                    public void onFinish() {
                        if(list.get(0).getANSWER().equals("B")){
                            timer=new CountDownTimer(1000,1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    btnB.setBackgroundColor(Color.parseColor("#33b5e5"));
                                }

                                @Override
                                public void onFinish() {
                                    QuestionCount++;
                                    if(QuestionCount<=15){
                                        Random();
                                        list = questionDatabase.getQuestionByID(random);
                                        txtQuestion.setText(list.get(0).getCauHoi());
                                        btnA.setText(list.get(0).getA());
                                        btnB.setText(list.get(0).getB());
                                        btnC.setText(list.get(0).getC());
                                        btnD.setText(list.get(0).getD());
                                        cancel();
                                        if(!check)
                                        {
                                            btnA.setVisibility(View.VISIBLE);
                                            btnD.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    else {
                                        LuuTen();
                                    }
                                }
                            }.start();
                        }
                        else{
                            LuuTen();
                        }
                        cancel();
                    }
                }.start();
            }
        });
        //------------------------------------------------------------------------------------------
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time=new CountDownTimer(3000,500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        btnC.setBackgroundColor(Color.parseColor("#FF8800"));
                    }

                    @Override
                    public void onFinish() {
                        if(list.get(0).getANSWER().equals("C")){
                            timer=new CountDownTimer(1000,1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    btnC.setBackgroundColor(Color.parseColor("#33b5e5"));
                                }

                                @Override
                                public void onFinish() {
                                    QuestionCount++;
                                    if(QuestionCount<=15){
                                        Random();
                                        list = questionDatabase.getQuestionByID(random);
                                        txtQuestion.setText(list.get(0).getCauHoi());
                                        btnA.setText(list.get(0).getA());
                                        btnB.setText(list.get(0).getB());
                                        btnC.setText(list.get(0).getC());
                                        btnD.setText(list.get(0).getD());
                                        cancel();
                                        if(!check)
                                        {
                                            btnA.setVisibility(View.VISIBLE);
                                            btnD.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    else {
                                        LuuTen();
                                    }
                                }
                            }.start();
                        }
                        else{
                            LuuTen();
                        }
                        cancel();
                    }
                }.start();

            }
        });
        //------------------------------------------------------------------------------------------
        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time=new CountDownTimer(3000,500) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        btnD.setBackgroundColor(Color.parseColor("#FF8800"));
                    }

                    @Override
                    public void onFinish() {
                        if(list.get(0).getANSWER().equals("D")){
                            timer=new CountDownTimer(1000,1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    btnD.setBackgroundColor(Color.parseColor("#33b5e5"));
                                }

                                @Override
                                public void onFinish() {
                                    QuestionCount++;
                                    if(QuestionCount<=15){
                                        Random();
                                        list = questionDatabase.getQuestionByID(random);
                                        txtQuestion.setText(list.get(0).getCauHoi());
                                        btnA.setText(list.get(0).getA());
                                        btnB.setText(list.get(0).getB());
                                        btnC.setText(list.get(0).getC());
                                        btnD.setText(list.get(0).getD());
                                        cancel();
                                        if(!check)
                                        {
                                            btnB.setVisibility(View.VISIBLE);
                                            btnC.setVisibility(View.VISIBLE);
                                        }
                                    }
                                    else {
                                        LuuTen();
                                    }

                                }
                            }.start();
                        }
                        else{
                            LuuTen();
                        }
                        cancel();
                    }
                }.start();
            }
        });

    }
    public void Random(){
        btnA.setBackgroundColor(Color.parseColor("#aaaaaa"));
        btnB.setBackgroundColor(Color.parseColor("#aaaaaa"));
        btnC.setBackgroundColor(Color.parseColor("#aaaaaa"));
        btnD.setBackgroundColor(Color.parseColor("#aaaaaa"));
        txtsocauhoi.setText(QuestionCount+"");
        tienThuong.setVitriCauHoi(QuestionCount);
        ArrayList listID = new ArrayList();
        List<Question> list = questionDatabase.getAllQuestion();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getPOS()==QuestionCount){
                listID.add(list.get(i).getId());
            }
        }
        Random rd = new Random();
        int randomNum = rd.nextInt(listID.size());
        random = (int) listID.get(randomNum);

    }
    long[] listtt;
    int k;
    public void tienthuong(){
        listtt=new long[16];
        listtt[1]=100;
        listtt[2]=300;
        listtt[3]=500;
        listtt[4]=1000;
        listtt[5]=1500;
        listtt[6]=2000;
        listtt[7]=3000;
        listtt[8]=7500;
        listtt[9]=15000;
        listtt[10]=30000;
        listtt[11]=62000;
        listtt[12]=125000;
        listtt[13]=250000;
        listtt[14]=500000;
        listtt[15]=1000000;
    }
    public void LuuTen(){
        tienthuong();
        k=QuestionCount;
        if(k<5){
            k=1;
        }
        if(k>=5&&k<10){
            k=5;
        }
        if(k>=10&&k<15){
            k=10;
        }
        AlertDialog.Builder b=new AlertDialog.Builder(maingame.this);
        if(k==16){
            b.setTitle("XIN CHÚC MỪNG BẠN LÀ MỘT THIÊN TÀI\n"+"Bạn đã đạt tiền thưởng tối đa\n"+"Điểm của bạn là "+ listtt[k-1]);
        }else {
            b.setTitle("Điểm của bạn là "+ listtt[k]);
        }
        b.setMessage("Bạn có muôn lưu tên không?");
        b.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(maingame.this, LuuTen.class);
                long tienThuong=listtt[k];
                intent.putExtra("tien",tienThuong+"");
                startActivity(intent);
            }
        });
        b.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(maingame.this, MainActivity.class);
                startActivity(intent);
            }
        });
        b.create().show();
    }

    public void btnDanhSach(View view) {
        if(btnDanhSach.getText().equals("Mốc tiền thưởng")){
            lvstienthuong.setVisibility(View.VISIBLE);
            btnDanhSach.setText("Quay lại");
            btnB.setEnabled(false);
            btnD.setEnabled(false);

        }
        else if(btnDanhSach.getText().equals("Quay lại")){
            lvstienthuong.setVisibility(View.GONE);
            btnDanhSach.setText("Mốc tiền thưởng");
            btnB.setEnabled(true);
            btnD.setEnabled(true);
        }

    
    }

    public void anhXa(){
        lvstienthuong=findViewById(R.id.lvtienthuong);
        btnDanhSach=findViewById(R.id.btndanhsach);
        txtQuestion = (TextView) findViewById(R.id.txtQues);
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        btn5050 = (Button) findViewById(R.id.btn5050);
        btnSwitch = (Button) findViewById(R.id.btnSwitch);
        btnPhone = (Button) findViewById(R.id.btnPhone);
        txtsocauhoi=findViewById(R.id.txtsocauhoi);
        btnTom = findViewById(R.id.btnTom);
         btnDoraemon = findViewById(R.id.btnDoraemon);
        btnProfessor = findViewById(R.id.btnProfessor);
    }
    public void unit(){
        arrTienThuong=new ArrayList<>();
        arrTienThuong.add("1000000");
        arrTienThuong.add("500000");
        arrTienThuong.add("250000");
        arrTienThuong.add("125000");
        arrTienThuong.add("62000");
        arrTienThuong.add("30000");
        arrTienThuong.add("15000");
        arrTienThuong.add("7500");
        arrTienThuong.add("3000");
        arrTienThuong.add("2000");
        arrTienThuong.add("1500");
        arrTienThuong.add("1000");
        arrTienThuong.add("500");
        arrTienThuong.add("300");
        arrTienThuong.add("100");
        tienThuong=new TienThuong(this,0,arrTienThuong);

    }
    public void setUp(){
        lvstienthuong.setAdapter(tienThuong);
    }
    public void troGiup5050(View view)
    {
        btn5050.setEnabled(false);
        check = true;
        if (check)
        {
            if (list.get(0).getANSWER().equals("A")) {
                btnB.setVisibility(View.INVISIBLE);
                btnC.setVisibility(View.INVISIBLE);
            } else if (list.get(0).getANSWER().equals("B")) {
                btnA.setVisibility(View.INVISIBLE);
                btnD.setVisibility(View.INVISIBLE);
            } else if (list.get(0).getANSWER().equals("C")) {
                btnA.setVisibility(View.INVISIBLE);
                btnD.setVisibility(View.INVISIBLE);
            } else if (list.get(0).getANSWER().equals("D")) {
                btnD.setVisibility(View.INVISIBLE);
                btnC.setVisibility(View.INVISIBLE);
            }
            check = false;
        }
    }
    public void troGiupSwitch(View view)
    {
        btnA.setVisibility(View.VISIBLE);
        btnB.setVisibility(View.VISIBLE);
        btnD.setVisibility(View.VISIBLE);
        btnC.setVisibility(View.VISIBLE);
        btnSwitch.setEnabled(false);
        ml=random;
        Random();
        if(ml!=random) {
            list = questionDatabase.getQuestionByID(random);
            txtQuestion.setText(list.get(0).getCauHoi());
            btnA.setText(list.get(0).getA());
            btnB.setText(list.get(0).getB());
            btnC.setText(list.get(0).getC());
            btnD.setText(list.get(0).getD());
        }
        else {
            troGiupSwitch(view);
        }
    }
    public void troGiupPhone(View view)
    {
        btnPhone.setEnabled(false);
        showDialog();
    }
    public void showDialog() {
        dialog = new Dialog(maingame.this);
        dialog.setTitle("Trợ giúp gọi điện thoại");
        dialog.setContentView(R.layout.dialog_goi_dien);
        dialog.show();

    }
    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(list.get(0).getANSWER().equals("A")){
            builder.setMessage("Đáp án của mình là A");
        }
        else if(list.get(0).getANSWER().equals("B")){
            builder.setMessage("Đáp án của mình là B");
        }
        else if(list.get(0).getANSWER().equals("C")){
            builder.setMessage("Đáp án của mình là C");
        }
        else if(list.get(0).getANSWER().equals("D")){
            builder.setMessage("Đáp án của mình là D");
        }
        builder.setCancelable(false);
        builder.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
                Intent intent=new Intent(maingame.this,MainActivity.class);
                startActivity(intent);
            }
        });
        alertDialog.create().show();
    }

    public void btnDungCuocChoi(View view) {
        tienthuong();
        AlertDialog.Builder b=new AlertDialog.Builder(maingame.this);
        b.setTitle("Điểm của bạn là "+ listtt[QuestionCount]);
        b.setMessage("Bạn có muôn lưu tên không?");
        b.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(maingame.this, LuuTen.class);
                long tienThuong=listtt[QuestionCount];
                intent.putExtra("tien",tienThuong+"");
                startActivity(intent);
            }
        });
        b.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        b.create().show();
    }

    public void btnTom(View view) {
        showAlertDialog();
    }

    public void btnDoremon(View view) {
        showAlertDialog();
    }

    public void btnProfessor(View view) {
        showAlertDialog();
    }
}