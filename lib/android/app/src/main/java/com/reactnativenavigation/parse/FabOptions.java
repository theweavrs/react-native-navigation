package com.reactnativenavigation.parse;

import com.reactnativenavigation.parse.params.Bool;
import com.reactnativenavigation.parse.params.Colour;
import com.reactnativenavigation.parse.params.NullBool;
import com.reactnativenavigation.parse.params.NullColor;
import com.reactnativenavigation.parse.params.NullNumber;
import com.reactnativenavigation.parse.params.NullText;
import com.reactnativenavigation.parse.params.Text;
import com.reactnativenavigation.parse.params.Number;
import com.reactnativenavigation.parse.parsers.BoolParser;
import com.reactnativenavigation.parse.parsers.ColorParser;
import com.reactnativenavigation.parse.parsers.TextParser;
import com.reactnativenavigation.parse.parsers.NumberParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class FabOptions {

    public static FabOptions parse(JSONObject json) {
        FabOptions options = new FabOptions();
        if (json == null) return options;

        options.id = TextParser.parse(json, "id");
        options.backgroundColor = ColorParser.parse(json, "backgroundColor");
        options.clickColor = ColorParser.parse(json, "clickColor");
        options.rippleColor = ColorParser.parse(json, "rippleColor");
        options.visible = BoolParser.parse(json, "visible");
        if (json.has("icon")) {
            options.icon = TextParser.parse(json.optJSONObject("icon"), "uri");
        }
        options.iconColor = ColorParser.parse(json, "iconColor");
        if (json.has("actions")) {
            JSONArray fabsArray = json.optJSONArray("actions");
            for (int i = 0; i < fabsArray.length(); i++) {
                options.actionsArray.add(FabOptions.parse(fabsArray.optJSONObject(i)));
            }
        }
        options.alignHorizontally = TextParser.parse(json, "alignHorizontally");
        options.alignVertically = TextParser.parse(json, "alignVertically");
        options.hideOnScroll = BoolParser.parse(json, "hideOnScroll");
        options.size = TextParser.parse(json, "size");
        options.text = TextParser.parse(json, "text");
        options.textColor = ColorParser.parse(json, "textColor");
        options.fontSize = NumberParser.parse(json, "fontSize");
        options.menuBackgroundColor = ColorParser.parse(json, "menuBackgroundColor");
        options.params = TextParser.parse(json, "params");

        //Margin
        options.bottomMargin = NumberParser.parse(json, "bottomMargin");
        options.rightMargin = NumberParser.parse(json, "rightMargin");
        options.leftMargin = NumberParser.parse(json, "leftMargin");
        options.topMargin = NumberParser.parse(json, "topMargin");

        return options;
    }

    public Text id = new NullText();
    public Colour backgroundColor = new NullColor();
    public Colour clickColor = new NullColor();
    public Colour rippleColor = new NullColor();
    public Text icon = new NullText();
    public Colour iconColor = new NullColor();
    public Bool visible = new NullBool();
    public ArrayList<FabOptions> actionsArray = new ArrayList<>();
    public Text alignHorizontally = new NullText();
    public Text alignVertically = new NullText();
    public Bool hideOnScroll = new NullBool();
    public Text size = new NullText();
    public Text text = new NullText();
    public Text params = new NullText();
    public Colour menuBackgroundColor = new NullColor();
    public Colour textColor = new NullColor();
 public Number fontSize = new NullNumber();
 public Number topMargin = new NullNumber();
 public Number bottomMargin = new NullNumber();
 public Number leftMargin = new NullNumber();
 public Number rightMargin = new NullNumber();

    void mergeWith(final FabOptions other) {
        if (other.id.hasValue()) {
            id = other.id;
        }
        if (other.text.hasValue()) {
            text = other.text;
        }
        if (other.params.hasValue()) {
            params = other.params;
        }
        if (other.menuBackgroundColor.hasValue()) {
            menuBackgroundColor = other.menuBackgroundColor;
        }
        if (other.backgroundColor.hasValue()) {
            backgroundColor = other.backgroundColor;
        }
        if (other.fontSize.hasValue()) {
            fontSize = other.fontSize;
        }
        if (other.bottomMargin.hasValue()) {
            bottomMargin = other.bottomMargin;
        }
        if (other.topMargin.hasValue()) {
            topMargin = other.topMargin;
        }
        if (other.rightMargin.hasValue()) {
            rightMargin = other.rightMargin;
        }
        if (other.leftMargin.hasValue()) {
            leftMargin = other.leftMargin;
        }
        if (other.textColor.hasValue()) {
            textColor = other.textColor;
        }
        if (other.clickColor.hasValue()) {
            clickColor = other.clickColor;
        }
        if (other.rippleColor.hasValue()) {
            rippleColor = other.rippleColor;
        }
        if (other.visible.hasValue()) {
            visible = other.visible;
        }
        if (other.icon.hasValue()) {
            icon = other.icon;
        }
        if (other.iconColor.hasValue()) {
            iconColor = other.iconColor;
        }
        if (other.actionsArray.size() > 0) {
            actionsArray = other.actionsArray;
        }
        if (other.alignVertically.hasValue()) {
            alignVertically = other.alignVertically;
        }
        if (other.alignHorizontally.hasValue()) {
            alignHorizontally = other.alignHorizontally;
        }
        if (other.hideOnScroll.hasValue()) {
            hideOnScroll = other.hideOnScroll;
        }
        if (other.size.hasValue()) {
            size = other.size;
        }
    }

    void mergeWithDefault(FabOptions defaultOptions) {
        if (!id.hasValue()) {
            id = defaultOptions.id;
        }
        if (!text.hasValue()) {
            text = defaultOptions.text;
        }
        if (!params.hasValue()) {
            params = defaultOptions.params;
        }
        if (!backgroundColor.hasValue()) {
            backgroundColor = defaultOptions.backgroundColor;
        }
        if (!menuBackgroundColor.hasValue()) {
            menuBackgroundColor = defaultOptions.menuBackgroundColor;
        }
        if (!textColor.hasValue()) {
            textColor = defaultOptions.textColor;
        }
        if (!clickColor.hasValue()) {
            clickColor = defaultOptions.clickColor;
        }
        if (!rippleColor.hasValue()) {
            rippleColor = defaultOptions.rippleColor;
        }
        if (!visible.hasValue()) {
            visible = defaultOptions.visible;
        }
        if (!icon.hasValue()) {
            icon = defaultOptions.icon;
        }
        if (!iconColor.hasValue()) {
            iconColor = defaultOptions.iconColor;
        }
        if (actionsArray.size() == 0) {
            actionsArray = defaultOptions.actionsArray;
        }
        if (!alignHorizontally.hasValue()) {
            alignHorizontally = defaultOptions.alignHorizontally;
        }
        if (!alignVertically.hasValue()) {
            alignVertically = defaultOptions.alignVertically;
        }
        if (!hideOnScroll.hasValue()) {
            hideOnScroll = defaultOptions.hideOnScroll;
        }
        if (!size.hasValue()) {
            size = defaultOptions.size;
        }

        if (!fontSize.hasValue()) {
            fontSize = defaultOptions.fontSize;
        }
        if (!bottomMargin.hasValue()) {
            bottomMargin = defaultOptions.bottomMargin;
        }
        if (!topMargin.hasValue()) {
            topMargin = defaultOptions.topMargin;
        }
        if (!rightMargin.hasValue()) {
            rightMargin = defaultOptions.rightMargin;
        }
        if (!leftMargin.hasValue()) {
            leftMargin = defaultOptions.leftMargin;
        }
    }

    public boolean hasValue() {
        return id.hasValue() || icon.hasValue();
    }
}
