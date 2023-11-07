package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class gamever2_chord_c extends AppCompatActivity {

    String chord_c = "C";
    WaveLoadingView waveLoadingView;
    int z=0;
    private float x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamever2_chord_c);



        waveLoadingView = findViewById(R.id.wave123);
        waveLoadingView.setProgressValue(5);
        waveLoadingView.setCenterTitle(chord_c);
        waveLoadingView.setCenterTitleSize(45);
        waveLoadingView.setCenterTitleStrokeColor(10);




        View overlay =  findViewById(R.id.layoutxml1);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.layoutxml1);


        constraintLayout.setOnTouchListener(new ConstraintLayout.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                x = m.getX();
                y = m.getY();
                int k = 0;

                int pointerCount = m.getPointerCount();

                for (int i = 0; i < pointerCount; i++) {
                    int x = (int) m.getX(i);
                    int y = (int) m.getY(i);
                    int id = m.getPointerId(i);
                    int id0 = 0;
                    int end_id = 100;


                    String touchStatus = "✔";
                    String BAR1 = "1";
                    String BAR2 = "2";
                    String BAR3 = "3";
                    String ID1 = "ID:" + id;


                    if (id == 0) {
                        if (y >= 210 && y <= 283) {
                            if (x <= 716) {

                                k++;
                            }
                        }
                    }

                    if (id == 1) {
                        if (y >= 420 && y <= 518) {
                            if (x > 750) {
                                if (x <= 1290) {

                                    k++;

                                }
                            }
                        }
                    }

                    if (id == 2) {
                        if (y >= 524 && y <= 622) {
                            if (x > 1326) {
                                if (x <= 1854) {

                                    k = 3;


                                }

                            }
                        }
                        if (m.getAction() == MotionEvent.ACTION_POINTER_UP || m.getAction() == MotionEvent.ACTION_POINTER_DOWN) {
                            opengame_am();
                            return true;
                        }
                    }

                }
                return true;
            }
        });




    }
    public void opengame_am(){
        Intent opengame = new Intent(this,game_chord_am.class);
        startActivity(opengame);
        finish();

    }


}
