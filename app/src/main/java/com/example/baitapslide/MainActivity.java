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
    Button btBack, btNext;
    int dem = 0, count = 1;
    int[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        imgV = findViewById(id.imgView);
        btBack = findViewById(id.btLeft);
        btNext = findViewById(id.btRight);
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
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (count) {
                    case 1:
                        imgV.setImageResource(R.drawable.hinh1);
                        count++;
                        break;
                    case 2:
                        imgV.setImageResource(R.drawable.h1);
                        count++;
                        break;
                    case 3:
                        imgV.setImageResource(R.drawable.h2);
                        count++;
                        break;
                    case 4:
                        imgV.setImageResource(R.drawable.h3);
                        count = 0;
                        break;
                }
            }
        });

        // anh thêm đại vô để có sự thây đổi để mà up lên git
    }
}
