package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView;

import java.lang.reflect.Type;

public class Loading_Application extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading__application);








        View overlay =  findViewById(R.id.mylayout);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        Typeface tf = Typeface.createFromAsset(getAssets(),"PierSans-Bold.otf");



        progressBar = findViewById(R.id.progress_bar);
        textView = findViewById(R.id.text_view);

        textView.setTypeface(tf);




        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();




    }

    public  void progressAnimation(){
        ProgressBarAnimation anim = new ProgressBarAnimation(this,progressBar,textView,0f,100f);
        anim.setDuration(8500);
        progressBar.setAnimation(anim);

    }






}
