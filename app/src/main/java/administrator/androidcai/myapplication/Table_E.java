package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kofigyan.stateprogressbar.StateProgressBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class Table_E extends AppCompatActivity {

    private TextView text1,text2, text3,howto,namechord;
    public MediaPlayer correct;
    public ImageView dot_1, dot_2,dot_3;
    private ConstraintLayout constraintLayout;


    Animation left_slide;

    int z = 0;


    StateProgressBar stateProgressBar;

    Button next;
    TextView try_again;

    String[] des = {" ", " ", " ", "FINISH"};

    WaveLoadingView waveLoadingView;
    SeekBar seekBar;
    String chord_c = "E";
    String udata ="จับคอร์ด E อย่างไร <<";
    String string_try_again = ">>ลองจับคอร์ดอีกครั้ง<<";
    String one = "1";
    String two ="2";
    String three ="3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table__e);






        Typeface tf = Typeface.createFromAsset(getAssets(),"Cloud.otf");


        text1 = findViewById(R.id.textView12);
        text2 = findViewById(R.id.textView6);
        text3 = findViewById(R.id.textView7);
        text1.setTypeface(tf);
        text2.setTypeface(tf);
        text3.setTypeface(tf);

        next = findViewById(R.id.button_note);
        try_again = findViewById(R.id.try_again_e);


        try_again.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);


        namechord = findViewById(R.id.textView11);




        howto = findViewById(R.id.textView10);




        waveLoadingView = findViewById(R.id.wave123);
        waveLoadingView.setProgressValue(5);
        waveLoadingView.setCenterTitle(chord_c);
        waveLoadingView.setCenterTitleSize(30);
        waveLoadingView.setCenterTitleStrokeColor(10);



        stateProgressBar = findViewById(R.id.bar);
        stateProgressBar.setStateDescriptionData(des);
        stateProgressBar.setStateNumberTypeface("Cloud.otf");
        stateProgressBar.setStateDescriptionTypeface("Cloud.otf");
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);




        ConstraintLayout constraintLayout = findViewById(R.id.layoutxml1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        left_slide = AnimationUtils.loadAnimation(this, R.anim.left_fade);

        dot_1 = findViewById(R.id.dot_1);
        dot_2 = findViewById(R.id.dot_2);



        SpannableString content2 = new SpannableString(string_try_again);
        content2.setSpan(new UnderlineSpan(),0,string_try_again.length(), 0);
        try_again.setText(content2);

        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(),0,udata.length(),0);
        howto.setText(content);


        try_again.setTypeface(tf);
        howto.setTypeface(tf);
        namechord.setTypeface(tf);




        correct = MediaPlayer.create(Table_E.this, R.raw.new_e);


        View overlay = findViewById(R.id.layoutxml1);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        constraintLayout = (ConstraintLayout) findViewById(R.id.layoutxml1);


        constraintLayout.setOnTouchListener(new RelativeLayout.OnTouchListener() {
                                                public boolean onTouch(View v, MotionEvent m) {
                                                    handleTouch(m);
                                                    return true;
                                                }
                                            }


        );


        try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shownumber();
            }
        });


    }

    private void shownumber() {

        text1.setText(one);
        text2.setText(two);
        text3.setText(three);
        try_again.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        stateProgressBar.setAllStatesCompleted(false);
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE );
        z=0;
        waveLoadingView.setProgressValue(5);
    }


    void handleTouch(MotionEvent m) {
        text2 = (TextView) findViewById(R.id.textView7);
        text3 = (TextView) findViewById(R.id.textView6);

        int k = 0;
        int pointerCount = m.getPointerCount();
        int idd = m.getPointerId(k);
        int xx = (int) m.getX();
        int yy = (int) m.getY();


        breakLoop:
        for (int i = 0; i < pointerCount; i++) {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);


            String touchStatus = "✔";
            String BAR1 = "ใช้นิ้วชี้กด";
            String BAR2 = "ใช้นิ้วกลางกด";
            String BAR3 = "ใช้นิ้วนางกด";




            if(z==10)
                id = 10;

            if (id == 0) {
                int id0 = m.getPointerId(i);
                int id1 = m.getPointerId(i);
                int id2 = m.getPointerId(i);

                if (id0 == 0) {

                    if (y >= 333 && y <= 390) {
                        if (x <= 600) {
                            text1.setText(touchStatus);
                            dot_1.clearColorFilter();
                            k = 1;
                            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                            waveLoadingView.setProgressValue(33);
                            waveLoadingView.setAnimDuration(500);
                        } else
                            k = 0;
                    } else {
                        k = 0;
                        text1.setText(BAR1);
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                        waveLoadingView.setProgressValue(0);
                        waveLoadingView.setAnimDuration(200);
                        text2.setText(BAR2);
                        text3.setText(BAR3);
                    }
                }
            }


            if (k == 1) {
                if (id == 1) {
                    if (y >= 536 && y <= 636) {
                        if (x > 600) {
                            if (x <= 1296) {
                                text2.setText(touchStatus);
                                k = 2;
                                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                                text2.setText(touchStatus);
                                waveLoadingView.setProgressValue(60);
                                waveLoadingView.setAnimDuration(500);
                                if (m.getAction() == MotionEvent.ACTION_UP) {
                                    text2.setText(BAR2);
                                    stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                                    waveLoadingView.setProgressValue(30);
                                    waveLoadingView.setAnimDuration(200);
                                }
                            }
                            else
                                k = 0;
                        }
                    }
                    else {
                        k = 0;
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        text2.setText(BAR2);
                    }
                }
            }


            if (k == 2) {
                if (id == 2) {
                    if (y >= 420 && y <= 533) {
                        if (x > 600) {
                            if (x <= 1289) {
                                text3.setText(touchStatus);
                                k++;
                                stateProgressBar.setAllStatesCompleted(true);
                                z = 10;
                                waveLoadingView.setProgressValue(101);
                                waveLoadingView.setAnimDuration(500);
                            }
                        }
                    }
                }
            }





            if (k == 3) {
                text2.setText(touchStatus);
                text3.setText(touchStatus);
                correct.start();
                next.setVisibility(View.VISIBLE);
                try_again.setVisibility(View.VISIBLE);
                try_again.setEnabled(true);
                next.startAnimation(left_slide);
                break breakLoop;
            }
        }
    }
}



