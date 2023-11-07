package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Main6Activity extends AppCompatActivity {


    private ImageView  back;
    TextView choose_chord_set;
    Button button_note3,button_game_1,btn_remember;
    static MediaPlayer click;


    static MediaPlayer t,touch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);







        click = MediaPlayer.create(this,R.raw.touch);



        View overlay =  findViewById(R.id.mylayout);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        Typeface tf = Typeface.createFromAsset(getAssets(),"PierSans-Bold.otf");


        btn_remember = findViewById(R.id.button_remember);
        button_note3 = findViewById(R.id.button_note1);
        button_game_1 = findViewById(R.id.button_game_1);
        choose_chord_set = (TextView)findViewById(R.id.choose_chord_set);
        choose_chord_set.setTypeface(tf);


        button_game_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                opengame_1();
            }
        });

        button_note3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                openTable_CActivity();
            }
        });


        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                openMain2Activity();
            }
        });


        btn_remember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.start();
                openrembmer();
            }
        });


    }





    public void openrembmer(){
        Intent intent = new Intent(this,remember_chord.class);
        startActivity(intent);
        Animatoo.animateFade(this);

    }




    public void opengame_1(){
        Intent intent = new Intent(this,game_chord_c.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }

    public void openMain2Activity(){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);

        Animatoo.animateFade(this);
        finish();

    }

    public void openTable_CActivity(){
        Intent intent = new Intent(this, boardcast_learn.class);
        startActivity(intent);
        Animatoo.animateFade(this);
        finish();
    }



    }