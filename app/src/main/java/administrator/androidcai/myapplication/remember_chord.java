package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;


public class remember_chord extends AppCompatActivity {



    public MediaPlayer sound_c,s_cor;
    static MediaPlayer click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_chord);
        click = MediaPlayer.create(this,R.raw.touch);



        sound_c = MediaPlayer.create(remember_chord.this,R.raw.chord_c);
        s_cor = MediaPlayer.create(remember_chord.this,R.raw.correct);



        ConstraintLayout constraintLayout = findViewById(R.id.layoutxml1);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();






        View overlay =  findViewById(R.id.layoutxml1);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);



        Button button = (Button) findViewById(R.id.hide_button);
        TextView textView = (TextView) findViewById(R.id.tap);

        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        textView.startAnimation(startAnimation);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                click.start();
                openRemember();

            }

        });






    }
    public void openRemember(){
        Intent intent = new Intent(this, remember_chord_c.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
    }




}
