package com.denr.solidwaste.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import timber.log.Timber;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.YEAR;

public class TimeUtil {


    static final String ISO_8601_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

    private static final String FALLBACK_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";

    private static final String REMINDER_DATE_FORMAT = "EEE, dd MMM";

    public static final String TIME_FORMAT_AM_PM = "HH:mm a";

    public static long toMillis(int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR, year);
        calendar.set(MONTH, month);
        calendar.set(DAY_OF_MONTH, dayOfMonth);
        calendar.set(HOUR, 0);
        calendar.set(MINUTE, 0);
        calendar.set(SECOND, 0);
        calendar.set(MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * @param dateTime the date and time formatted in YYYY-MM-DD[T]HH:mm:ss[Z]
     */
    public static long fromIso8601(String dateTime) {
        try {
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat(ISO_8601_DATE_TIME_FORMAT, Locale.getDefault());
            return simpleDateFormat.parse(dateTime).getTime();
        } catch (ParseException e) {
            //Timber.e(e);
            return 0;
        }
    }

    /**
     * Added this method cause sometimes we're receiving Dates that are not in ISO-8601 format.
     * */
    private static long fallbackFormat(String dateTime) {
        try {
            dateTime = dateTime + "+0000";
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat(FALLBACK_DATE_FORMAT, Locale.getDefault());
            return simpleDateFormat.parse(dateTime).getTime();
        } catch (ParseException e) {
            Timber.e(e);
            return 0;
        }
    }

    /**
     * @return the date and time formatted in YYYY-MM-DD[T]HH:mm:ss[Z]
     */
    public static String toIso8601(long dateTime) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(dateTime);

        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat(ISO_8601_DATE_TIME_FORMAT, Locale.getDefault());
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String format(long date, String format) {
        return new SimpleDateFormat(format, Locale.getDefault()).format(date);
    }

    public static long format(String date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        try {
            return simpleDateFormat.parse(date).getTime();
        } catch (ParseException e) {
            Timber.e(e);
            return 0;
        }
    }

    @SuppressLint("SimpleDateFormat")
    public static String getFormattedDateFromTimestampForOffer(long timestampInSeconds) {
        Date date = new Date();
        date.setTime(timestampInSeconds * 1000L);
        return new SimpleDateFormat("dd MMM, yyyy").format(date);

    }

    @SuppressLint("SimpleDateFormat")
    public static String getFormattedTimeFromTimestampForOffer(long timestampInSeconds) {
        Date date = new Date();
        date.setTime(timestampInSeconds * 1000L);
        return new SimpleDateFormat("HH:mm").format(date);
    }

    @SuppressLint("SimpleDateFormat")
    public static String getFormattedDateFromTimeStampForChat(long timestampInSeconds) {
        Date date = new Date();
        date.setTime(timestampInSeconds * 1000L);
        return new SimpleDateFormat("dd MMM yyyy").format(date);
    }

    //If the date has not been set , use the default value from calendar
    @SuppressLint("SimpleDateFormat")
    public static String getFormattedDateForReminderScreen(Calendar calendar) {

        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat(REMINDER_DATE_FORMAT, Locale.getDefault());

        return simpleDateFormat.format(calendar.getTime());
    }

    @SuppressLint("SimpleDateFormat")
    public static String getFormattedDate(Date date) {

        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    @SuppressLint("SimpleDateFormat")
    public static String getFormattedTime(Date date, String format) {

        return new SimpleDateFormat(format).format(date);
    }

}
