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

public class Main4Activity extends AppCompatActivity {
    private ImageView back;
    static MediaPlayer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        t = MediaPlayer.create(this,R.raw.touch);

        View overlay =  findViewById(R.id.mylayout);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        Typeface ttf = Typeface.createFromAsset(getAssets(), "Cloud.otf");

        TextView font = (TextView) findViewById(R.id.textView);
        font.setTypeface(ttf);
        TextView font2 = (TextView) findViewById(R.id.textView2);
        font2.setTypeface(ttf);
        TextView font3 = (TextView) findViewById(R.id.textView3);
        font3.setTypeface(ttf);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
                openMain2Activity();
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);
        finish();


    }

    public void openMain2Activity(){
        finish();
        Animatoo.animateFade(this);
    }
}
