package bean;

import android.graphics.Bitmap;

public class Itembean {
    private String title;
    private Bitmap rightImg;
    private Bitmap headImg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getRightImg() {
        return rightImg;
    }

    public void setRightImg(Bitmap rightImg) {
        this.rightImg = rightImg;
    }

    public Bitmap getHeadImg() {
        return headImg;
    }

    public void setHeadImg(Bitmap headImg) {
        this.headImg = headImg;
    }
}
