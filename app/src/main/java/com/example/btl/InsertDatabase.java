package com.example.btl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btl.Database.QuestionDatabase;
import com.example.btl.utity.Question;

import java.util.List;

public class InsertDatabase extends AppCompatActivity {
    QuestionDatabase questionDatabase;
    private EditText txtQuestion,txtA,txtB,txtC,txtD,txtAnswer,txtPos,txtid;
    private Button btnThem,btnHienthi;
    private TextView tvDS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_database);
        questionDatabase =new QuestionDatabase(InsertDatabase.this);
        questionDatabase.deleteALL();
        txtA=findViewById(R.id.txtA);
        txtB=findViewById(R.id.txtB);
        txtC=findViewById(R.id.txtC);
        txtD=findViewById(R.id.txtD);
        txtQuestion=findViewById(R.id.txtCauHoi);
        txtAnswer=findViewById(R.id.txtAnswer);
        txtid=findViewById(R.id.txtID);
        txtPos=findViewById(R.id.txtPos);
        tvDS=findViewById(R.id.tvDS);

        btnThem=findViewById(R.id.button5);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertDatabase.this, maingame.class);
                startActivity(intent);
            }
        });
    }


    public void HienThi(View view) {
        List<Question> list= questionDatabase.getAllQuestion();
        String a=null;
        Question question=new Question();
        for (int i=0;i<list.size();i++){
            question.setId(list.get(i).getId());
            question.setCauHoi(list.get(i).getCauHoi());
            question.setA(list.get(i).getA());
            question.setB(list.get(i).getB());
            question.setC(list.get(i).getC());
            question.setD(list.get(i).getD());
            question.setANSWER(list.get(i).getANSWER());
            question.setPOS(list.get(i).getPOS());
            a+= question.toString();
        }
        tvDS.setText(a);
    }

    public void insertQuestion(View view) {
        Question question=new Question();
        question.setCauHoi(txtQuestion.getText()+"");
        question.setA(txtA.getText()+"");
        question.setB(txtB.getText()+"");
        question.setC(txtC.getText()+"");
        question.setD(txtD.getText()+"");
        question.setANSWER(txtAnswer.getText()+"");
        question.setPOS(Integer.parseInt(txtPos.getText()+""));
        long  result= questionDatabase.insertCauHoi(question);
        if(result>0){
            Toast.makeText(this,"Them thanh cong",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Loi", Toast.LENGTH_LONG).show();
        }
    }

    public void Xoa(View view) {
        int id=Integer.parseInt(txtid.getText()+"");
        long result= questionDatabase.deleteCauHoi(id);
        if(result>0){
            Toast.makeText(this,"Xóa thanh cong",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Loi", Toast.LENGTH_LONG).show();
        }
    }
}