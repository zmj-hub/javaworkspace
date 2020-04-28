package Utils;

import java.text.SimpleDateFormat;

public class TimeUtils {
    public static void main(String[] args) throws Exception{
        Long time= timeConversion("2019/8/25");//1566662400000
        System.out.println(time);
    }

    public static Long timeConversion(String time) throws Exception {
        SimpleDateFormat format;
        if (time.contains("/")) {
            format = new SimpleDateFormat("yyyy/MM/dd");
        } else if (time.contains("-")) {
            format = new SimpleDateFormat("yyyy-MM-dd");
        } else if (time.contains(".")) {
            format = new SimpleDateFormat("yyyy.MM.dd");
        } else if (time.contains("年")) {
            format = new SimpleDateFormat("yyyy年MM月dd日");
        }
        else {
            format = new SimpleDateFormat("yyyyMMdd");
        }
        return format.parse(time).getTime();
    }
}
