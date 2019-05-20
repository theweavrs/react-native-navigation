package com.reactnativenavigation.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.ColorInt;

import com.reactnativenavigation.fab.FloatingActionButton;
import com.reactnativenavigation.anim.FabAnimator;
import com.reactnativenavigation.anim.FabCollapseBehaviour;
import com.reactnativenavigation.interfaces.ScrollEventListener;
import com.reactnativenavigation.parse.params.Colour;
import com.reactnativenavigation.utils.ImageLoader;
import com.reactnativenavigation.utils.ImageLoadingListenerAdapter;

import java.util.Collections;
import java.util.List;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.reactnativenavigation.R;
import com.amulyakhare.textdrawable.TextDrawable;

public class Fab extends FloatingActionButton implements FabAnimator {

    private String id = "";
    private FabCollapseBehaviour collapseBehaviour;

    public Fab(Context context, String id) {
        super(context);
        collapseBehaviour = new FabCollapseBehaviour(this);
        this.id = id;
    }

    public void applyIcon(String icon, String text, int fontSize, @ColorInt int textColor) {
        if (text != null && fontSize != 0 && textColor != 0 && icon == null) {
            Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto.ttf");
            int scaledSize = getContext().getResources().getDimensionPixelSize(fontSize);
            TextDrawable drawable = TextDrawable.builder().beginConfig().textColor(textColor).useFont(font)
                    .fontSize(scaledSize).endConfig().buildRect(text, Color.TRANSPARENT);
            setImageDrawable(drawable);
        } else
            new ImageLoader().loadIcons(getContext(), Collections.singletonList(icon),
                    new ImageLoadingListenerAdapter() {
                        @Override
                        public void onComplete(@NonNull List<Drawable> drawables) {
                            setImageDrawable(drawables.get(0));
                        }

                        @Override
                        public void onError(Throwable error) {
                            error.printStackTrace();
                        }
                    });
    }

    // method to convert your text to image
    public static Bitmap textAsBitmap(String text, float textSize, int textColor) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.LEFT);
        float baseline = -paint.ascent(); // ascent() is negative
        int width = (int) (paint.measureText(text) + 0.0f); // round
        int height = (int) (baseline + paint.descent() + 0.0f);
        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(image);
        canvas.drawText(text, 0, baseline, paint);
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fab fab = (Fab) o;

        return id.equals(fab.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public void show() {
        show(true);
    }

    @Override
    public void hide() {
        hide(true);
    }

    public void enableCollapse(@NonNull ScrollEventListener scrollEventListener) {
        collapseBehaviour.enableCollapse(scrollEventListener);
    }

    public void disableCollapse() {
        collapseBehaviour.disableCollapse();
    }

    public String getFabId() {
        return id;
    }
}
