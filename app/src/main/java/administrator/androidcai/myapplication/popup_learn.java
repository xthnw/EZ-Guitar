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
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class popup_learn extends AppCompatActivity {
    Dialog myDialog;
    Dialog mPreviewDialog;
    static MediaPlayer t,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_learn);

        t = MediaPlayer.create(this,R.raw.touch);
        exit = MediaPlayer.create(this,R.raw.backsound);

        mPreviewDialog = new Dialog(this);
        Window dialog_window = mPreviewDialog.getWindow();
        dialog_window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mPreviewDialog.show();



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
        txt_table_chord.setTypeface(tf);
        txt_chord.setTypeface(tf);
        txtclose.setTypeface(tf);
        txt_note.setTypeface(tf);
        txt_lets_go_to_learn_guitar.setTypeface(tf);
        txt_please_choose_a_lesson.setTypeface(tf);

        txt_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
                openMain4Activity();
            }
        });
        txt_chord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
                openMain5Activity();
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit.start();
                myDialog.dismiss();
                finish();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


    }

    public void show(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

    }
    public void openMain4Activity(){
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }

    public void openMain5Activity(){
        Intent intent = new Intent(this,Main5Activity.class);
        startActivity(intent);
        Animatoo.animateFade(this);
    }




}
