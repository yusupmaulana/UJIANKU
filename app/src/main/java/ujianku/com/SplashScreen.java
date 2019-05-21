package ujianku.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
/*
 * Nim : 10116093
 * Nama : Yusup Maulanadireja
 * Kelas : IF-3/AKB-3
 * Tanggal Pengerjaan : 19 Mei 2019
 * */

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,WelcomeScreen.class));
                finish();
            }
        },3000);
    }
}
