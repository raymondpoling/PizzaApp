package org.mousehole.americanairline.myfourthapplication.util;

import android.annotation.SuppressLint;

public class Utilities {
    @SuppressLint("DefaultLocale")
    public static String makePrice(Double price) {
        return String.format("$ %.02f", price);
    }
}
