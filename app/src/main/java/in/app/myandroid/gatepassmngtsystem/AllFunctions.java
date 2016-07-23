package in.app.myandroid.gatepassmngtsystem;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by mukund on 14/7/16.
 */

public class AllFunctions {
    Context mContext;

    public AllFunctions(Context context) {
        this.mContext = context;
    }

    public ArrayList<String> LoadingDates() {
        ArrayList<String> arrayListDateValue = new ArrayList<>();

        arrayListDateValue.add("DD");
        for (int i = 1; i <= 31; i++) {
            if (i <= 9) {
                arrayListDateValue.add("0" + String.valueOf(i));
            } else {
                arrayListDateValue.add(String.valueOf(i));
            }
        }
        return arrayListDateValue;
    }

    public ArrayList<String> LoadingMonths() {

        ArrayList<String> arrayListMonthValue = new ArrayList<>();
        //String Months[]={"Jan","Feb","Mar","Apr","May", "Jun", "Jul","Aug", "Sep","Oct","Nov","Dec"};

        arrayListMonthValue.add("MM");
        for (int i = 1; i <= 12; i++) {
            if (i <= 9) {
                arrayListMonthValue.add("0" + String.valueOf(i));
            } else {
                arrayListMonthValue.add(String.valueOf(i));
            }
        }

        return arrayListMonthValue;

    }

    public ArrayList<String> LoadingYears() {
        ArrayList<String> arrayListYearValue = new ArrayList<>();
        Calendar calendar = null;
        int year = calendar.getInstance().get(Calendar.YEAR);
        int minAge, maxAge;
        maxAge = year - 18;
        minAge = year - 66;
        arrayListYearValue.add("YYYY");
        for (int i = minAge; i <= maxAge; i++) {
            arrayListYearValue.add(String.valueOf(i));
        }

        return arrayListYearValue;
    }

    public String getCurrentDate() {
        Calendar calendar = null;
        int dt = calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int mnth = calendar.getInstance().get(Calendar.MONTH) + 1;
        int yr = calendar.getInstance().get(Calendar.YEAR);
        String date = String.valueOf(dt) + "-" + String.valueOf(mnth) + "-" + String.valueOf(yr);

        return date;
    }
}
