package com.reactnativenavigation.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.reactnativenavigation.BuildConfig;
import com.reactnativenavigation.parse.params.Text;
import com.reactnativenavigation.utils.CompatUtils;
import static com.reactnativenavigation.utils.ObjectUtils.perform;
import android.graphics.Color;

@SuppressLint("ViewConstructor")
public class BottomTabs extends AHBottomNavigation {
    private boolean itemsCreationEnabled = true;
    private boolean shouldCreateItems = true;

    public void disableItemsCreation() {
        itemsCreationEnabled = false;
    }

    public void enableItemsCreation() {
        itemsCreationEnabled = true;
        if (shouldCreateItems) createItems();
    }

    public BottomTabs(Context context) {
        super(context);
        setId(CompatUtils.generateViewId());
        setContentDescription("BottomTabs");
    }

    @Override
    protected void createItems() {
        if (itemsCreationEnabled) {
            superCreateItems();
        } else {
            shouldCreateItems = true;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

    }

    public void superCreateItems() {
        super.createItems();
    }

    public void setBadge(int bottomTabIndex, String badge) {
        setNotification(badge, bottomTabIndex);
    }

    public void setBadgeColor(@ColorInt Integer color) {
        if (color == null) return;
        setNotificationBackgroundColor(color);
    }

    @Override
    public void setCurrentItem(@IntRange(from = 0) int position) {
        super.setCurrentItem(position);
    }

    @Override
    public void setTitleState(TitleState titleState) {
        if (getTitleState() != titleState) super.setTitleState(titleState);
    }

    public void setText(int index, String text) {
        AHBottomNavigationItem item = getItem(index);
        if (!item.getTitle(getContext()).equals(text)) {
            item.setTitle(text);
            refresh();
        }
    }

    public void setVisible(int index, boolean value) {
        AHBottomNavigationItem item = getItem(index);
        if (item != null) {
            if (!value) {
                super.disableItemAtPosition(index);
                super.setIconDisableColor(index, Color.parseColor("#00000000"));
            } else
                super.enableItemAtPosition(index);
        }
    }
    public void setIcon(int index, Drawable icon) {
        AHBottomNavigationItem item = getItem(index);
        if (!item.getDrawable(getContext()).equals(icon)) {
            item.setDrawable(icon);
            refresh();
        }
    }
}
