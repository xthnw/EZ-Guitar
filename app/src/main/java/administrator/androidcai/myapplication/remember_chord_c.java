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
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import org.w3c.dom.Text;

import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class remember_chord_c extends AppCompatActivity {

    static MediaPlayer c,pop;

    LottieAnimationView sad;

    String chord = "Am";
    String taptostart = "Tap to start !";
    String whatisthis = "WHAT IS THIS ?";
    String ucandoit = "You can do it! Just easy";
    String empty =" ";
    String correct = "✓";
    String incorrect = "✘";
    Button hide_button2,hide_button3,hide_button4,g_but,am_but,c_but,dm_but,em_but;
    TextView textcountdown;

    int ran=3;
    Timer timer;

    private static final long COUNTDOWN_IN_MILLIS = 10000;


    private ColorStateList textcolorCd;

    private CountDownTimer countDownTimer;
    private long timeleftInMillis;
    int i=0;

    public MediaPlayer chord_c,chord_am,s_cor,wrong;

    public TextView textView,textView2,textView3;

    public ImageView imageView;

    Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_chord_c);


        c = MediaPlayer.create(this,R.raw.touch);
        pop = MediaPlayer.create(this,R.raw.pop);



timer= new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                chord_c.start();
            }
        },600);



        wrong = MediaPlayer.create(this,R.raw.wrong);

        chord_c = MediaPlayer.create(remember_chord_c.this,R.raw.chord_c);
        chord_am = MediaPlayer.create(remember_chord_c.this,R.raw.chord_am);
        s_cor = MediaPlayer.create(remember_chord_c.this,R.raw.correct);





        i++;
        textcountdown = findViewById(R.id.textcountdown);


        textcolorCd = textcountdown.getTextColors();


        sad = findViewById(R.id.animation_view);

        Typeface tf = Typeface.createFromAsset(getAssets(),"PierSans-Bold.otf");


        ConstraintLayout constraintLayout = findViewById(R.id.layoutxml1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        View overlay =  findViewById(R.id.layoutxml1);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        hide_button2 = findViewById(R.id.hide_button2);
        hide_button3 = findViewById(R.id.hide_button3);


        c_but = findViewById(R.id.button_c);
        am_but=findViewById(R.id.button_am);






        final Button button = (Button) findViewById(R.id.hide_button);
        textView = findViewById(R.id.tap);
        textView2 = findViewById(R.id.txt_title);
        textView3 = findViewById(R.id.txt_des);

        imageView = findViewById(R.id.imageView12);
        final int ui_flags =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;




        final Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        final Animation zoom_out = AnimationUtils.loadAnimation(this,R.anim.zoom_out);

        textView.startAnimation(startAnimation);

        c_but.setVisibility(View.INVISIBLE);
        am_but.setVisibility(View.INVISIBLE);
        textcountdown.setVisibility(View.INVISIBLE);
        hide_button2.setVisibility(View.INVISIBLE);
        hide_button3.setVisibility(View.INVISIBLE);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                textView2.setText(chord);
                imageView.setImageResource(R.drawable.new_am);
                textView.setText(taptostart);
                button.setVisibility(View.INVISIBLE);
                hide_button2.setVisibility(View.VISIBLE);
                textView.setTextColor(Color.parseColor("#00ff00"));

                chord_am.start();


            }

        });

        hide_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                chord_c.stop();
                chord_am.stop();



                final SweetAlertDialog dialog = new SweetAlertDialog(remember_chord_c.this,SweetAlertDialog.WARNING_TYPE);

                dialog.setTitleText("Are you Ready?");
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
                dialog.getWindow().getDecorView().setSystemUiVisibility(ui_flags);
                pop.start();
                dialog.setConfirmText("YES");
                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        pop.start();
                        textView.setText(empty);
                        textView2.setText(whatisthis);
                        textView3.setText(ucandoit);
                        imageView.setImageResource(R.drawable.a_c);
                        c_but.setVisibility(View.VISIBLE);
                        am_but.setVisibility(View.VISIBLE);
                        hide_button2.setVisibility(View.INVISIBLE);
                        timeleftInMillis = COUNTDOWN_IN_MILLIS;
                        textcountdown.setVisibility(View.VISIBLE);
                        startCountdown();
                        hideNavigationBar();
                        dialog.dismiss();
                    }
                }).show();
                hideNavigationBar();
            }
        });

        c_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.start();
                random = new Random();
                // TODO Auto-generated method stub
                ran = random.nextInt(2-1)+1;
                Toast.makeText(remember_chord_c.this,"Nuber"+random,Toast.LENGTH_SHORT);


                c_but.setBackgroundResource(R.drawable.cercle_true);
                c_but.setText(correct);
                s_cor.start();
                am_but.setEnabled(false);
                opennext();


            }
        });

        am_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.start();
                am_but.setBackgroundResource(R.drawable.cercle_false);
                am_but.setText(incorrect);
                am_but.setEnabled(false);
                wrong.start();

            }
        });
    }


    public void hideNavigationBar(){
        this.getWindow().getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                );
    }

    public void opennext(){

        Intent am = new Intent(remember_chord_c.this, remember_chord_am.class);
        Intent cr2 = new Intent(remember_chord_c.this,remember_chord_c_round2.class);



        
        if(ran==1)
        {
            startActivity(am);
            Animatoo.animateSlideUp(this);
        }

        if(ran==2)
        {
            startActivity(cr2);
            Animatoo.animateSlideUp(this);
        }
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
