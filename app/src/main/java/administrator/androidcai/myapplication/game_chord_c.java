package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.icu.text.UnicodeSet;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.os.VibrationEffect;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.kofigyan.stateprogressbar.StateProgressBar;
import com.library.NavigationBar;

import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;
import me.itangqi.waveloadingview.WaveLoadingView;

public class game_chord_c extends AppCompatActivity {

    private TextView text1,text2,text3,howto,name_chord,try_again;
    public MediaPlayer correct;
    public ImageView dot_1,dot_2,dot_3;
    private ConstraintLayout constraintLayout;
    private Button next;
    String udata ="จับคอร์ด C อย่างไร <<";
    String string_try_again = ">>ลองจับคอร์ดอีกครั้ง<<";
    String one ="1";
    String two ="2";
    String three ="3";
    Animation uptodown,downtoup,lefttoright;
    TextView textView;
    Animation left_slide;

    int z=0;


    Random r;
    int random,min=1,max=7;





    StateProgressBar stateProgressBar;

    Button button2;

    String[] des = {" "," "," ","FINISH"};

    WaveLoadingView waveLoadingView;
    SeekBar seekBar;
    String chord_c = "C";
    Switch loop;
    int forloop = 0;


    CheckBox checkBox,checkBox2,checkBox3,checkBox4;
    ImageView chord,hand;
    TextView t1,t2,t3;
    String enable="HINT : Enable";
    String disable="HINT : Disable";

    AlphaAnimation alphaAnimation;



    int time;
    int currentpoint=0;
    int to_c,to_am,to_dm,to_g,to_em,to_d;
    int ac_c=100,ac_am=200,ac_dm=300,ac_g=400,ac_em=500,ac_d=600;


    public static final String EXTRA_INT = "com.example.application.example.EXTRA_INT";


    private static final long COUNTDOWN_IN_MILLIS = 11000;


    private ColorStateList textcolorCd;
    TextView textcountdown;
    private CountDownTimer countDownTimer;
    private long timeleftInMillis;


