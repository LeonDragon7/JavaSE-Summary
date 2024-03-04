package com.mysql.basics.type.date;

public class date_ {
    /*
        日期类型的基本使用
        CREATE TABLE birthday6( t1 DATE, t2 DATETIME,
        t3 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE
        CURRENT_TIMESTAMP ); timestamp时间戳
        # NOT NULL DEFAULT CURRENT TIMESTAMP ON UPDATE CURRENT TIMESTAMP 意思是没有默认值的话会根据当前时间自动更新

        mysql> INSERT INTO birthday (t1,t2)
        VALUES('2022-11-11',2022-11-11 10:10:10');

        日期类型的细节说明
        TimeStamp在Insert和update时，自动更新。

        #演示时间相关的类型
        #创建一张表, date , datetime , timestamp
        CREATE TABLE t14 (
            birthday DATE , -- 生日
            job_time DATETIME, -- 记录年月日 时分秒
            login_time TIMESTAMP
                NOT NULL DEFAULT CURRENT_TIMESTAMP
                ON UPDATE CURRENT_TIMESTAMP); -- 登录时间, 如果希望login_time列自动更新, 需要配置

        SELECT * FROM t14;
        INSERT INTO t14(birthday, job_time)
            VALUES('2022-11-11','2022-11-11 10:10:10');
        -- 如果我们更新 t14 表的某条记录，login_time列会自动的以当前时间进行更新
     */
}
