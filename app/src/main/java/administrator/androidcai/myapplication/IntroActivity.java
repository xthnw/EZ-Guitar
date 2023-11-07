package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {




    private ViewPager screenPager;
    IntroViewPageAdapter introViewPageAdapter;
    TabLayout tabIndicator;
    Button button_next,button_skip;
    int position = 0;
    Button button_getstarted;
    Animation button_animation;
    Animation uptodown,downtoup,lefttoright,righttoleft;
    TextView txt;
    ViewPager screenViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);



        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);



        Typeface tf = Typeface.createFromAsset(getAssets(),"Cloud.otf");

        // when activity to be launch  check if opened before or not

        if(restorePrefData()){
            Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivity);
            finish();
        }


        //ini view





        button_skip = findViewById(R.id.button_skip);
        button_skip.setAnimation(downtoup);
        button_next = findViewById(R.id.button_note);
        button_next.setTypeface(tf);
        button_next.setAnimation(uptodown);
        button_getstarted = findViewById(R.id.button_finish);
        button_getstarted.setTypeface(tf);
        tabIndicator = findViewById(R.id.tab_indicator);
        tabIndicator.setAnimation(lefttoright);
        button_animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation_getstated);


        //fill list screen

        final List<ScreenItem>mList = new ArrayList<>();
        mList.add((new ScreenItem("EZ Guitar","Free - Chords, Lesson & Simulator Games"+"\nevery time You can be a Musician!",R.drawable.logooo)));
        mList.add((new ScreenItem("Learn and Play Guitar","easy to learn about Guitar on Your Phone"+"\nselect chord by You need to Play",R.drawable.playguitar)));
        mList.add((new ScreenItem("Practice & Game","Try Chord after You learned and practiced to Check your skill ",R.drawable.selectchord)));

        // setup viewpager
        screenPager = findViewById(R.id.slideViewPager);
        introViewPageAdapter = new IntroViewPageAdapter(this,mList);
        screenPager.setAdapter(introViewPageAdapter);
        screenPager.setAnimation(righttoleft);
        finish();






        // setup tabLayout with viewerPager
        tabIndicator.setupWithViewPager(screenPager);

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = screenPager.getCurrentItem();
                if(position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size()-1){ // when last page

                    // TODO : show the GET STARTED Button and hide the indicator and the next button

                    loadLastScreen();

                }

            }

        });

        // tab layout add change listener



        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()== mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Get Started button
        button_getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open main activity

                Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);

                //crash intro activity

                savePrefsData();
                finish();



            }
        });

        button_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main2Activity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(main2Activity);

                savePrefsData();
                finish();
            }
        });





    }

    private boolean restorePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("sIntroOpened",false);
        return  isIntroActivityOpenedBefore;



    }

    private void savePrefsData() {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();



    }

    private void loadLastScreen() {

        button_next.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        button_skip.setVisibility((View.INVISIBLE));
        button_getstarted.setVisibility(View.VISIBLE);

        // TODO : ADD an animation the get started button
        // setup animation

        button_getstarted.setAnimation(button_animation);
    }

}
