package com.breakman.cloud.utils;

import org.apache.commons.lang.StringUtils;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 通用工具类.
 * </p>
 *
 * @author hzhang
 */
public class CommonUtil {

    /**
     * The Constant yyyy-MM-dd.
     */
    public static final String DATE_FMT_YMD = "yyyy-MM-dd";

    /**
     * The Constant yyyy-MM-dd.
     */
    public static final String DATE_FMT_MD = "MM-dd";

    /**
     * The Constant yyyy-MM-dd HH:mm:ss.
     */
    public static final String DATE_FMT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * The Constant yyyy年MM月dd日.
     */
    public static final String DATE_FMT_YMD_CN = "yyyy年MM月dd日";

    /**
     * The Constant yyyy年MM月dd日 HH:mm:ss.
     */
    public static final String DATE_FMT_YMDHMS_CN = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * The Constant String[] for a-z and A-Z.
     */
    private static String[] chars = new String[]{"2", "3", "4", "5", "6", "7", "8",
        "9", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T",
        "U", "V", "W", "X", "Y", "Z"};

    /**
     * <p>
     * 生成短8位UUID.
     * </p>
     *
     * @return
     */
    public static String generateShortUuid() {
        StringBuffer sb = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            sb.append(chars[x % 0x1F]);
        }
        return sb.toString();
    }

    /**
     * 获得uuid转为16进制的8位hash
     *
     * @return
     */
    public static String getUUIDHexHash() {
        return Integer.toHexString(UUID.randomUUID().hashCode());
    }

    /**
     * <p>
     * 生成UUID.
     * </p>
     *
     * @return
     */
    public static String generateUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * <p>
     * 根据用户名生成用户ID.
     * </p>
     *
     * @param username 用户名
     * @return
     */
    public static String generateUserId(String username) {
        String uuid = UUID.nameUUIDFromBytes(username.getBytes()).toString();
        return uuid.replaceAll("-", "");
    }

    /**
     * <p>
     * 生成4位验证码.
     * </p>
     *
     * @return
     */
    public static String getForRand() {
        String str = "0,1,2,3,4,5,6,7,8,9";
        String str2[] = str.split(",");
        Random rand = new Random();
        int index = 0;
        String randStr = "";
        for (int i = 0; i < 4; ++i) {
            index = rand.nextInt(str2.length - 1);
            randStr += str2[index];
        }
        return randStr;
    }

    /**
     * <p>
     * 将字符串转为时间类.
     * </p>
     *
     * @param dateTime 字符串所表示的时间
     * @param format   字符串所表示的时间格式 {@link CommonUtil#DATE_FMT_YMD};
     *                 {@link CommonUtil#DATE_FMT_YMD_CN};
     *                 {@link CommonUtil#DATE_FMT_YMDHMS};
     *                 {@link CommonUtil#DATE_FMT_YMDHMS_CN}
     * @return 根据指定格式, 转成的时间类.失败为空.
     * 通用层的异常
     */
    public static Date strToDate(final String dateTime, final String format) {

        Date date = null;
        DateFormat df = new SimpleDateFormat(format);
        try {
            date = df.parse(dateTime);
        } catch (ParseException e) {
            new Exception(e.getMessage());
        }
        return date;
    }

    /**
     * <p>
     * 将时间类转为字符串.
     * </p>
     *
     * @param date   需要转换的时间类
     * @param format 需要转成的时间格式 {@link CommonUtil#DATE_FMT_YMD};
     *               {@link CommonUtil#DATE_FMT_YMD_CN};
     *               {@link CommonUtil#DATE_FMT_YMDHMS};
     *               {@link CommonUtil#DATE_FMT_YMDHMS_CN}
     * @return 指定格式的时间型文字
     */
    public static String dateToStr(final Date date, final String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * <p>
     * 获得YYYY-MM-dd HH:mm:ss 格式的日期.
     * </p>
     *
     * @param date
     * @return
     */
    public static String getYYYYMMddHHmmss(Date date) {
        return dateToStr(date, DATE_FMT_YMDHMS);
    }

    /**
     * <p>
     * 获得YYYY-MM-dd 格式的日期.
     * </p>
     *
     * @param date
     * @return
     */
    public static String getYYYYMMdd(Date date) {
        return dateToStr(date, DATE_FMT_YMD);
    }

    /**
     * <p>
     * 字符串转string.
     * </p>
     *
     * @param str
     * @return
     */
    public static int string2Int(String str) {
        int r = 0;
        try {
            if (StringUtils.isNotBlank(str)) {
                r = Integer.valueOf(str);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * <p>
     * 字符串转Long.
     * </p>
     *
     * @param str
     * @return
     */
    public static Long string2Long(String str) {
        Long r = 0L;
        try {
            if (StringUtils.isNotBlank(str)) {
                r = Long.valueOf(str);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return r;
    }

    /**
     * <p>
     * 获取web项目根路径.
     * </p>
     *
     * @param request
     * @return
     */
/*	public static String getWebRoot(HttpServletRequest request) {
        return request.getServletContext().getRealPath("/");
	}*/

    /**
     * <p>
     * 获得请求路径
     * </p>
     *
     * @param request
     * @return 请求路径
     */
/*	public static String getHost(HttpServletRequest request) {
        int port = request.getServerPort();
		String portStr = StringUtils.EMPTY;
		if (port != 80) {
			portStr = String.valueOf(port);
		}
		return request.getScheme() + "://" + request.getServerName() + ":" + portStr + request.getContextPath();
	}*/

    /**
     * <p>
     * 获得MD5值.
     * </p>
     *
     * @param s 待转换字符串
     * @return
     */
    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 验证时间字符串格式输入是否正确 YYYY-MM-dd hh:mm:ss
     *
     * @param timeStr 字符串时间
     * @return true/false
     */
    public static boolean valiDateTimeWithLongFormat(String timeStr) {
        if (StringUtils.isBlank(timeStr)) {
            return false;
        }
        String format = "^([1-9][0-9]{3})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) "
            + "([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(timeStr);
        return matcher.matches();
    }

    /**
     * 判断时间是否在同一个月
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return boolean
     */
    public static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
            .get(Calendar.YEAR);

        return isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }

    /**
     * 判断两个日期是否为同一天
     *
     * @param dateA 时间A
     * @param dateB 时间B
     * @return boolean
     */
    public static boolean areSameDay(Date dateA, Date dateB) {
        Calendar calDateA = Calendar.getInstance();
        calDateA.setTime(dateA);

        Calendar calDateB = Calendar.getInstance();
        calDateB.setTime(dateB);

        return calDateA.get(Calendar.YEAR) == calDateB.get(Calendar.YEAR)
            && calDateA.get(Calendar.MONTH) == calDateB.get(Calendar.MONTH)
            && calDateA.get(Calendar.DAY_OF_MONTH) == calDateB.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前年第一天日期
     *
     * @return
     */
    public static Date getCurrYearFirst() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, currentYear);
        return calendar.getTime();
    }

    /**
     * 当前时间加30天
     *
     * @return
     */
    public static Date getThirtyDay() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +30);//+1今天的时间加一天
        date = calendar.getTime();
        return date;
    }


    /**
     * 获取过去 intervals 天的日期
     *
     * @param intervals intervals天内
     * @return ArrayList 过去几天日期数组
     */
    public static ArrayList<String> getPastDate(int intervals, String formatDate) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = intervals; i >= 1; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);
            Date today = calendar.getTime();
            pastDaysList.add(dateToStr(today, formatDate));
        }
        return pastDaysList;
    }


    /**
     * 获取未来 intervals 天的日期
     *
     * @param intervals intervals
     * @return ArrayList 未来几天日期数组
     */
    public static ArrayList<String> getFetureDate(int intervals, String formatDate) {
        ArrayList<String> fetureDaysList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i <= intervals; i++) {
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
            Date today = calendar.getTime();
            fetureDaysList.add(dateToStr(today, formatDate));
        }
        return fetureDaysList;
    }

    /**
     * 判断日期是否相等
     *
     * @param d1
     * @param d2
     * @return
     */
    private static boolean sameDate(Date d1, Date d2) {
        LocalDate localDate1 = ZonedDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = ZonedDateTime.ofInstant(d2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return localDate1.isEqual(localDate2);
    }

}
