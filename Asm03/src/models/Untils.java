package models;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Untils {
    public  String getDevider(){
        String getDevider = "*-----*------------------*-------*";
            return getDevider;
    }
    // hàm chỉnh format in số dư
    public String formatBalance(double amount){
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedAmount = formatter.format(amount);

        return formattedAmount;
    }
    // hàm lấy thời gian hiện tại
    public String getDateTime(){
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(calendar.getTime());
    };
}
