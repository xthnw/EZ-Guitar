package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Typeface tf = Typeface.createFromAsset(getAssets(),"PierSans-Bold.otf");

        Button btn_note = (Button)findViewById(R.id.button_note);
        btn_note.setTypeface(tf);

        ImageView myImage = (ImageView)findViewById(R.id.choose_image);
        myImage.setImageAlpha(128);
    }

    @Override
    public void onBackPressed(){
        Intent mainActivity =  new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
