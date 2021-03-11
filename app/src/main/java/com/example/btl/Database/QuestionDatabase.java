package com.example.btl.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.btl.utity.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDatabase extends SQLiteOpenHelper {
    public QuestionDatabase(Context context) {
        super(context, "ALTP1.db", null, 1);
    }
    public static final String TABLE_NAME="CAUHOI";
    public static final String COLUMN_ID="ID";
    public static final String COLUMN_QUESTION="QUESTION";
    public static final String COLUMN_A="D_A";
    public static final String COLUMN_B="D_B";
    public static final String COLUMN_C="D_C";
    public static final String COLUMN_D="D_D";
    public static final String COLUMN_ANSWER="ANSWER";
    public static final String COLUMN_POS="POS";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+TABLE_NAME+"("
                +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                +COLUMN_QUESTION+" TEXT NOT NULL,"
                +COLUMN_A+" TEXT NOT NULL,"
                +COLUMN_B+" TEXT NOT NULL,"
                +COLUMN_C+" TEXT NOT NULL,"
                +COLUMN_D+" TEXT NOT NULL,"
                +COLUMN_ANSWER+" TEXT NOT NULL,"
                +COLUMN_POS+" Integer NOT NULL"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long insertCauHoi(Question question){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_QUESTION,question.getCauHoi());
        contentValues.put(COLUMN_A,question.getA());
        contentValues.put(COLUMN_B,question.getB());
        contentValues.put(COLUMN_C,question.getC());
        contentValues.put(COLUMN_D,question.getD());
        contentValues.put(COLUMN_ANSWER,question.getANSWER());
        contentValues.put(COLUMN_POS,question.getPOS());
        long result= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return result;
    }
    public long updateCauHoi(Question question){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_ID,question.getId());
        contentValues.put(COLUMN_QUESTION,question.getCauHoi());
        contentValues.put(COLUMN_A,question.getA());
        contentValues.put(COLUMN_B,question.getB());
        contentValues.put(COLUMN_C,question.getC());
        contentValues.put(COLUMN_D,question.getD());
        contentValues.put(COLUMN_ANSWER,question.getANSWER());
        contentValues.put(COLUMN_POS,question.getPOS());
        long result=sqLiteDatabase.update(TABLE_NAME,contentValues,COLUMN_ID+"=?",new String[]{String.valueOf(question.getId())});
        return result;
    }
    public long deleteCauHoi(Integer id){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        long result=sqLiteDatabase.delete(TABLE_NAME,COLUMN_ID+"=?",new String[]{String.valueOf(id)});
        return result;
    }
    public long deleteALL(){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        long result=sqLiteDatabase.delete(TABLE_NAME,null,null);

        return result;
    }
    public List<Question> getAllQuestion(){
        List<Question> questionList=new ArrayList<>();
        String sql="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                int id=cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String cauHoi1=cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION));
                String A=cursor.getString(cursor.getColumnIndex(COLUMN_A));
                String B=cursor.getString(cursor.getColumnIndex(COLUMN_B));
                String C=cursor.getString(cursor.getColumnIndex(COLUMN_C));
                String D=cursor.getString(cursor.getColumnIndex(COLUMN_D));
                String ANSWER=cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER));
                int POS=cursor.getInt(cursor.getColumnIndex(COLUMN_POS));
                Question question=new Question(id,cauHoi1,A,B,C,D,ANSWER,POS);
                cursor.moveToNext();
                questionList.add(question);
            }
            sqLiteDatabase.close();
        }
        return questionList;
    }
    public List<Question> getQuestionByID(int randomID){
        List<Question> questionList=new ArrayList<>();
        String sql="SELECT * FROM "+TABLE_NAME+" WHERE ID=" + randomID;
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                int id=cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String cauHoi1=cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION));
                String A=cursor.getString(cursor.getColumnIndex(COLUMN_A));
                String B=cursor.getString(cursor.getColumnIndex(COLUMN_B));
                String C=cursor.getString(cursor.getColumnIndex(COLUMN_C));
                String D=cursor.getString(cursor.getColumnIndex(COLUMN_D));
                String ANSWER=cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER));
                int POS=cursor.getInt(cursor.getColumnIndex(COLUMN_POS));
                Question question=new Question(id,cauHoi1,A,B,C,D,ANSWER,POS);
                cursor.moveToNext();
                questionList.add(question);
            }
            sqLiteDatabase.close();
        }
        return questionList;
    }
    public int demCauHoi(){
        List<Question> list=getAllQuestion();
        int count=list.size();
        return count;
    }

}
