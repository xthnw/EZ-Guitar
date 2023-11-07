package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import org.w3c.dom.Text;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    TextView welcome,welcome2;
    Button button_letdo;
    Animation uptodown,downtoup,lefttoright,slide;
    private Button button;
    private long backPressedTime;
    private Toast backToast;
    static MediaPlayer touch;


    TextView rules;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        rules = findViewById(R.id.rules);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, administrator.androidcai.myapplication.rules.class);
                startActivity(i);
            }
        });




        View overlay =  findViewById(R.id.mylayout);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);



        button_letdo = (Button)findViewById(R.id.button_letdo);
        welcome = (TextView) findViewById(R.id.welcome);
        welcome2 = (TextView) findViewById(R.id.welcome2);


        slide = AnimationUtils.loadAnimation(this,R.anim.slide);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);

        button_letdo.startAnimation(slide);


        welcome.setAnimation(uptodown);
        welcome2.setAnimation(downtoup);









        Typeface tf = Typeface.createFromAsset(getAssets(),"PierSans-Bold.otf");
        Typeface ttf = Typeface.createFromAsset(getAssets(),"Cloud.otf");
        TextView font = (TextView)findViewById(R.id.welcome);
        font.setTypeface(tf);
        TextView font_2 = (TextView) findViewById(R.id.welcome2);
        font_2.setTypeface(ttf);



        button_letdo.setTypeface(ttf);
    }

    @Override
    protected void onResume(){
        super.onResume();
        final MediaPlayer touch = MediaPlayer.create(this,R.raw.touch);
        button_letdo = findViewById(R.id.button_letdo);
        button_letdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                touch.start();
                openMain2Activity();
            }
        });
    }

    public void openMain2Activity(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        Animatoo.animateSlideLeft(this);
        finish();
    }


    @Override
    public void onBackPressed() {


        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        else{
            backToast = Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_LONG);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

}
