package com.example.matranoso.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.matranoso.R;
import com.example.matranoso.SetKieuChu;
import com.example.matranoso.custom.TXVOVuong;
import com.example.matranoso.object.OSos;

import java.util.ArrayList;
import java.util.List;

public class OSoHienThiAdapter extends ArrayAdapter<OSos> {
    private Context ct;
    private ArrayList<OSos> arr;
    SetKieuChu style = new SetKieuChu();
    public OSoHienThiAdapter(Context context, int resource, List<OSos> objects) {
        super(context, resource, objects);
        this.ct = context;
        arr = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(ct.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_o_play,null);
        }

        if (arr.size() > 0) {
            TXVOVuong txvHienThi = convertView.findViewById(R.id.txvHienThi);
            style.set(ct,txvHienThi,0);
            OSos o = arr.get(position);
            if (o.hien) {
                if (o.duocChon) {
                    txvHienThi.setBackgroundResource(R.drawable.bg_o_duoc_chon);
                } else {
                    txvHienThi.setBackgroundResource(R.drawable.bg_o_choi);
                }
            } else {
                txvHienThi.setBackgroundColor(Color.parseColor("#00000000"));
            }
            if (o.taman) {
                txvHienThi.setText(" ");
            } else {
                txvHienThi.setText(o.text);
            }
        }
        return convertView;
    }
}
