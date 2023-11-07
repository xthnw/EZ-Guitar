package administrator.androidcai.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Main5Activity extends AppCompatActivity {


    private ImageView back;
    private ViewPager mSlideViewPager;
    TabLayout tabIndicator;
    private ViewPager screenPager;
    IntroViewPageAdapter introViewPageAdapter;
    Button button_next;
    int position = 0;
    Button button_getstarted;
    Animation button_animation;
    Animation uptodown,downtoup,lefttoright,righttoleft;
    ViewPager screenViewPager;
    private TextView intro,des;
    static MediaPlayer t;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        t = MediaPlayer.create(this,R.raw.touch);

        View overlay =  findViewById(R.id.mylayout);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);







        // add animation
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);


        // add font
        Typeface tf = Typeface.createFromAsset(getAssets(),"Cloud.otf");







        button_next = findViewById(R.id.button_note);
        button_next.setTypeface(tf);
        button_getstarted = findViewById(R.id.button_finish);
        button_getstarted.setTypeface(tf);
        tabIndicator = findViewById(R.id.tab_indicator);
        button_animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation_getstated);

        button_getstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
                openMain2Activity();
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
                openMain2Activity();
            }
        });






        //fill list screen
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add((new ScreenItem("คอร์ดคืออะไร ?","คอร์ดหมายถึงกลุ่มของเสียงตัวโน๊ตที่รวมกันตั้งแต่ 3 เสียงขึ้นไป"+"\nซึ่งแต่ละคอร์ดก็จะมีชื่อเรียกประจำของมันเอง โดยมีหลักในการสร้างคอร์ด"+
                "และตั้งชื่อให้กับคอร์ดนั้นๆ\nเช่นคอร์ด C ก็จะประกอบด้วยโน๊ต C E G เป็นต้น",R.drawable.playguitar)));
        mList.add((new ScreenItem("คอร์ด Major ?","หลักในการสร้างคอร์ดเมเจอร์จะยึดโครงสร้างของ Major Scale มาใช้ในการสร้างคอร์ด"+"\nเช่นคอร์ด C ก็จะประกอบไปด้วยโน๊ตตัวที่ 1 3 5 ของ C Major Scale คือ [C] D [E] F [G] A B"
                +"\nดังนั้นคอร์ด C ก็จะประกอบไปด้วยโน๊ต C E G นั่นเอง",R.drawable.c_chord)));
        mList.add((new ScreenItem("คอร์ด Minor ?","หลักในการสร้างคอร์ดไมเนอร์เช่นคอร์ด Cm ก็จะประกอบด้วยโน๊ตตัวที่ 1 b3 5"+"\n(b3 หมายถึงลดเสียงโน๊ตตัวที่ 3 ของ Major Scale ลงครึ่งเสียง)"+"\nซึ่ง C Minor = [C] D [Eb] F [G] A B"
                +"ดังนั้นคอร์ด Cm ก็จะประกอบไปด้วยโน๊ต C Eb G นั่นเอง"
                ,R.drawable.am_chord)));
        mList.add((new ScreenItem("อ่านตารางคอร์ดอย่างไร ? ?","ก่อนอื่นก็ต้องมาทำความเข้าใจกับสัญลักษณ์ของนิ้วมือซ้ายของแต่ละนิ้วกันก่อน ว่านิ้วไหนใช้แทนตัวเลขอะไรกันบ้าง ><"+"\nเพื่อนๆ สามารถดูตามภาพได้เลยคือ นิ้วชี้ = 1 นิ้วกลาง = 2 นิ้วนาง = 3 นิ้วก้อย = 4"+
                "\nแค่นี้เองงงงง ^^ ง่ายใช่มั้ยล่ะ ",R.drawable.hand)));
        mList.add((new ScreenItem("จับนี้คอร์ดอย่างไร ?","คอร์ดนี้เรียกว่าคอร์ด G หรือ Gmajor ก็ได้"+"\nวิธ๊จับคอร์ด G เริ่มต้นด้วยการใช้นิ้วนางกดลงบนสาย 1 ช่องที่ 3"+
                "\nต่อด้วยนิ้วชี้กดลงบนสาย 5 ช่องที่ 2 และนิ้วกลางกดลงบนสาย 6 ช่องที่ 3 ",R.drawable.g_chord)));
        intro  = findViewById(R.id.intro_title);
        des = findViewById(R.id.intro_description);




        // setup viewpager
        screenPager = findViewById(R.id.slideViewPager);
        introViewPageAdapter = new IntroViewPageAdapter(this,mList);
        screenPager.setAdapter(introViewPageAdapter);


        // setup tabLayout with viewerPager
        tabIndicator.setupWithViewPager(screenPager);


        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();

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



    }


    private void loadLastScreen() {

        button_next.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        button_getstarted.setVisibility(View.VISIBLE);
        back.setVisibility(View.INVISIBLE);

        // TODO : ADD an animation the get started button
        // setup animation

        button_getstarted.setAnimation(button_animation);
    }

    public void openMain2Activity(){
        t.start();
        finish();
        Animatoo.animateFade(this);

    }



    @Override
    public void onBackPressed() {
        Intent mainActivity = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(mainActivity);
        finish();
    }
}
