package com.denr.solidwaste.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Locale;

public class TextUtil {

    public static String toLowerCase(String text) {
        return text.toLowerCase(Locale.getDefault());
    }

    @NonNull
    public static String toNonNull(@Nullable String string) {
        if (string == null) return "";
        return string;
    }

    public static String toNullIfEmpty(String string) {
        try {
            if (string.isEmpty()) return null;
            return string;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public static boolean isNotNullOrEmpty(String string) {
        return string != null && !string.isEmpty();
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
