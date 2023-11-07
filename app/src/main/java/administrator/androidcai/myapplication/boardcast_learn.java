package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class boardcast_learn extends AppCompatActivity {





    LinearLayout laypack1,laypack2,laypack3,laypack4,laypack5,laypack6,laypack7,laypack8,laypack9,laypack10;

    Animation a1;
    ImageView backimage;


    static MediaPlayer t,touch;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardcast_learn);


        touch = MediaPlayer.create(this,R.raw.touch);



        backimage = findViewById(R.id.backimage);


        a1 = AnimationUtils.loadAnimation(this,R.anim.bounce);






        laypack1 = findViewById(R.id.lay_pack1);
        laypack2 = findViewById(R.id.lay_pack2);
        laypack3 = findViewById(R.id.lay_pack3);
        laypack4 = findViewById(R.id.lay_pack4);
        laypack5 = findViewById(R.id.lay_pack5);
        laypack6 = findViewById(R.id.lay_pack6);
        laypack7 = findViewById(R.id.lay_pack7);
        laypack8 = findViewById(R.id.lay_pack8);
        laypack9 = findViewById(R.id.lay_pack9);
        laypack10 = findViewById(R.id.lay_pack10);



        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openMain6();
            }
        });


        laypack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack2();

            }
        });


        laypack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack1();
            }
        });

        laypack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack3();
            }
        });
        laypack4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack4();
            }
        });

        laypack5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack5();
            }


        });
        laypack6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack6();
            }


        });
        laypack7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack7();
            }


        });laypack8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack8();
            }


        });

        laypack9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack9();
            }
        });
        laypack10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openpack10();
            }
        });



        View overlay =  findViewById(R.id.mylayout);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    private void openpack10(){
        Intent intent = new Intent(this, exer_chordpack10_em.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    private void openpack9(){
        Intent intent = new Intent(this, exer_chordpack9_c.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    private void openpack8() {
        Intent intent = new Intent(this, exer_chordpack8_c.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    private void openpack7() {
        Intent intent = new Intent(this, exer_chordpack7_c.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    private void openpack6() {
        Intent intent = new Intent(this, exer_chordpack6_c.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    private void openpack5() {
        Intent intent = new Intent(this, exer_chordpack5_c.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    private void openpack4() {
        Intent intent = new Intent(this, exer_chordpack4_g.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    private void openpack3() {
        Intent intent = new Intent(this, exer_chordpack3_g.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
        finish();
    }

    private void openMain6() {
        Intent intent = new Intent(this, Main6Activity.class);
        startActivity(intent);
        Animatoo.animateSlideDown(this);
finish();
    }

    private void openpack1() {

        Intent intent = new Intent(this, Table_C.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
finish();

    } private void openpack2() {

        Intent intent = new Intent(this, exer_chordpack2_g.class);
        startActivity(intent);
        Animatoo.animateSlideUp(this);
finish();

    }
}
