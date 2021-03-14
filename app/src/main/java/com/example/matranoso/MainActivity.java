package com.example.matranoso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMusic = findViewById(R.id.btnMusic);
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(view);
            }
        });
        findViewById(R.id.btnHuongDan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huongDan();
            }
        });

    }

    public void huongDan() {
        Intent intent = new Intent(this, HuongDanActivity.class);
        startActivity(intent);
    }

    public void choi(View view) {
        startActivity(new Intent(this, PlayActivity.class));
    }

    public void playSong(View view) {
        startService(new Intent(this, PlaySongService.class));
    }


}
