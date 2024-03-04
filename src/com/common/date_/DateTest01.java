package com.common.date_;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
    想要根据给定日期及周数制作一个工作日历，具备如下3个功能。
    功能1: 需制作一个工作日历。给定指定日期与持续周数n，将以指定日期所在周的星期一开始，生成一个长达n周的工作日历(包括最后一会周的星期日)。输出该工作日历的起止日期及星期。
    功能2: 输入日期，判断该日期是否在工作日历内。如果在，则输出该日期在工作日历的第几周的星期几，离工作日历结束还剩多少周、多少天。
    功能3: 输入周次，可以将该周所在月的日历打印出来，并将该周的起止日期输出。如果跨月，可以将两个月的日历输出。
    建议使用LocalDate类完成。

    输入格式:
    测试类型(int)。输入1，只测试功能1；输入2，测试功能1、2(日期不在工作日历内)；输入3，测试全部功能。
    工作日历的开始日期(可以不是周一)
    工作日历持续周数
    要查询的日期q
    要查询的周次w

    输出格式:
    工作日历的起止日期及星期
    q所在周次及星期几.如果不在,则提示"q不在工作日历规定日期内".
    q离工作日历还剩多少周、多少天。
    输出w所在月的日历,如果跨月则输出两个月的日历.日历中的一天占3位，右对齐。
    注意:所有标点符号都是英文,行尾均无空格.
 */
public class DateTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//输入测试类型
        //获取起始日期
        LocalDate start = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());

        while (true) {
            //读取需要查询的周次
            int week = sc.nextInt();
            int weekDay = start.getDayOfWeek().getValue(); //获取当前日期是星期几
            int value = weekDay - 1; //查找当前是星期几
            LocalDate startDay = start.minusDays(value); //获取工作日历的初始日期
            LocalDate endDay = datePrint(startDay, week);//获取工作日历的结束日期
            if (n < 2) {//如果n小于2，退出
                break;
            }
            //读取需要查询的日期
            int queryYear = sc.nextInt();//年
            int queryMonth = sc.nextInt();//月
            int queryDay = sc.nextInt();//日
            LocalDate queryDate = LocalDate.of(queryYear, queryMonth, queryDay);//创建查询日期的时间

            //查询指定日期属于工作日历的哪一周，并输出结果
            queryWeekday(startDay, week, queryDate, endDay);
            //打印月历
            if(n<3){//小于3，退出
                break;
            }
            int queryWeek = sc.nextInt();
            printMonthCalendar(startDay, queryWeek, week);
            break;
        }
    }

    // 计算起始日期和周数确定的工作日历的结束日期，并输出工作日历范围
    public static LocalDate datePrint(LocalDate start, int week) {
        LocalDate endDay = start.plusWeeks(week).minusDays(1); //获取结束日期
        System.out.printf("工作日历:%s %s至%s %s\n", start, start.getDayOfWeek(), endDay, endDay.getDayOfWeek());
        return endDay; //返回结束日期
    }
    // 查询指定日期属于工作日历的哪一周，并输出结果
    public static void queryWeekday(LocalDate startDate, int numOfWeeks, LocalDate queryDate, LocalDate endDate) {
        if (queryDate.isBefore(startDate) || queryDate.isAfter(startDate.plusWeeks(numOfWeeks).minusDays(1))) {
            System.out.println(queryDate + "不在工作日历规定范围内");
            return;
        }//判断是否在工作日历规定范围内
        long weeks = ChronoUnit.DAYS.between(startDate, queryDate) / 7 + 1;//查询当前时间还有多久到工作日历末
        System.out.printf("%s在第%d周的星期%d\n", queryDate, weeks, queryDate.getDayOfWeek().getValue());
        System.out.printf("离工作日历结束还剩%s周,%d天\n", ChronoUnit.DAYS.between(queryDate, endDate) / 7, ChronoUnit.DAYS.between(queryDate, endDate));
    }
    // 打印单个月份的日历
    public static void printSingleMonthCalendar(int year, int month) {
        LocalDate startDay = LocalDate.of(year, month, 1);
        System.out.printf("%d年%02d月日历\n", year, month);
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        //计算起始日期前面的空白部分
        int padding = startDay.getDayOfWeek().getValue();

        //输出起始日期前面的空白部分
        int cnt = 1;
        for (int i = 1; i < padding; i++) {
            if (i >= 1) {
                System.out.print(" ");
            }
            System.out.print("   ");
        }

        System.out.printf("%3d", 1);
        if (padding == 7) {//打印1号的日期
            cnt = 0;
            System.out.println();
        }
        for (int day = 2; day <= startDay.lengthOfMonth(); day++) {//打印其余天的日期
            if (cnt > 0) {
                System.out.printf("%4d", day);
            } else {
                System.out.printf("%3d", day);
            }
            cnt++;
            if (startDay.plusDays(day - 1).getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
                cnt = 0;
            }
        }
        System.out.println();
    }

    public static void printMonthCalendar(LocalDate startDate, int queryWeek, int week) {
        LocalDate startWeek = startDate.plusWeeks(queryWeek - 1);
        LocalDate endWeek = startWeek.plusWeeks(1).minusDays(1);
        System.out.printf("第%d周的起始日期为%s,结束日期为%s\n", queryWeek, startWeek, endWeek);

        int startMonth = startWeek.getMonthValue(); // 获取工作日历起始月份
        int endMonth = endWeek.getMonthValue(); // 获取工作日历结束月份
        int startYear = startWeek.getYear(); // 获取工作日历起始年份
        int endYear = endWeek.getYear(); // 获取工作日历结束年份

        if (startMonth == endMonth && startYear == endYear) { // 如果工作日历起止月份相同
            printSingleMonthCalendar(startYear, startMonth); // 直接打印该月份的日历
        } else { // 如果工作日历起止月份不同
            printSingleMonthCalendar(startYear, startMonth); // 打印起始月份的日历
            printSingleMonthCalendar(endYear, endMonth); // 打印结束月份的日历
        }
    }
}
