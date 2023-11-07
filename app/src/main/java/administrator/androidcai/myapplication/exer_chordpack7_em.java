package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;

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

public class exer_chordpack7_em extends AppCompatActivity {

    private TextView text2, text3,howto,namechord;
    public MediaPlayer correct;
    public ImageView dot_1, dot_2;
    private ConstraintLayout constraintLayout;


    Animation left_slide;

    int z = 0;


    StateProgressBar stateProgressBar;

    Button next;
    TextView try_again;

    String[] des = {" ", " ", " ", "FINISH"};

    WaveLoadingView waveLoadingView;
    SeekBar seekBar;
    String chord_c = "Em";
    String udata ="จับคอร์ด Em อย่างไร <<";
    String string_try_again = ">>ลองจับคอร์ดอีกครั้ง<<";
    String two ="2";
    String three ="3";

    private Animation  mShakeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exer_chordpack7_em);



        ImageView back =  (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),boardcast_learn.class);
                startActivity(intent);
                Animatoo.animateSlideDown(exer_chordpack7_em.this);
                finish();
            }
        });




        Typeface tf = Typeface.createFromAsset(getAssets(),"Cloud.otf");


        text2 = findViewById(R.id.textView6);
        text3 = findViewById(R.id.textView7);
        text2.setTypeface(tf);
        text3.setTypeface(tf);

        next = findViewById(R.id.button_note);
        try_again = findViewById(R.id.try_again_em);


        try_again.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennext();
            }
        });




        namechord = findViewById(R.id.textView11);




        howto = findViewById(R.id.textView10);

        howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SweetAlertDialog dialog = new SweetAlertDialog(exer_chordpack7_em.this,SweetAlertDialog.WARNING_TYPE);
                dialog.getWindow(). setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                dialog.setTitleText("มือซ้าย");
                dialog.setContentText("1.ใช้นิ้วกลางแตะที่ช่องหมายเลข 2<BR>2.ใช้นิ้วนางแตะที่ช่องหมายเลข 3");
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



        mShakeAnimation = AnimationUtils.loadAnimation(exer_chordpack7_em.this,R.anim.shake_area);



        dot_1.startAnimation(mShakeAnimation);
        dot_2.startAnimation(mShakeAnimation);


        SpannableString content2 = new SpannableString(string_try_again);
        content2.setSpan(new UnderlineSpan(),0,string_try_again.length(), 0);
        try_again.setText(content2);

        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(),0,udata.length(),0);
        howto.setText(content);


        try_again.setTypeface(tf);
        howto.setTypeface(tf);
        namechord.setTypeface(tf);






        correct = MediaPlayer.create(exer_chordpack7_em.this, R.raw.new_em);


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


    public void opennext(){
        Intent intent = new Intent(this, exer_chordpack_7_am.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
        finish();
    }


    private void shownumber() {

        text2.setText(two);
        text3.setText(three);
        try_again.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        stateProgressBar.setAllStatesCompleted(false);
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
        z=0;
        waveLoadingView.setProgressValue(5);
        dot_1.startAnimation(mShakeAnimation);
        dot_2.startAnimation(mShakeAnimation);
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
            String BAR2 = "ใช้นิ้วกลางกด";
            String BAR3 = "ใช้นิ้วนางกด";




            if(z==10)
                id = 10;
            if (id == 0) {
                int id0 = m.getPointerId(i);
                int id1 = m.getPointerId(i);
                int id2 = m.getPointerId(i);

                if (id0 == 0) {

                    if (y >= 526 && y <= 596) {
                        if (x >= 665) {
                            if (x <= 1296) {

                                dot_1.clearAnimation();
                                text2.setText(touchStatus);
                                dot_1.clearColorFilter();
                                k = 1;
                                stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                                waveLoadingView.setProgressValue(50);
                                waveLoadingView.setAnimDuration(500);
                            } else
                                k = 0;
                        }
                        else {
                            k = 0;
                            dot_1.startAnimation(mShakeAnimation);
                            dot_2.startAnimation(mShakeAnimation);
                            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                            waveLoadingView.setProgressValue(0);
                            waveLoadingView.setAnimDuration(200);
                            text2.setText(BAR2);
                            text3.setText(BAR3);
                        }
                    }
                    else {
                        k = 0;
                        dot_1.startAnimation(mShakeAnimation);
                        dot_2.startAnimation(mShakeAnimation);
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

                    if (y >= 420 && y <= 533) {
                        if (x > 600) {
                            if (x <= 1296) {
                                dot_2.clearAnimation();
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



