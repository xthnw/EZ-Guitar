package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.varunest.sparkbutton.SparkButton;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
    TextView choose_lesson;
    Animation uptodown,downtoup,lefttoright;
    private Button button;
    Dialog myDialog;
    private ImageView back;
    static MediaPlayer t,touch;

    Timer timer;

    private Animation  mShakeAnimation;


    SparkButton button_exer,button_learn;

    private FloatingActionButton fablearn,fabexer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        mShakeAnimation = AnimationUtils.loadAnimation(Main2Activity.this,R.anim.shake);



        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                button_learn.startAnimation(mShakeAnimation);
                button_exer.startAnimation(mShakeAnimation);
            }
        },1500);









        t = MediaPlayer.create(this,R.raw.closesound);
        touch = MediaPlayer.create(this,R.raw.touch);









        hideNavigationBar();




        View overlay =  findViewById(R.id.mylayout);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);




        button_exer = findViewById(R.id.button_exer);
        button_learn = findViewById(R.id.button_learn);
        choose_lesson =  findViewById(R.id.choose_chord_set);









        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);

        button_exer.setAnimation(uptodown);
        button_learn.setAnimation(downtoup);
        choose_lesson.setAnimation(lefttoright);

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
                button_exer.clearAnimation();
            }
        });

        button_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                button_learn.clearAnimation();
                ShowPopup(v);
            }
        });




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

        txt_lets_go_to_learn_guitar.setTypeface(tf);


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

    }

    public void openMain4(){
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
        Animatoo.animateShrink(this);
    }

    public void openMain5(){
        Intent intent = new Intent(this,Main5Activity.class);
        startActivity(intent);
        Animatoo.animateShrink(this);
    }

    public void bounce(View view) {


        Button button = (Button) findViewById(R.id.button_exer);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        button.startAnimation(animation);

    }
}
