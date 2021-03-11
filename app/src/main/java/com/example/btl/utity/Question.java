package com.example.btl.utity;


public class Question {
    private int id;
    private String cauHoi;
    private String A;
    private String B;
    private String C;
    private String D;
    private String ANSWER;
    private int POS;

    public Question(int id,String cauHoi, String a, String b, String c, String d, String ANSWER, int POS) {
        this.id=id;
        this.cauHoi = cauHoi;
        A = a;
        B = b;
        C = c;
        D = d;
        this.ANSWER = ANSWER;
        this.POS = POS;
    }
    public Question(String cauHoi, String a, String b, String c, String d, String ANSWER, int POS) {
        this.cauHoi = cauHoi;
        A = a;
        B = b;
        C = c;
        D = d;
        this.ANSWER = ANSWER;
        this.POS = POS;
    }
    public Question(int id){
        this.id=id;
    }
    public Question(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    public int getPOS() {
        return POS;
    }

    public void setPOS(int POS) {
        this.POS = POS;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", cauHoi='" + cauHoi + '\'' +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", ANSWER='" + ANSWER + '\'' +
                ", POS=" + POS +
                '}';
    }
}
