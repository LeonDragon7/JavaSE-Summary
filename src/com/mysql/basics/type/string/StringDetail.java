package com.mysql.basics.type.string;

public class StringDetail {
    /*
        1.细节1
        · char(4) //这个4表示字符数(最大255)，不是字节数,不管是中文还是字母都是放四个,按字符计算.
        · varchar(4) //这个4表示字符数，不管是字母还是中文都以定义好的表的编码来存放数据
        · 不管是中文还是英文字母，都是最多存放4个，是按照字符来存放的.

        2.细节2
        · char(4)是定长(固定的大小)，就是说，即使你插入'aa'，也会占用分配的4个字符的空间.
        · varchar(4)是变长(变化的大小)，就是说，如果你插入了'aa',实际占用空间大小并不是4个字符，
        而是按照实际占用空间来分配(说明:varchar本身还需要占用1-3个字节来记录存放内容长度) L(实际数据大小)+(1-3)字节

        3.细节3
        什么时候使用char，什么时候使用varchar
        1.如果数据是定长,推荐使用char,比如md5的密码,邮编,手机号,身份证号码等. char(32) 查询速度: char > varchar
        2.如果一个字段的长度是不确定,我们使用varchar ,比如留言,文章

        4.细节4
        在存放文本时，也可以使用Text数据类型。可以将TEXT列视为VARCHAR列，注意Text 不能有默认值。大小0-2^16字节。
        如果希望存放更多字符，可以选择 MEDIUMTEXT 0O-2^24 或者LONGTEXT 0~2^32

        #演示字符串类型的使用细节
        #char(4) 和 varchar(4) 这个4表示的是字符，而不是字节, 不区分字符是汉字还是字母
        CREATE TABLE t11(
            `name` CHAR(4));
        INSERT INTO t11 VALUES('你好你好');

        SELECT * FROM t11;

        CREATE TABLE t12(
            `name` VARCHAR(4));
        INSERT INTO t12 VALUES('你好你好');
        INSERT INTO t12 VALUES('ab北京');
        SELECT * FROM t12;

        #如果varchar 不够用，可以考试使用mediumtext 或者longtext,
        #如果想简单点，可以使用直接使用text
        CREATE TABLE t13( content TEXT, content2 MEDIUMTEXT , content3 LONGTEXT);
        INSERT INTO t13 VALUES('你好你教育', '你好你教育100', '你好你教育1000~~');
        SELECT * FROM t13;
     */
}
