package mohu.smartID.gitex.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class Utils {
    public static String getTime(String time){
        try {
            String format = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
            Date date = simpleDateFormat.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+" "+( calendar.get(Calendar.AM_PM) == 1 ? "AM" : "PM" );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean isEmpty(String text) {
        return (text == null || text.length() == 0 || text.equalsIgnoreCase("null")) ? true : false;
    }

    //email validation
    public static boolean isValidEmail(String email) {
        String emailRegex =
                "^[a-zA-Z0-9_+&*-]+(?:\\." +
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        boolean result = pat.matcher(email).matches();
        return result;
    }
    public static String getFormattedDate(String src, String trgt, String dateTimeString) {
        String result = "";
        try {
            if (!Utils.isEmpty(dateTimeString)) {
                dateTimeString = dateTimeString.replace("Thu", "thu").replace("Tue", "tue");
                dateTimeString = dateTimeString.replace("T", " ");
            }
            SimpleDateFormat srcFormat = new SimpleDateFormat(src,Locale.US);
            SimpleDateFormat trgtFormat = new SimpleDateFormat(trgt,Locale.US);
            Date currentDate = new Date();
            currentDate = srcFormat.parse(dateTimeString);
            Calendar c = Calendar.getInstance();
            c.setTime(currentDate);
            currentDate = c.getTime();
            result = trgtFormat.format(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
    public static String getCustomDateConvertion(String dateValue, String fromDateFormate, String toDateFormate) {
        // 1arg value to be converted 2 arg date forrmate of current date 3 arg desired formate

//        Log.i("DATETIME.", "getCustomDateConvertion: " + dateValue + " " + fromDateFormate + " " + toDateFormate);
        String result = "";
        if (!Utils.isEmpty(dateValue)) {
            dateValue = dateValue.replace("Thu", "thu").replace("Tue", "tue");
            dateValue = dateValue.replace("T", " ");
        }
        try {
            if (toDateFormate.equalsIgnoreCase("DD/MM/YY")) {
                toDateFormate = "dd/MM/yy";
            } else if (toDateFormate.equalsIgnoreCase("DD/MM/YYYY")) {
                toDateFormate = "dd/MM/yyyy";

            } else if (toDateFormate.equalsIgnoreCase("DD/MMM/YY")) {
                toDateFormate = "dd/MMM/yy";
            } else if (toDateFormate.equalsIgnoreCase("DD-MM-YY")) {
                toDateFormate = "dd-MM-yy";
            } else if (toDateFormate.equalsIgnoreCase("DD-MM-YYYY")) {
                toDateFormate = "dd-MM-yyyy";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(fromDateFormate,Locale.US);
            //DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.ENGLISH);
            SimpleDateFormat csdf = new SimpleDateFormat(toDateFormate,Locale.US);
            Date currentDate = new Date();
            if (!Utils.isEmpty(dateValue)) {
                dateValue = dateValue.replace("T", " ");
                currentDate = sdf.parse(dateValue);
                Calendar c = Calendar.getInstance();
                c.setTime(currentDate);
                currentDate = c.getTime();
                result = csdf.format(currentDate);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
