package com.pluscubed.plustimer.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.pluscubed.plustimer.BuildConfig;

public class PrefUtils {
    public static final String PREF_SCRAMBLE_TEXT_SIZE_EDITTEXT =
            "pref_scramble_display_size_edittext";
    public static final String PREF_TIME_TEXT_SIZE_EDITTEXT =
            "pref_time_display_size_edittext";
    public static final String PREF_LOCK_SWIPING_CHECKBOX =
            "pref_lock_swiping_checkbox";
    public static final String PREF_UPDATE_TIME_LIST =
            "pref_update_time_list";
    public static final String PREF_PUZZLETYPES_MULTISELECTLIST =
            "pref_puzzletypes_multiselectlist";
    public static final String PREF_THEME_LIST =
            "pref_theme_list";
    private static final String PREF_INSPECTION_CHECKBOX =
            "pref_inspection_checkbox";
    private static final String PREF_HOLDTOSTART_CHECKBOX =
            "pref_holdtostart_checkbox";
    private static final String PREF_KEEPSCREENON_CHECKBOX =
            "pref_keepscreenon_checkbox";
    private static final String PREF_TWO_ROW_TIME_CHECKBOX =
            "pref_two_row_time_checkbox";
    private static final String PREF_MILLISECONDS_CHECKBOX =
            "pref_milliseconds_checkbox";
    private static final String PREF_SIGN_CHECKBOX =
            "pref_sign_checkbox";
    private static final String PREF_MONOSPACE_SCRAMBLES_CHECKBOX =
            "pref_monospace_scrambles_checkbox";

    private static final String PREF_LOG_IN =
            "pref_login_data";
    private static final String PREF_VERSION_CODE =
            "pref_version_code";
    private static final String PREF_WELCOME_DONE =
            "pref_welcome_done";
    private static final String PREF_CURRENT_PUZZLETYPE =
            "pref_current_puzzle_type";

    private static SharedPreferences.Editor edit(Context context) {
        return getSp(context).edit();
    }

    private static SharedPreferences getSp(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setLoginData(final Context context, String loginData) {
        edit(context).putString(PREF_LOG_IN, loginData).apply();
    }

    @Nullable
    public static String getLoginData(final Context context) {
        return getSp(context).getString(PREF_LOG_IN, null);
    }

    public static void setCurrentPuzzleType(final Context context, String puzzletype) {
        edit(context).putString(PREF_CURRENT_PUZZLETYPE, puzzletype).apply();
    }

    @Nullable
    public static String getCurrentPuzzleType(final Context context) {
        return getSp(context).getString(PREF_CURRENT_PUZZLETYPE, null);
    }

    public static boolean isInspectionEnabled(final Context context) {
        return getSp(context).getBoolean(PREF_INSPECTION_CHECKBOX, true);
    }

    public static boolean isHoldToStartEnabled(final Context context) {
        return getSp(context).getBoolean(PREF_HOLDTOSTART_CHECKBOX, true);
    }

    public static boolean isTwoRowTimeEnabled(final Context context) {
        return getSp(context).getBoolean(PREF_TWO_ROW_TIME_CHECKBOX, true);
    }

    public static boolean isDisplayMillisecondsEnabled(final Context context) {
        return getSp(context).getBoolean(PREF_MILLISECONDS_CHECKBOX, true);
    }

    public static boolean isKeepScreenOnEnabled(final Context context) {
        return getSp(context).getBoolean(PREF_KEEPSCREENON_CHECKBOX, true);
    }

    public static boolean isSignEnabled(final Context context) {
        return getSp(context).getBoolean(PREF_SIGN_CHECKBOX, true);
    }

    public static boolean isMonospaceScrambleFontEnabled(final Context context) {
        return getSp(context).getBoolean(PREF_MONOSPACE_SCRAMBLES_CHECKBOX, true);
    }

    public static boolean isWelcomeDone(final Context context) {
        return getSp(context).getBoolean(PREF_WELCOME_DONE, false);
    }

    public static boolean isLockSwipingEnabled(final Context context) {
        return getSp(context).getBoolean(PREF_LOCK_SWIPING_CHECKBOX, false);
    }

    public static void markWelcomeDone(final Context context) {
        edit(context).putBoolean(PREF_WELCOME_DONE, true).apply();
    }

    public static int getTimerTextSize(final Context context) {
        return Integer.parseInt(getSp(context).getString(PREF_TIME_TEXT_SIZE_EDITTEXT, "100"));
    }

    public static int getScrambleTextSize(final Context context) {
        return Integer.parseInt(getSp(context).getString(PREF_SCRAMBLE_TEXT_SIZE_EDITTEXT, "18"));
    }

    public static void saveVersionCode(final Context context) {
        edit(context).putInt(PrefUtils.PREF_VERSION_CODE, BuildConfig.VERSION_CODE).apply();
    }

    public static int getVersionCode(final Context context) {
        return getSp(context).getInt(PREF_VERSION_CODE, 10);
    }

    public static TimerUpdate getTimerUpdateMode(final Context context) {
        switch (Integer.parseInt(getSp(context).getString(PREF_UPDATE_TIME_LIST, "0"))) {
            case 0:
                return TimerUpdate.ON;
            case 1:
                return TimerUpdate.SECONDS;
            case 2:
                return TimerUpdate.OFF;
            default:
                return TimerUpdate.ON;
        }
    }

    public static Theme getTheme(final Context context) {
        switch (Integer.parseInt(getSp(context).getString(PREF_THEME_LIST, "0"))) {
            case 0:
                return Theme.LIGHT;
            case 1:
                return Theme.DARK;
            case 2:
                return Theme.BLACK;
            default:
                return Theme.LIGHT;
        }
    }

    public enum Theme {
        LIGHT, DARK, BLACK
    }

    public enum TimerUpdate {
        ON, SECONDS, OFF
    }


}
