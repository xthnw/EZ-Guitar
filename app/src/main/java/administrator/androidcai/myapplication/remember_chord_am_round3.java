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

public class remember_chord_am_round3 extends AppCompatActivity {

    LottieAnimationView sad;

    String chord = "CHORD Am";
    String taptostart = "Tap to start !";
    String whatisthis = "WHAT IS THIS ?";
    String ucandoit = "You can do it! Just easy";
    String empty =" ";
    String correct = "✓";
    String incorrect = "✘";
    Button hide_button2,hide_button3,hide_button,g_but,am_but,c_but,dm_but,em_but;
    TextView textcountdown;


    private static final long COUNTDOWN_IN_MILLIS = 10000;


    private ColorStateList textcolorCd;

    private CountDownTimer countDownTimer;
    private long timeleftInMillis;
    int i=0;

    public MediaPlayer yes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_chord_am_round3);



        yes = MediaPlayer.create(this,R.raw.correct);

        timeleftInMillis=COUNTDOWN_IN_MILLIS;
        startCountdown();






        i++;
        textcountdown = findViewById(R.id.textcountdown);


        textcolorCd = textcountdown.getTextColors();


        ConstraintLayout constraintLayout = findViewById(R.id.layoutxml1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        View overlay =  findViewById(R.id.layoutxml1);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        hide_button  =findViewById(R.id.hide_button);
        hide_button2 = findViewById(R.id.hide_button2);
        hide_button3 = findViewById(R.id.hide_button3);


        c_but = findViewById(R.id.button_c);
        am_but=findViewById(R.id.button_am);
        dm_but=findViewById(R.id.button_dm);



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
                am_but.setBackgroundResource(R.drawable.cercle_true);
                am_but.setText(correct);

                dm_but.setBackgroundResource(R.drawable.cercle_false);
                c_but.setBackgroundResource(R.drawable.cercle_false);

                c_but.setEnabled(false);
                dm_but.setEnabled(false);

                yes.start();

                opennext();


            }
        });

        dm_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm_but.setBackgroundResource(R.drawable.cercle_false);
                dm_but.setEnabled(false);


            }
        });













    }


    public void opennext(){
        Intent intent = new Intent(this, remember_chord_dm_round3.class);
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
