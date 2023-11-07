package administrator.androidcai.myapplication;

import android.view.animation.Interpolator;

public class Mybounce implements Interpolator {

    private double myamplitude =1;
    private double myfrequency = 10;


    Mybounce(double amplitude,double frequency){
        myamplitude = amplitude;
        myfrequency = frequency;
    }


    @Override
    public float getInterpolation(float time) {
        return (float)(-1*Math.pow(Math.E,-time/myamplitude)*Math.cos(myfrequency*time  )+1);
    }
}
