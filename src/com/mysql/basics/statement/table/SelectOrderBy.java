package com.mysql.basics.statement.table;

public class SelectOrderBy {
    /*
        使用order by 子句排序查询结果
        1.Order by 指定排序的列，排序的列既可以是表中的列名，也可以是select 语句后指定的列名。
        2.Asc升序[默认]、Desc降序
        3.ORDER BY子句应位于SELECT语句的结尾。

        -- 演示order by使用
        -- 对数学成绩排序后输出【升序】。
        SELECT * FROM student
            ORDER BY math;
        -- 对总分按从高到低的顺序输出 [降序] -- 使用别名排序
        SELECT `name` , (chinese + english + math) AS total_score FROM student
            ORDER BY total_score DESC;
        -- 对姓韩的学生成绩[总分]排序输出(升序) where + order by
        SELECT `name`, (chinese + english + math) AS total_score FROM student
            WHERE `name` LIKE '韩%'
            ORDER BY total_score;
     */
}