    static MediaPlayer t,touch;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_chord_c);





        textcountdown = findViewById(R.id.textcountdown);
        textcolorCd = textcountdown.getTextColors();
        timeleftInMillis = COUNTDOWN_IN_MILLIS;
        startCountdown();







        Intent intent = getIntent();
        int getpoint = intent.getIntExtra(game_chord_c.EXTRA_INT,0);

        currentpoint = getpoint;



        final TextView point = (TextView)findViewById(R.id.point);
        point.setText(Integer.toString(currentpoint));
        point.setText("Point : "+currentpoint);










        checkBox=findViewById(R.id.checkBox);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        chord = findViewById(R.id.imageView7);
        t1 = findViewById(R.id.textView9);
        t2 = findViewById(R.id.textView8);
        t3 = findViewById(R.id.hint);
        hand =  findViewById(R.id.imageView8);



        if (currentpoint <=0){
            checkBox2.setEnabled(false); //checker 20
            checkBox3.setEnabled(false); //hand 10
            checkBox4.setEnabled(false); //table30
            checkBox.setEnabled(false); //position50
        }


        else if (currentpoint<=10){
            checkBox2.setEnabled(false); //checker 20
            checkBox3.setEnabled(true); //hand 10
            checkBox4.setEnabled(false); //30
            checkBox.setEnabled(false); //50
        }
        else if(currentpoint<=15){
            checkBox2.setEnabled(false); //checker 20
            checkBox3.setEnabled(true); //hand 10
            checkBox4.setEnabled(false); //30
            checkBox.setEnabled(false); //50
        }

       else  if (currentpoint<=20){
            checkBox2.setEnabled(true); //hand 20
            checkBox3.setEnabled(true); //hand 10
            checkBox4.setEnabled(false); //30
            checkBox.setEnabled(false); //50
        }

       else if(currentpoint<=25){
            checkBox2.setEnabled(true);
            checkBox3.setEnabled(true);
            checkBox4.setEnabled(false);
            checkBox.setEnabled(false);
        }

      else if (currentpoint<=30){
            checkBox2.setEnabled(true);
            checkBox3.setEnabled(true);
            checkBox4.setEnabled(true);
            checkBox.setEnabled(false);
        }

        else if (currentpoint>=50){
            checkBox.setEnabled(true);
            checkBox2.setEnabled(true);
            checkBox3.setEnabled(true);
            checkBox4.setEnabled(true);
        }




        r = new Random();

        random = r.nextInt(max-min);





        loop = findViewById(R.id.loop);

        loop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){


                    t3.setText("Hint Master : \nEnable");

                    checkBox.setChecked(true);
                    checkBox2.setChecked(true);
                    checkBox3.setChecked(true);
                    checkBox4.setChecked(true);
                    text1.setAlpha(0f);
                    text1.setVisibility(View.VISIBLE);
                    text1.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);

                    text2.setAlpha(0f);
                    text2.setVisibility(View.VISIBLE);
                    text2.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);

                    text3.setAlpha(0f);
                    text3.setVisibility(View.VISIBLE);
                    text3.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);


                    dot_1.setAlpha(0f);
                    dot_1.setVisibility(View.VISIBLE);
                    dot_1.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);

                    dot_2.setAlpha(0f);
                    dot_2.setVisibility(View.VISIBLE);
                    dot_2.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);

                    dot_3.setAlpha(0f);
                    dot_3.setVisibility(View.VISIBLE);
                    dot_3.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);

                    stateProgressBar.setAlpha(0f);
                    stateProgressBar.setVisibility(View.VISIBLE);
                    stateProgressBar.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);

                    chord.setAlpha(0f);
                    chord.setVisibility(View.VISIBLE);
                    chord.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);


                    t1.setAlpha(0f);
                    t1.setVisibility(View.VISIBLE);
                    t1.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);
                    hand.setAlpha(0f);
                    hand.setVisibility(View.VISIBLE);
                    hand.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);
                }
                else {



                    t3.setText("Hint Master : Disable");
                    checkBox.setChecked(false);
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                    checkBox4.setChecked(false);

                    hand.setAlpha(0f);
                    hand.setVisibility(View.GONE);
                    hand.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);

                    chord.setAlpha(0.5f);
                    chord.setVisibility(View.GONE);
                    chord.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);


                    t1.setAlpha(0.5f);
                    t1.setVisibility(View.GONE);
                    t1.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);

                    stateProgressBar.setAlpha(0.5f);
                    stateProgressBar.setVisibility(View.GONE);
                    stateProgressBar.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);

                    text1.setAlpha(0.5f);
                    text1.setVisibility(View.GONE);
                    text1.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);

                    text2.setAlpha(0.5f);
                    text2.setVisibility(View.GONE);
                    text2.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);


                    text3.setAlpha(0.5f);
                    text3.setVisibility(View.GONE);
                    text3.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);



                    dot_1.setAlpha(0.5f);
                    dot_1.setVisibility(View.GONE);
                    dot_1.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);
                    dot_2.setAlpha(0.5f);
                    dot_2.setVisibility(View.GONE);
                    dot_2.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);
                    dot_3.setAlpha(0.5f);
                    dot_3.setVisibility(View.GONE);
                    dot_3.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);




                }
            }
        });




        waveLoadingView = findViewById(R.id.wave123);
        waveLoadingView.setProgressValue(5);
        waveLoadingView.setCenterTitle(chord_c);
        waveLoadingView.setCenterTitleSize(45);
        waveLoadingView.setCenterTitleStrokeColor(10);



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





        howto = findViewById(R.id.textView9);
        name_chord = findViewById(R.id.textView8);
        try_again = findViewById(R.id.try_again);

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



        text1.setTypeface(tf);
        text2.setTypeface(tf);
        text3.setTypeface(tf);
        try_again.setTypeface(tf);
        try_again.setVisibility(View.INVISIBLE);
        try_again.setEnabled(false);
        howto.setTypeface(tf);
        name_chord.setTypeface(tf);
        dot_1 = findViewById(R.id.dot_1);
        dot_2 = findViewById(R.id.dot_2);
        dot_3 = findViewById(R.id.dot_3);

        howto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SweetAlertDialog dialog = new SweetAlertDialog(game_chord_c.this,SweetAlertDialog.WARNING_TYPE);
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

        correct = MediaPlayer.create(game_chord_c.this,R.raw.chord_c);


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



        next = findViewById(R.id.button_note);
        next.setTypeface(tf);
        next.setVisibility(View.INVISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(forloop == 1){
                    openTable_CActivity();}
                else openTable_CActivitywithzero();
            }
        });


        ImageView back =  (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();


                openMain2();
            }
        });








        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox3.isChecked()){
                    currentpoint = currentpoint - 10;
                    point.setText(Integer.toString(currentpoint));
                    point.setText("Point : "+currentpoint);
                    if (currentpoint <=0){
                        checkBox2.setEnabled(false); //hand 20
                        checkBox3.setEnabled(false); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }


                    else if (currentpoint<=10){
                        checkBox2.setEnabled(false); //hand 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }

                    else if(currentpoint<=15){
                        checkBox2.setEnabled(false); //checker 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }

                    else  if (currentpoint<=20){
                        checkBox2.setEnabled(true); //hand 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }
                    else if(currentpoint<=25){
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(false);
                        checkBox.setEnabled(false);
                    }

                    else if (currentpoint<=30){
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(true);
                        checkBox.setEnabled(false);
                    }

                    else if (currentpoint>=50){
                        checkBox.setEnabled(true);
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(true);
                    }

                    hand.setAlpha(0f);
                    hand.setVisibility(View.VISIBLE);
                    hand.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);
                }
                else
                {
                    hand.setAlpha(0f);
                    hand.setVisibility(View.GONE);
                    hand.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);

                }
            }
        });




        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox4.isChecked()){
                    currentpoint = currentpoint - 30;
                    point.setText(Integer.toString(currentpoint));
                    point.setText("Point : "+currentpoint);


                    if (currentpoint <=0){
                        checkBox2.setEnabled(false); //hand 20
                        checkBox3.setEnabled(false); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }


                    else if (currentpoint<=10){
                        checkBox2.setEnabled(false); //hand 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }
                    else if(currentpoint<=15){
                        checkBox2.setEnabled(false); //checker 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }


                    else  if (currentpoint<=20){
                        checkBox2.setEnabled(true); //hand 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }
                    else if(currentpoint<=25){
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(false);
                        checkBox.setEnabled(false);
                    }


                    else if (currentpoint<=30){
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(true);
                        checkBox.setEnabled(false);
                    }

                    else if (currentpoint>=50){
                        checkBox.setEnabled(true);
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(true);
                    }
                    chord.setAlpha(0f);
                    chord.setVisibility(View.VISIBLE);
                    chord.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);


                    t1.setAlpha(0f);
                    t1.setVisibility(View.VISIBLE);
                    t1.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);







                }
                else
                {
                    chord.setAlpha(0.5f);
                    chord.setVisibility(View.GONE);
                    chord.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);


                    t1.setAlpha(0.5f);
                    t1.setVisibility(View.GONE);
                    t1.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);
                }

            }
        });


        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2.isChecked()){

                    currentpoint = currentpoint-20;
                    point.setText(Integer.toString(currentpoint));
                    point.setText("Point : "+currentpoint);


                    if (currentpoint <=0){
                        checkBox2.setEnabled(false); //hand 20
                        checkBox3.setEnabled(false); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }


                    else if (currentpoint<=10){
                        checkBox2.setEnabled(false); //hand 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }
                    else if(currentpoint<=15){
                        checkBox2.setEnabled(false); //checker 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }


                    else  if (currentpoint<=20){
                        checkBox2.setEnabled(true); //hand 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }
                    else if(currentpoint<=25){
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(false);
                        checkBox.setEnabled(false);
                    }

                    else if (currentpoint<=30){
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(true);
                        checkBox.setEnabled(false);
                    }

                    else if (currentpoint>=50){
                        checkBox.setEnabled(true);
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(true);
                    }
                    stateProgressBar.setAlpha(0f);
                    stateProgressBar.setVisibility(View.VISIBLE);
                    stateProgressBar.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);
                }
                else {
                    stateProgressBar.setAlpha(0.5f);
                stateProgressBar.setVisibility(View.GONE);
                stateProgressBar.animate()
                        .alpha(0f)
                        .setDuration(400)
                        .setListener(null);
                }
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                if(checkBox.isChecked()){
                    currentpoint = currentpoint - 50;
                    point.setText(Integer.toString(currentpoint));
                    point.setText("Point : "+currentpoint);

                    if (currentpoint <=0){
                        checkBox2.setEnabled(false); //hand 20
                        checkBox3.setEnabled(false); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }


                    else if (currentpoint<=10){
                        checkBox2.setEnabled(false); //hand 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }
                    else if(currentpoint<=15){
                        checkBox2.setEnabled(false); //checker 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }


                    else  if (currentpoint<=20){
                        checkBox2.setEnabled(true); //hand 20
                        checkBox3.setEnabled(true); //hand 10
                        checkBox4.setEnabled(false); //30
                        checkBox.setEnabled(false); //50
                    }

                    else if(currentpoint<=25){
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(false);
                        checkBox.setEnabled(false);
                    }

                    else if (currentpoint<=30){
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(true);
                        checkBox.setEnabled(false);
                    }

                    else if (currentpoint>=50){
                        checkBox.setEnabled(true);
                        checkBox2.setEnabled(true);
                        checkBox3.setEnabled(true);
                        checkBox4.setEnabled(true);
                    }
                    text1.setAlpha(0f);
                    text1.setVisibility(View.VISIBLE);
                    text1.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);

                    text2.setAlpha(0f);
                    text2.setVisibility(View.VISIBLE);
                    text2.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);

                    text3.setAlpha(0f);
                    text3.setVisibility(View.VISIBLE);
                    text3.animate()
                            .alpha(1f)
                            .setDuration(400)
                            .setListener(null);


                    dot_1.setAlpha(0f);
                    dot_1.setVisibility(View.VISIBLE);
                    dot_1.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);

                    dot_2.setAlpha(0f);
                    dot_2.setVisibility(View.VISIBLE);
                    dot_2.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);

                    dot_3.setAlpha(0f);
                    dot_3.setVisibility(View.VISIBLE);
                    dot_3.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);







                }
                else
                {
                    text1.setAlpha(0.5f);
                    text1.setVisibility(View.GONE);
                    text1.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);

                    text2.setAlpha(0.5f);
                    text2.setVisibility(View.GONE);
                    text2.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);


                    text3.setAlpha(0.5f);
                    text3.setVisibility(View.GONE);
                    text3.animate()
                            .alpha(0.5f)
                            .setDuration(400)
                            .setListener(null);



                    dot_1.setAlpha(0.5f);
                    dot_1.setVisibility(View.GONE);
                    dot_1.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);
                    dot_2.setAlpha(0.5f);
                    dot_2.setVisibility(View.GONE);
                    dot_2.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);
                    dot_3.setAlpha(0.5f);
                    dot_3.setVisibility(View.GONE);
                    dot_3.animate()
                            .alpha(0f)
                            .setDuration(400)
                            .setListener(null);




                }
            }
        });


    }

    private void startCountdown() {

        countDownTimer = new CountDownTimer(timeleftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftInMillis=millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                SweetAlertDialog dialog = new SweetAlertDialog(game_chord_c.this,SweetAlertDialog.ERROR_TYPE);
                dialog.getWindow(). setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                dialog.setTitleText("TIME's UP :(");
                dialog.setContentText("You must to be more skill!\nคุณต้องทักษะที่มากกว่านี้");
                dialog.setConfirmText("OK");
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        openest();
                    }
                }).show();
                dialog.setCustomImage(R.drawable.playguitar);
            }
        }.start();
    }

    private void openest() {
        Intent intent = new Intent(this, boardcast_learn.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
    }


    private void updateCountDownText() {
        int minute = (int) (timeleftInMillis /1000)/60;
        int second = (int) (timeleftInMillis /1000)%60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",minute,second);
        textcountdown.setText(timeFormatted);
        if(timeleftInMillis<=5000){
            textcountdown.setTextColor(Color.RED);
        }
        else
            textcountdown.setTextColor(textcolorCd);
        }

    private void openTable_CActivitywithzero() {
        Intent intent2 = new Intent(this, Table_Am.class);
        int for_loop2 = 0;
        intent2.putExtra(String.valueOf(for_loop2), 0);
        startActivity(intent2);
        Animatoo.animateSlideUp(this);
        finish();
    }


    public void openMain2(){
        Intent intent = new Intent(this,Main6Activity.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    public void openTable_CActivity(){
        Intent intent = new Intent(this, Table_Am.class);
        int for_loop = 1;
        intent.putExtra(String.valueOf(for_loop), 1);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
        finish();
    }

    public void shownumber(){
        text1.setText(one);
        text2.setText(two);
        text3.setText(three);
        try_again.setVisibility(View.INVISIBLE);
        next.setVisibility(View.INVISIBLE);
        stateProgressBar.setAllStatesCompleted(false);
        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
        z=0;
        waveLoadingView.setProgressValue(5);
    }




    void handleTouch(MotionEvent  m) {

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        final long[] pattern = {2000, 1000};
        text1 = (TextView) findViewById(R.id.textView5);
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
                    if (y >= 210 && y <= 283) {
                        if (x <= 716) {
                            text1.setText(touchStatus);
                            dot_1.clearColorFilter();
                            k = 1;
                            stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                            waveLoadingView.setProgressValue(33);
                            waveLoadingView.setAnimDuration(500);

                        } else
                            k = 0;
                    }
                    else {
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
                    if (y >= 420 && y <= 518) {
                        if (x > 750) {
                            if (x <= 1290) {
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
                            } else
                                k = 0;

                        }

                    } else {
                        k = 0;
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        text2.setText(BAR2);
                    }

                }
            }


            if (k == 2) {
                if (id == 2) {
                    if (y >= 524 && y <= 622) {
                        if (x > 1326) {
                            if (x <= 1854) {
                                if(timeleftInMillis<=2000){
                                    currentpoint = currentpoint + 5;
                                }
                                else if(timeleftInMillis<=4000){
                                    currentpoint = currentpoint + 10;
                                }
                                else if(timeleftInMillis<=6000){
                                    currentpoint = currentpoint + 15;
                                }
                                else if(timeleftInMillis<=8000){
                                    currentpoint = currentpoint + 20;
                                }
                                else if(timeleftInMillis<=10000){
                                    currentpoint = currentpoint + 25;
                                }
                                text3.setText(touchStatus);
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
                opennext();
                next.setVisibility(View.VISIBLE);
                try_again.setVisibility(View.VISIBLE);
                try_again.setEnabled(true);
                next.startAnimation(left_slide);
                break breakLoop;

            }

        }



    }

    private void opennext() {

        if(random==0) {
            Intent intent = new Intent(game_chord_c.this, game_chord_am.class);
            intent.putExtra(EXTRA_INT,currentpoint);
            startActivity(intent);
        }if(random==1) {
            Intent intent = new Intent(game_chord_c.this, game_chord_dm.class);
            intent.putExtra(EXTRA_INT,currentpoint);

            startActivity(intent);

        }if(random==2) {
            Intent intent = new Intent(game_chord_c.this, game_chord_g.class);
            intent.putExtra(EXTRA_INT,currentpoint);


            startActivity(intent);

        }if(random==3) {
            Intent intent = new Intent(game_chord_c.this, game_chord_em.class);
            intent.putExtra(EXTRA_INT,currentpoint);

            startActivity(intent);

        }if(random==4) {
            Intent intent = new Intent(game_chord_c.this, game_chord_c.class);
            intent.putExtra(EXTRA_INT,currentpoint);


            startActivity(intent);

        }
        if(random==5){
            Intent intent = new Intent(game_chord_c.this, game_chord_d.class);
            intent.putExtra(EXTRA_INT,currentpoint);
            startActivity(intent);

        }

    }
}

