package com.example.baitapslide;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import static com.example.baitapslide.R.*;
public class MainActivity extends AppCompatActivity {
    ImageView imgV;
    int[] arrayImg = {
            drawable.hinh1,
            drawable.h1,
            drawable.h2,
            drawable.h3
    };
    Button btnPrev, btnNext;
    int dem = 0, count = 0;
    int[] array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        imgV = findViewById(id.imgView);
        btnPrev = findViewById(id.btLeft);
        btnNext = findViewById(id.btRight);
        array = new int[4];
        final CountDownTimer countDownTimer = new CountDownTimer(7000, 2000) {
            @Override
            public void onTick(long l) {
                if (dem == 4)
                    dem = 0;
                imgV.setImageResource(arrayImg[dem++]);
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
        countDownTimer.start();
        btnNext.setOnClickListener(view -> {
            switch (count) {
                case 0:
                    imgV.setImageResource(drawable.hinh1);
                    count++;
                    break;
                case 1:
                    imgV.setImageResource(drawable.h1);
                    count++;
                    break;
                case 2:
                    imgV.setImageResource(drawable.h2);
                    count++;
                    break;
                case 3:
                    imgV.setImageResource(drawable.h3);
                    count = 0;
                    break;
            }
        });

        btnPrev.setOnClickListener(v -> {
                switch (count) {
                    case 0:
                        imgV.setImageResource(R.drawable.h3);
                        count++;
                        break;
                    case 1:
                        imgV.setImageResource(drawable.hinh1);
                        count++;
                        break;
                    case 2:
                        imgV.setImageResource(R.drawable.h1);
                        count++;
                        break;
                    case 3:
                        imgV.setImageResource(R.drawable.h2);
                        count = 0;
                        break;

                }
        });

        // anh thêm đại vô để có sự thây đổi để mà up lên git
    }
}
