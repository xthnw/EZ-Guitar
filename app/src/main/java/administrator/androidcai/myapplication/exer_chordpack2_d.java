package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.kofigyan.stateprogressbar.StateProgressBar;

import cn.pedant.SweetAlert.SweetAlertDialog;
import me.itangqi.waveloadingview.WaveLoadingView;

public class exer_chordpack2_d extends AppCompatActivity {

    private TextView text1, text2, text3,howto,name_chord,try_again;
    public MediaPlayer correct;
    public ImageView dot_1, dot_2, dot_3;
    private ConstraintLayout constraintLayout;
    private Button next;
    Animation uptodown,downtoup,lefttoright;
    String udata ="จับคอร์ด D อย่างไร <<";
    String string_try_again = ">>ลองจับคอร์ดอีกครั้ง<<";
    String one ="1";
    String two ="2";
    String three ="3";


    private Animation  mShakeAnimation;



    Animation left_slide;

    int z=0;


    StateProgressBar stateProgressBar;

    Button button2;

    String[] des = {" "," "," ","FINISH"};

    WaveLoadingView waveLoadingView;
    SeekBar seekBar;
    String chord_c = "D";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer_chordpack2_d);



        waveLoadingView = findViewById(R.id.wave123);
        waveLoadingView.setProgressValue(5);
        waveLoadingView.setCenterTitle(chord_c);
        waveLoadingView.setCenterTitleSize(30);
        waveLoadingView.setCenterTitleStrokeColor(10);




        howto = findViewById(R.id.howto_d);
        name_chord = findViewById(R.id.name_chord_d);
        try_again = findViewById(R.id.try_again_d);


        text1 = (TextView)findViewById(R.id.textView5);
        text2 = (TextView)findViewById(R.id.textView6);
        text3 = (TextView)findViewById(R.id.textView7);


        SpannableString content2 = new SpannableString(string_try_again);
        content2.setSpan(new UnderlineSpan(),0,string_try_again.length(), 0);
        try_again.setText(content2);

        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(),0,udata.length(),0);
        howto.setText(content);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);


        Typeface tf = Typeface.createFromAsset(getAssets(),"Cloud.otf");


        stateProgressBar = findViewById(R.id.bar);
        stateProgressBar.setStateDescriptionData(des);
        stateProgressBar.setStateNumberTypeface("Cloud.otf");
        stateProgressBar.setStateDescriptionTypeface("Cloud.otf");

        left_slide = AnimationUtils.loadAnimation(this,R.anim.left_fade);


        ConstraintLayout constraintLayout = findViewById(R.id.layoutxml1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();







        try_again.setTypeface(tf);
        try_again.setVisibility(View.INVISIBLE);
        howto.setTypeface(tf);
        name_chord.setTypeface(tf);
        text1.setTypeface(tf);
        text2.setTypeface(tf);
        text3.setTypeface(tf);
        dot_1 = findViewById(R.id.dot_1);
        dot_2 = findViewById(R.id.dot_2);
        dot_3 = findViewById(R.id.dot_3);


        mShakeAnimation = AnimationUtils.loadAnimation(exer_chordpack2_d.this,R.anim.shake_area);


        dot_1.startAnimation(mShakeAnimation);
        dot_2.startAnimation(mShakeAnimation);
        dot_3.startAnimation(mShakeAnimation);

        correct = MediaPlayer.create(exer_chordpack2_d.this,R.raw.new_d);


        View overlay =  findViewById(R.id.layoutxml1);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        constraintLayout = (ConstraintLayout)findViewById(R.id.layoutxml1);



        constraintLayout.setOnTouchListener(new RelativeLayout.OnTouchListener(){
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



        howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SweetAlertDialog dialog = new SweetAlertDialog(exer_chordpack2_d.this,SweetAlertDialog.WARNING_TYPE);
                dialog.getWindow(). setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                dialog.setTitleText("มือซ้าย");
                dialog.setContentText("1.ใช้นิ้วชี้แตะที่ช่องหมายเลข 1<BR>2.ใช้นิ้วกลางแตะที่ช่องหมายเลข 2<BR>3.ใช้นิ้วนางแตะที่ช่องหมายเลข 3");
                dialog.setContentTextSize(12);
                dialog.setConfirmText("OK");
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        dialog.dismiss();
                    }
                }).show();
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



        ImageView back =  (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2();
            }
        });
    }

    public void openMain2(){
        Intent intent = new Intent(this,Main6Activity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        finish();
    }

    public void openTable_CActivity(){
        Intent intent = new Intent(this, exer_chordpack2_g.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        finish();
    }

    public void shownumber(){
        text1.setText(one);
        text2.setText(three);
        text3.setText(two);
        try_again.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        stateProgressBar.setAllStatesCompleted(false);
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
        z=0;
        waveLoadingView.setProgressValue(5);
        dot_1.startAnimation(mShakeAnimation);
        dot_2.startAnimation(mShakeAnimation);
        dot_3.startAnimation(mShakeAnimation);
    }



    void handleTouch(MotionEvent  m)
    {
        text1 = (TextView)findViewById(R.id.textView5);
        text2 = (TextView)findViewById(R.id.textView6);
        text3 = (TextView)findViewById(R.id.textView7);



        int k=0;
        int pointerCount = m.getPointerCount();
        int idd = m.getPointerId(k);
        int xx  = (int) m.getX();
        int yy = (int) m.getY();


        breakLoop:
        for(int i=0; i< pointerCount; i++) {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);

            String touchStatus = "✔";
            String BAR1 = "ใช้นิ้วชี้กด";
            String BAR2 = "ใช้นิ้วนางกด";
            String BAR3 = "ใช้นิ้วกลางกด";




            if(z==10)
                id = 10;

            if (id == 0) {
                int ani=0;
                int id0 = m.getPointerId(i);
                int id1 = m.getPointerId(i);
                int id2 = m.getPointerId(i);

                if (id0 == 0) {
                    if (y >= 320 && y <= 418) {
                        if (x > 720) {
                            if (x <= 1290) {
                                dot_1.clearAnimation();
                                text1.setText(touchStatus);
                                dot_1.clearColorFilter();
                                k = 1;
                                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                                waveLoadingView.setProgressValue(33);
                                waveLoadingView.setAnimDuration(500);
                            }
                            else
                                k = 0;
                        }

                    }
                    else {
                        k = 0;

                        dot_1.startAnimation(mShakeAnimation);
                        dot_2.startAnimation(mShakeAnimation);
                        dot_3.startAnimation(mShakeAnimation);
                        text1.setText(BAR1);
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                        waveLoadingView.setProgressValue(0);
                        waveLoadingView.setAnimDuration(200);
                        text2.setText(BAR2);
                        text3.setText(BAR3);
                    }
                }
            }




            if(k == 1) {
                if (id == 1) {
                    if (y >= 90 && y <= 140) {
                        if (x > 660) {
                            if (x <= 1290) {
                                k = 2;
                                dot_2.clearAnimation();
                                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                                text3.setText(touchStatus);
                                waveLoadingView.setProgressValue(60);
                                waveLoadingView.setAnimDuration(500);
                                if (m.getAction() == MotionEvent.ACTION_UP) {
                                    text3.setText(BAR2);
                                    dot_2.startAnimation(mShakeAnimation);
                                    stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                                    waveLoadingView.setProgressValue(30);
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
                        text3.setText(BAR2);
                        dot_2.startAnimation(mShakeAnimation);
                    }
                }
            }




            if(k == 2) {
                if (id == 2) {
                    if (y >= 195 && y <= 299) {
                        if (x > 1317) {
                            if (x <= 1861) {
                                dot_3.clearAnimation();
                                text2.setText(touchStatus);
                                k++;
                                stateProgressBar.setAllStatesCompleted(true);
                                z=10;
                                waveLoadingView.setProgressValue(101);
                                waveLoadingView.setAnimDuration(500);
                            }
                        }
                    }
                }
            }




            if (k == 3) {
                text1.setText(touchStatus);
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

