package com.example.matranoso;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlaySongService extends Service {
    private MediaPlayer mediaPlayer;

    public PlaySongService() {
    }


    @Override
    public IBinder onBind(Intent intent){
        // Service này là loại không giàng buộc (Un bounded)
        // Vì vậy method này ko bao giờ được gọi.
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        // Tạo đối tượng MediaPlayer, chơi file nhạc của bạn.
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        // Chơi nhạc.
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return START_STICKY;
    }

    // Hủy bỏ dịch vụ.
    @Override
    public void onDestroy() {
        // Giải phóng nguồn dữ nguồn phát nhạc.
        mediaPlayer.release();
        super.onDestroy();
    }
}
