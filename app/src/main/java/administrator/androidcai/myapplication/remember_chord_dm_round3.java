package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class remember_chord_dm_round3 extends AppCompatActivity {

    LottieAnimationView sad;

    String chord = "CHORD Am";
    String taptostart = "Tap to start !";
    String whatisthis = "WHAT IS THIS ?";
    String ucandoit = "You can do it! Just easy";
    String empty =" ";
    String correct = "✓";
    String incorrect = "✘";
    String Dm = "Dm";
    Button hide_button2,hide_button3,hide_button4,g_but,am_but,c_but,dm_but,em_but;
    TextView textcountdown;
    int i=0;

    private static final long COUNTDOWN_IN_MILLIS = 11000;


    private ColorStateList textcolorCd;

    private CountDownTimer countDownTimer;
    private long timeleftInMillis;
    ImageView imageView;


    public MediaPlayer chord_dm,yes;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_chord_dm_round3);



        yes = MediaPlayer.create(remember_chord_dm_round3.this,R.raw.correct);

        chord_dm = MediaPlayer.create(remember_chord_dm_round3.this,R.raw.new_dm);


        textcountdown = findViewById(R.id.textcountdown);

        timeleftInMillis=COUNTDOWN_IN_MILLIS;
        startCountdown();


        textcolorCd = textcountdown.getTextColors();

        ConstraintLayout constraintLayout = findViewById(R.id.layoutxml1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        timeleftInMillis = COUNTDOWN_IN_MILLIS;
        startCountdown();
        i++;


        View overlay =  findViewById(R.id.layoutxml1);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);



        c_but = findViewById(R.id.button_c);
        am_but=findViewById(R.id.button_am);
        dm_but=findViewById(R.id.button_dm);




        final Button button = (Button) findViewById(R.id.hide_button);
        final TextView textView2 = (TextView) findViewById(R.id.txt_title);
        final TextView textView3 = (TextView) findViewById(R.id.txt_des);
        imageView = findViewById(R.id.imageView12);




        final Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        final Animation zoom_out = AnimationUtils.loadAnimation(this,R.anim.zoom_out);


        c_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c_but.setBackgroundResource(R.drawable.cercle_false);
                c_but.setEnabled(false);

            }
        });

        am_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am_but.setBackgroundResource(R.drawable.cercle_false);
                am_but.setEnabled(false);
            }
        });
        dm_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm_but.setBackgroundResource(R.drawable.cercle_true);
                dm_but.setText(correct);

                yes.start();

                c_but.setEnabled(false);
                am_but.setEnabled(false);
                c_but.setBackgroundResource(R.drawable.cercle_false);
                am_but.setBackgroundResource(R.drawable.cercle_false);
                opennext();



            }
        });
    }


    public void opennext(){

        Intent intent = new Intent(this, remember_chord_am_round4.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);

    }


    private void startCountdown(){
        countDownTimer = new CountDownTimer(timeleftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeleftInMillis=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    private void updateCountDownText(){
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



}
