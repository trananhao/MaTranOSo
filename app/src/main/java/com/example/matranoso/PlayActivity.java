package com.example.matranoso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.matranoso.adapter.OSoHienThiAdapter;
import com.example.matranoso.object.OSos;
import com.example.matranoso.object.Tool1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlayActivity extends AppCompatActivity {

    GridView gdvOHien, gdvOAn;
    TextView txvQuaMan, txvDiem, txvDiemCaoNhat, txvTimer;
    boolean thua = false;
    boolean quaman = false;
    CountDownTimer timer;

    Tool1 tool1 = new Tool1();
    int lever = 5, diem = 0;
    int diemCaoNhat = 0;
    int vitriODuocChon = -1;

    OSoHienThiAdapter adtOHien;
    OSoHienThiAdapter adtOAn;
    SetKieuChu style = new SetKieuChu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        gdvOHien = (GridView) findViewById(R.id.gdvOHien);
        gdvOAn = (GridView) findViewById(R.id.gdvOAn);
        txvQuaMan = (TextView) findViewById(R.id.txvQuaMan);
        txvDiem = (TextView) findViewById(R.id.txvDiem);
        txvDiemCaoNhat = (TextView) findViewById(R.id.txvDiemCaoNhat);
        txvTimer = (TextView) findViewById(R.id.txvTimer);
        style.set(this, txvDiem, 0);
        style.set(this, txvQuaMan, 0);
        style.set(this, txvDiemCaoNhat, 0);
        style.set(this, txvTimer, 0);

        txvDiemCaoNhat.setText("0");
        setClick();
        taoMaTran();
    }

    public void setClick() {
        gdvOHien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                OSos o = tool1.getListOHienThi().get(i);
                if (o.duocClick) {
                    vitriODuocChon = i;
                    for (OSos os : tool1.getListOHienThi()) {
                        os.duocChon = false;
                    }
                    tool1.getListOHienThi().get(i).duocChon = true;
                    update();
                }
            }
        });
        gdvOAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = tool1.getListOBiAn().get(i).text;
                if (vitriODuocChon != -1) {
                    tool1.set(vitriODuocChon, s);
                    boolean hetOTrang = true;
                    for (OSos os : tool1.getListOHienThi()) {
                        if (os.duocClick) {
                            if (os.taman) {
                                hetOTrang = false;
                                break;
                            }
                        }
                    }
                    if (hetOTrang) {
                        if (tool1.check()) {
                            txvQuaMan.setText("Qua màn");
                            timer.cancel();
                            txvQuaMan.setVisibility(View.VISIBLE);
                            quaman = true;
                        } else {
                            txvQuaMan.setVisibility(View.GONE);
                        }
                    }
                    update();
                }
            }
        });
    }

    public void taoMaTran() {
        vitriODuocChon = -1;

        lever = 5 + (diem / 3);

        tool1.setLever(lever);

        tool1.lamMoi();
        tool1.taoMangPT();
        tool1.chuyenDoiDeHienThi();

        gdvOHien.setNumColumns(tool1.getLever());
        adtOHien = new OSoHienThiAdapter(this, 0, tool1.getListOHienThi());
        gdvOHien.setAdapter(adtOHien);

        adtOAn = new OSoHienThiAdapter(this, 0, tool1.getListOBiAn());
        gdvOAn.setAdapter(adtOAn);

        txvQuaMan.setVisibility(View.GONE);

        FirebaseDatabase.getInstance().getReference()
                .child("DiemCaoNhat")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        txvDiemCaoNhat.setText("Best " + dataSnapshot.getValue());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
        txvDiem.setText("" + diem);

        if (timer != null) {
            timer.cancel();
            timer.start();
        } else {
            timer = new CountDownTimer(30000, 1000) {
                public void onTick(long millisUntilFinished) {
                    txvTimer.setText("" + millisUntilFinished / 1000);
                }

                public void onFinish() {

                    txvTimer.setText("Hết Giờ");
                    thua = true;

                    androidx.appcompat.app.AlertDialog.Builder alertDialogBuilder = new androidx.appcompat.app.AlertDialog.Builder(PlayActivity.this);
                    alertDialogBuilder
                            .setMessage("Bạn đã thua!")
                            .setCancelable(false)
                            .setPositiveButton("Chơi lại", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    lever = 5;
                                    diem = 0;
                                    thua = false;
                                    taoMaTran();
                                }
                            })
                            .setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            }.start();
        }
    }

    public void update() {
        adtOHien.notifyDataSetChanged();
    }

    public void quaMan(View view) {
        if (thua = true) {
            lever = 5;
            thua = false;
            diem = diem + tool1.getDiem();
            FirebaseDatabase.getInstance().getReference()
                    .child("DiemCaoNhat")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            diemCaoNhat = Integer.parseInt(dataSnapshot.getValue() + "");
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });

            FirebaseDatabase.getInstance().getReference()
                    .child("DiemCaoNhat")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (diem > diemCaoNhat) {
                                FirebaseDatabase.getInstance().getReference()
                                        .child("DiemCaoNhat").setValue(diem);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }
                    });

            taoMaTran();
        } else {
            if (quaman = true) {
                lever++;
                quaman = false;
                diem = diem + tool1.getDiem();
                FirebaseDatabase.getInstance().getReference()
                        .child("DiemCaoNhat")
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                diemCaoNhat = Integer.parseInt(dataSnapshot.getValue() + "");
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                if (diem > diemCaoNhat) {
                    FirebaseDatabase.getInstance().getReference()
                            .child("DiemCaoNhat")
                            .addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    FirebaseDatabase.getInstance().getReference()
                                            .child("DiemCaoNhat").setValue(diem);

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                }
                taoMaTran();
            }
        }
    }
}
