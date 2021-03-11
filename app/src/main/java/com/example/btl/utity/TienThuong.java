package com.example.btl.utity;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.btl.R;

import java.util.ArrayList;
import java.util.List;

public class TienThuong extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> arr;
    int viTriCauHoi=1;
    public TienThuong( Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.context=context;
        this.arr=new ArrayList<>(objects);
    }
    public void setVitriCauHoi(int viTriCauHoi){
        this.viTriCauHoi=viTriCauHoi;
        notifyDataSetChanged();

    }
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_tien_thuong,null);
        }
        if(arr.size()>0){
            int vt=15-position;
            TextView txvTienThuong=convertView.findViewById(R.id.txvTienThuong);
            if((vt)%5==0){
                txvTienThuong.setTextColor(Color.parseColor("#FFFFFF"));
            }
            else {
                txvTienThuong.setTextColor(Color.parseColor("#FF9800"));
            }
            String hienThi=vt+ "      $"+arr.get(position);
            txvTienThuong.setText(hienThi);
            if(vt==viTriCauHoi){
                txvTienThuong.setBackgroundColor(Color.parseColor("#0099cc"));
                txvTienThuong.setTextColor(Color.parseColor("#FFFFFF"));
            }else {
                txvTienThuong.setBackgroundColor(Color.parseColor("#BFC4DD"));
            }
        }
        return convertView;
    }
}
