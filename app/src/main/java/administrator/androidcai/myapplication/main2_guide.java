package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.airbnb.lottie.LottieAnimationView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.varunest.sparkbutton.SparkButton;

import java.lang.reflect.Type;
import java.util.Timer;
import java.util.TimerTask;

public class main2_guide extends AppCompatActivity {
    TextView choose_lesson,tap;
    Animation uptodown,downtoup,lefttoright;
    private Button button;
    Dialog myDialog;
    private ImageView back,learn_focus,learn_focus2,exer_focus,back_focus,black_back_focus,exer_focus2;
    static MediaPlayer t,touch;


    TextView skip;

    FrameLayout f1,f2,f3,f4;

    private FrameLayout exer2,exer3;

    VideoView videoView;
    int time=0;
    Timer timer;

    VideoView videoView6,videoView7;

    private Animation  mShakeAnimation;


    SparkButton button_exer,button_learn,button_exer_focus;

    LottieAnimationView lottieAnimationView1,lot_exer,lot_back;

    private FloatingActionButton fablearn,fabexer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_guide);




        t = MediaPlayer.create(this,R.raw.closesound);
        touch = MediaPlayer.create(this,R.raw.touch);


        skip = findViewById(R.id.SKIP);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openMainActivity();
            }
        });


        mShakeAnimation = AnimationUtils.loadAnimation(main2_guide.this,R.anim.shake);






        exer_focus2 = findViewById(R.id.exer_focus2);








        f1=findViewById(R.id.learnframe1);
        f2=findViewById(R.id.learnframe2);
        f3=findViewById(R.id.learnframe3);
        f4=findViewById(R.id.learnframe4);


       exer2 = findViewById(R.id.exerframe2);
       exer3 = findViewById(R.id.exerframe3);




        timer = new Timer();


        tap = findViewById(R.id.tap);



        final VideoView videoView = (VideoView)findViewById(R.id.vdo_learn1);
        String viepPath = "android.resource://" + getPackageName() + "/" + R.raw.lfirst;
        Uri uri = Uri.parse(viepPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();


        final VideoView videoView2 = (VideoView)findViewById(R.id.vdo_learn2);
        String viepPath2 = "android.resource://" + getPackageName() + "/" + R.raw.lsecond;
        Uri uri2 = Uri.parse(viepPath2);
        videoView2.setVideoURI(uri2);
        videoView2.requestFocus();
        videoView2.start();

        final VideoView videoView3 = (VideoView)findViewById(R.id.vdo_learn3);
        String viepPath3 = "android.resource://" + getPackageName() + "/" + R.raw.lthird;
        Uri uri3 = Uri.parse(viepPath3);
        videoView3.setVideoURI(uri3);
        videoView3.requestFocus();
        videoView3.start();

        final VideoView videoView4 = (VideoView)findViewById(R.id.vdo_learn4);
        String viepPath4 = "android.resource://" + getPackageName() + "/" + R.raw.wriiterrr;
        Uri uri4 = Uri.parse(viepPath4);
        videoView4.setVideoURI(uri4);
        videoView4.requestFocus();
        videoView4.start();


        // EXER VIDEO //







        videoView6 = findViewById(R.id.vdo_exer2);
        String videoPath6 = "android.resource://" + getPackageName() + "/" + R.raw.exerfirst;
        Uri uri6 = Uri.parse(videoPath6);
        videoView6.setVideoURI(uri6);
        videoView6.requestFocus();

        videoView7 = findViewById(R.id.vdo_exer3);
        String videoPath7 = "android.resource://" + getPackageName() + "/" + R.raw.exersecond;
        Uri uri7 = Uri.parse(videoPath7);
        videoView7.setVideoURI(uri7);
        videoView7.requestFocus();




        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        tap.startAnimation(startAnimation);


        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoView2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoView3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoView4.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        videoView6.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoView7.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });





        learn_focus=findViewById(R.id.learn_focus);
        learn_focus2=findViewById(R.id.learn_focus2);
        exer_focus=findViewById(R.id.exer_focus);
        lottieAnimationView1=findViewById(R.id.lot_learn);
        button_exer_focus=findViewById(R.id.button_exer_focus);
        lot_exer=findViewById(R.id.lot_exer);
        back_focus=findViewById(R.id.back_focus);
        lot_back=findViewById(R.id.lot_back);
        black_back_focus=findViewById(R.id.black_back_focus);


        lottieAnimationView1.setAnimation(uptodown);


        button_exer = findViewById(R.id.button_exer);
        button_exer.setAnimation(uptodown);



        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                learn_focus.setAlpha((float) 0.95);
                tap.setAlpha((float) 1.0);
                lottieAnimationView1.setAlpha((float) 1.0);
                button_learn.startAnimation(mShakeAnimation);
            }
        },3000);










        learn_focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                f1.startAnimation(lefttoright);
                f2.startAnimation(lefttoright);
                f3.startAnimation(uptodown);
                f4.startAnimation(uptodown);

                f1.setAlpha(1);
                f2.setAlpha(1);
                f3.setAlpha(1);
                f4.setAlpha(1);


                learn_focus2.setVisibility(View.VISIBLE);
                touch.start();





            }
        });

        learn_focus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learn_focus2.setVisibility(View.INVISIBLE);
                learn_focus.setVisibility(View.INVISIBLE);
                lottieAnimationView1.setVisibility(View.INVISIBLE);
                exer_focus.setVisibility(View.VISIBLE);
                button_exer.setVisibility(View.INVISIBLE);
                button_exer_focus.setAnimation(uptodown);
                button_exer_focus.setVisibility(View.VISIBLE);
                button_exer_focus.startAnimation(uptodown);
                lot_exer.setVisibility(View.VISIBLE);
                lot_exer.startAnimation(lefttoright);
                touch.start();
                f1.setVisibility(View.INVISIBLE);
                f2.setVisibility(View.INVISIBLE);
                f3.setVisibility(View.INVISIBLE);
                f4.setVisibility(View.INVISIBLE);
                videoView.stopPlayback();
                videoView2.stopPlayback();
                videoView3.stopPlayback();
                videoView4.stopPlayback();
                videoView.pause();
                videoView2.pause();
                videoView3.pause();
                videoView4.pause();
                touch.start();
                button_learn.clearAnimation();
                button_exer_focus.startAnimation(mShakeAnimation);








            }
        });


        exer_focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exer_focus.setVisibility(View.INVISIBLE);
                exer_focus2.setVisibility(View.VISIBLE);


                exer2.startAnimation(lefttoright);
                exer3.startAnimation(lefttoright);
                exer2.setAlpha(1);
                exer3.setAlpha(1);
                videoView6.start();
                videoView7.start();
                touch.start();


            }
        });

        exer_focus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exer_focus2.setVisibility(View.INVISIBLE);
                lot_exer.setVisibility(View.INVISIBLE);
                back_focus.setVisibility(View.VISIBLE);
                lot_back.setVisibility(View.VISIBLE);
                back_focus.setVisibility(View.VISIBLE);
                black_back_focus.setVisibility(View.VISIBLE);
                back_focus.startAnimation(uptodown);
                lot_back.startAnimation(downtoup);
                touch.start();

                button_exer_focus.clearAnimation();

            }
        });









        hideNavigationBar();




        View overlay =  findViewById(R.id.mylayout);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);





        button_learn = findViewById(R.id.button_learn);
        choose_lesson =  findViewById(R.id.choose_chord_set);





        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);


        button_learn.setAnimation(downtoup);
        choose_lesson.setAnimation(lefttoright);
        button_exer.setAnimation(uptodown);

        back = findViewById(R.id.imageView3);
        back.setAnimation(uptodown);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openMainActivity();
            }
        });




        myDialog = new Dialog(this);



        Typeface tf = Typeface.createFromAsset(getAssets(),"PierSans-Bold.otf");

        TextView font = (TextView) findViewById(R.id.choose_chord_set);
        font.setTypeface(tf);




        button_exer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openMain6Activity();
            }
        });



        button_exer.setEnabled(false);


    }


    public void openMain6Activity(){
        Intent intent = new Intent(this, Main6Activity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        finish();
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        finish();
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

    public void ShowPopup(View v){

        Typeface tf = Typeface.createFromAsset(getAssets(),"PierSans-Bold.otf");
        Typeface ttf = Typeface.createFromAsset(getAssets(),"Cloud.otf");
        TextView txtclose;
        TextView txt_note;
        TextView txt_chord;
        TextView txt_table_chord;
        TextView txt_lets_go_to_learn_guitar;
        TextView txt_please_choose_a_lesson;
        myDialog.setContentView(R.layout.popup_learn);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txt_note = (TextView) myDialog.findViewById(R.id.txt_note);
        txt_chord = (TextView) myDialog.findViewById(R.id.txt_chord);
        txt_table_chord = (TextView) myDialog.findViewById(R.id.txt_chart);
        txt_lets_go_to_learn_guitar = (TextView) myDialog.findViewById(R.id.txt_lets_go_to_learn_guitar);
        txt_please_choose_a_lesson = (TextView) myDialog.findViewById(R.id.txt_please_choose_a_lesson);

        txt_table_chord.setTypeface(ttf);
        txt_lets_go_to_learn_guitar.setTypeface(tf);
        txtclose.setTypeface(ttf);
        txt_chord.setTypeface(ttf   );
        txt_note.setTypeface(ttf);


        txt_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openMain4();
            }
        });
        txt_chord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openMain5();
            }
        });
        txt_table_chord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openblockchord();
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.getWindow(). setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

        myDialog.show();



    }

    private void openblockchord() {
        Intent intent = new Intent(this,table_allchordcancheck.class);
        startActivity(intent);
        Animatoo.animateShrink(this);
        finish();

    }

    public void openMain4(){
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
        Animatoo.animateShrink(this);
        finish();
    }

    public void openMain5(){
        Intent intent = new Intent(this,Main5Activity.class);
        startActivity(intent);
        Animatoo.animateShrink(this);
        finish();
    }

    public void bounce(View view) {


        Button button = (Button) findViewById(R.id.button_exer);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        button.startAnimation(animation);

    }
}
