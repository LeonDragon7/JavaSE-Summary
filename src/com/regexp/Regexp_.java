package com.regexp;
/*
    为什么要学习正则表达式
    极速体验正则表达式威力
    1.提取文章中所有的英文单词
    2.提取文章中所有的数字
    3.提取文章中所有的英文单词和数字
    4.提取百度热榜标题
    结论:正则表达式是处理文本的利器
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 体验正则表达式的威力，给我们文本处理带来哪些便利
 */
public class Regexp_ {
    public static void main(String[] args) {


        //假定，编写了爬虫，从百度页面得到如下文本
//        String content = "1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的" +
//                "静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，这种程序可以通" +
//                "过网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量的" +
//                "人力、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并且" +
//                "重新审视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结" +
//                "构进行编写的，所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的" +
//                "语言，程序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以" +
//                "随同网页在网络上传输的Applet（Applet是一种将小程序嵌入到网页中进行执行的技术），" +
//                "并将Oak更名为Java（在申请注册商标时，发现Oak已经被人使用了，再想了一系列" +
//                "名字之后，最终，使用了提议者在喝一杯Java咖啡时无意提到的Java词" +
//                "语）。5月23日，Sun公司在Sun world会议上正式发" +
//                "布Java和HotJava浏览器。IBM、Apple、DEC、Adobe、HP、Oracle、Netscape和微软" +
//                "等各大公司都纷纷停止了自己的相关开发项目，竞相购买了Java使用许可证，并为自己的产" +
//                "品开发了相应的Java平台";
//        String content = "<div class=\"cr-content  new-pmd\">\n" +
//                "    \n" +
//                "<div class=\"FYB_RD\">\n" +
//                "    <div class=\"cr-title c-gap-bottom-xsmall\" title=\"百度热榜\">\n" +
//                "        <span class=\"c-color-t\">百度热榜</span>\n" +
//                "                                                <div class=\"opr-toplist1-update opr-toplist1-link\" data-click=\"{fm:'beha'}\" style=\"position:relative;top:-1px;\">\n" +
//                "                    <a class=\"OP_LOG_BTN toplist-refresh-btn c-font-normal c-color-gray2\" href=\"javascript:void(0);\" style=\"text-decoration:none;\">\n" +
//                "                        <i class=\"c-icon opr-toplist1-hot-refresh-icon\">&#xe619;</i><span>换一换</span>\n" +
//                "                    </a>\n" +
//                "                </div>\n" +
//                "                        </div>\n" +
//                "    <table class=\"c-table opr-toplist1-table\">\n" +
//                "                        <tbody >\n" +
//                "                    <tr class=\"toplist1-tr\">\n" +
//                "                                                                                                                                                                                                            \n" +
//                "                                                                                                                                                            <td class=\"toplist1-td opr-toplist1-link\">\n" +
//                "                                        <span class=\"toplist1-hot c-index-single  toplist1-hot-top toplist1-hot-0 c-index-single-hot1 \" style=\"opacity:1;\">\n" +
//                "                        1\n" +
//                "                    </span>\n" +
//                "                    <a target=\"_blank\" title=\"印度累计确诊病例已超2000万例\" href=\"/s?wd=%E5%8D%B0%E5%BA%A6%E7%B4%AF%E8%AE%A1%E7%A1%AE%E8%AF%8A%E7%97%85%E4%BE%8B%E5%B7%B2%E8%B6%852000%E4%B8%87%E4%BE%8B&rsv_idx=2&tn=baiduhome_pg&usm=3&ie=utf-8&rsv_cq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_dl=0_right_fyb_pchot_20811_01&rsv_pq=959254a60034f017&oq=%E5%91%A8%E6%98%9F%E9%A9%B0&rsv_t=abf2fwdknQ1VTZk3EzyT0N5%2FpcQzkjPt5GRZchjVdppW7k8B8oI6R5IL3T0myEMmjxXM&rsf=dd45f07d69719294a2ea6117b312f1d7_1_10_1\" class=\"c-font-medium c-color-t opr-toplist1-subtitle\">\n" +
//                "                        印度累计确诊病例已超2000万例\n" +
//                "                    </a>\n" +
//                "                                    </td>\n" +
//                "                <td class=\"toplist1-right-num toplist1-td c-color-gray\" style=\"line-height:20px;position:relative;top:2px;\">473万</td>\n" +
//                "            </tr>\n" +
//                "                                    <tr class=\"toplist1-tr\">\n" +  </tbody>    </table>\n" +
//                "    </div>";

        String content = "私有地址（Private address）属于非注册地址，专门为组织机构内部使用。\n" +
                "以下列出留用的内部私有地址\n" +
                "A类 10.0.0.0--10.255.255.255\n" +
                "B类 172.16.0.0--172.31.255.255\n" +
                "C类 192.168.0.0--192.168.255.255";

        //提取文章中所有的英文单词
        //提取文章中所有的数字
        //提取文章中所有的英文单词和数字
        //提取百度热榜 标题
        //(1). 传统方法. 使用遍历方式，代码量大，效率不高
        //(2). 正则表达式技术

        //1. 先创建一个Pattern对象 ， 模式对象, 可以理解成就是一个正则表达式对象
        //Pattern pattern = Pattern.compile("[a-zA-Z]+");
        //Pattern pattern = Pattern.compile("[0-9]+");
        //Pattern pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)");
        //Pattern pattern = Pattern.compile("<a target=\"_blank\" title=\"(\\S*)\"");

        Pattern pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
        //2. 创建一个匹配器对象
        //理解： 就是 matcher 匹配器按照 pattern(模式/样式), 到 content 文本中去匹配
        //找到就返回true, 否则就返回false
        int no = 0;
        Matcher matcher = pattern.matcher(content);
        //3. 可以开始循环匹配
        while (matcher.find()) {
            //匹配内容，文本，放到 m.group(0)
            System.out.println("找到: " + (++no) + " " +matcher.group(0));
        }
    }
}
/*
    再提出几个问题
    1.给你一个字符串(或文章).请你找出所有四个数字连在一起的子串?
    2.给你一个字符串(或文章),请你找出所有四个数字连在一起的子串,并且 这四个数字要满足:第一位与第四位相同,第二位与第三位相同,比如1221,5775
    3.请验证输入的邮件，是否符合电子邮件格式.
    4.请验证输入的手机号，是否符合手机号格式

    解决之道-正则表达式
    1.为了解决上述问题，Java提供了正则表达式技术，专门用于处理类似文本问题
    2.简单的说:正则表达式是对字符串执行模式匹配的技术。
    3.正则表达式: regular expression => RegExp

    正则表达式基本介绍
    介绍
    1.一个正则表达式，就是用某种模式去匹配字符串的一个公式。
    2.正则表达式不是只有java才有，实际上很多编程语言都支持正则表达式进行字符串操作


 */
