package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.icu.text.UnicodeSet;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.VibrationEffect;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.kofigyan.stateprogressbar.StateProgressBar;
import com.library.NavigationBar;

import java.lang.reflect.Type;

import me.itangqi.waveloadingview.WaveLoadingView;

public class Table_Cmaj7 extends AppCompatActivity {

    private TextView text2, text3, howto, name_chord, try_again;
    public MediaPlayer correct;
    public ImageView dot_2, dot_3;
    private ConstraintLayout constraintLayout;
    private Button next;
    String udata = "จับคอร์ด C อย่างไร <<";
    String string_try_again = ">>ลองจับคอร์ดอีกครั้ง<<";
    String one = "1";
    String two = "2";
    String three = "3";
    Animation uptodown, downtoup, lefttoright;
    TextView textView;
    Animation left_slide;

    int z = 0;

    int cor = 0;


    StateProgressBar stateProgressBar;

    Button button2;

    String[] des = {" ", " ", " ", "FINISH"};

    WaveLoadingView waveLoadingView;
    SeekBar seekBar;
    String chord_c = "Cmaj7";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table__cmaj7);


        waveLoadingView = findViewById(R.id.wave123);
        waveLoadingView.setProgressValue(5);
        waveLoadingView.setCenterTitle(chord_c);
        waveLoadingView.setCenterTitleSize(22);
        waveLoadingView.setCenterTitleStrokeColor(10);


        Typeface tf = Typeface.createFromAsset(getAssets(), "Cloud.otf");
        stateProgressBar = findViewById(R.id.bar);
        stateProgressBar.setStateDescriptionData(des);
        stateProgressBar.setStateNumberTypeface("Cloud.otf");
        stateProgressBar.setStateDescriptionTypeface("Cloud.otf");

        left_slide = AnimationUtils.loadAnimation(this, R.anim.left_fade);


        howto = findViewById(R.id.textView9);
        name_chord = findViewById(R.id.textView8);
        try_again = findViewById(R.id.try_again);

        text2 = (TextView) findViewById(R.id.textView6);
        text3 = (TextView) findViewById(R.id.textView7);


        SpannableString content2 = new SpannableString(string_try_again);
        content2.setSpan(new UnderlineSpan(), 0, string_try_again.length(), 0);
        try_again.setText(content2);

        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);
        howto.setText(content);


        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this, R.anim.lefttoright);


        text2.setTypeface(tf);
        text3.setTypeface(tf);
        try_again.setTypeface(tf);
        try_again.setVisibility(View.INVISIBLE);
        try_again.setEnabled(false);
        howto.setTypeface(tf);
        name_chord.setTypeface(tf);
        dot_2 = findViewById(R.id.dot_2);
        dot_3 = findViewById(R.id.dot_3);

        correct = MediaPlayer.create(Table_Cmaj7.this, R.raw.chord_c);


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


        next = findViewById(R.id.button_note);
        next.setTypeface(tf);
        next.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTable_CActivity();
            }
        });


        ImageView back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2();
            }
        });


    }


    public void openMain2() {
        Intent intent = new Intent(this, Main6Activity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        finish();
    }

    public void openTable_CActivity() {
        Intent intent = new Intent(this, Table_Am.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        finish();
    }

    public void shownumber() {
        text2.setText(two);
        text3.setText(three);
        try_again.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        stateProgressBar.setAllStatesCompleted(false);
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
        z = 0;
        waveLoadingView.setProgressValue(5);
    }


    void handleTouch(MotionEvent  m) {

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        final long[] pattern = {2000, 1000};
        text2 = (TextView) findViewById(R.id.textView6);
        text3 = (TextView) findViewById(R.id.textView7);

        int k = 0;
        int vi = 0;
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
            String BAR2 = "2";
            String BAR3 = "3";


            if(z==10)
                id = 10;

            if (id == 0) {
                int id0 = m.getPointerId(i);
                int id1 = m.getPointerId(i);
                int id2 = m.getPointerId(i);



                if (id0 == 0) {
                    if (y >= 420 && y <= 518) {
                        if (x > 750) {
                            if (x <= 1290) {
                                k = 1;
                                text2.setText(touchStatus);
                                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                                waveLoadingView.setProgressValue(50);
                                waveLoadingView.setAnimDuration(500);
                                if (m.getAction() == MotionEvent.ACTION_UP) {
                                    text2.setText(BAR2);
                                    stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                                    waveLoadingView.setProgressValue(0);
                                    waveLoadingView.setAnimDuration(200);
                                }
                            }
                            else
                                k = 0;
                        }

                    }
                    else
                    {
                        k = 0;
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        waveLoadingView.setProgressValue(0);
                        waveLoadingView.setAnimDuration(200);
                        text2.setText(BAR2);
                        text3.setText(BAR3);
                    }
                }
            }





            if (k == 1) {
                if (id == 1) {
                    if (y >= 524 && y <= 622) {
                        if (x > 1326) {
                            if (x <= 1854) {
                                k = 2;
                                stateProgressBar.setAllStatesCompleted(true);
                                text3.setText(touchStatus);
                                waveLoadingView.setProgressValue(101);
                                waveLoadingView.setAnimDuration(500);
                                z=10;
                            }

                        }

                    }

                }
            }





            if (k == 2) {
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

