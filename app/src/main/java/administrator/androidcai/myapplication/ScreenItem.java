package administrator.androidcai.myapplication;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;

import androidx.core.content.pm.PermissionInfoCompat;

public class ScreenItem {

    String Title,Description;
    int ScreenImg,ScreenImg2,ScreenImg3;


    public ScreenItem(String title, String description, int screenImg) {
        Title = title;
        Description = description;
        ScreenImg = screenImg;
    }


    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }
    public void setScreenImg2(int   screenImg2){
        ScreenImg2 = screenImg2;
    }

    public void setScreenImg3(int   screenImg3){
        ScreenImg3 = screenImg3;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }
    public int getScreenImg2(){
        return ScreenImg2;
    }

    public int getScreenImg3(){
        return ScreenImg3;
    }
}
