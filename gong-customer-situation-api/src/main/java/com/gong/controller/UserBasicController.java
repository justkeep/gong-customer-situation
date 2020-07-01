package com.gong.controller;

import com.gong.customer.situation.service.UserBasicService;
import com.seven.commons.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 59448
 * @date 2018/10/25
 */
@RestController
@RequestMapping("/web/user")
public class UserBasicController {

    @Autowired
    private UserBasicService userBasicService;

    @RequestMapping("/get-user-basic")
    public BaseResponse getUserBasic(){
        return BaseResponse.buildSuccess("gyk");

//       return BaseResponse.buildSuccess(userBasicService.searchUserBasic());
    }

    public static void main(String[] args) {

//        List<Integer> integerList = new ArrayList();
//        for (int i = 0; i < 100; i++) {
//            integerList.add(i);
//        }
//        List parallelList = new ArrayList();
//        integerList.stream().parallel().filter(i -> i % 2 == 1).forEach(i -> parallelList.add(i));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = simpleDateFormat.parse("2020-01-01");
            Date date2 = simpleDateFormat.parse("2019-12-23");
            System.out.println(differentDays(date1,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2) {  //同一年
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++) {
                if(i%4==0 && i%100!=0 || i%400==0) {   //闰年
                    timeDistance += 366;
                }
                else {   //不是闰年
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else {   //不同年
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }


    public static int differentDaysOne(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new RuntimeException("日期不能为空");
        }
        LocalDate localDate1 = date2LocalDate(date1);
        LocalDate localDate2 = date2LocalDate(date2);
        return 0;
//        return Generic.long2int(localDate1.until(localDate2, ChronoUnit.DAYS));
    }

    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }
}
