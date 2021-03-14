package com.example.matranoso;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.TextView;

public class SetKieuChu {
    String arr[] = new String[]{"UVNVan_B.TTF"};

    public void set(Context ct, TextView t, int i) {
        t.setTypeface(Typeface.createFromAsset(ct.getAssets(), arr[i]));
    }
    public void set(Context ct, Button t, int i) {
        t.setTypeface(Typeface.createFromAsset(ct.getAssets(), arr[i]));
    }

    public void set(Context ct, TextView t, int i, boolean bold) {
        if (bold) {
            t.setTypeface(Typeface.createFromAsset(ct.getAssets(), arr[i]), Typeface.BOLD);
        } else {
            t.setTypeface(Typeface.createFromAsset(ct.getAssets(), arr[i]));
        }
    }


}
