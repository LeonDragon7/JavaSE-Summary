package com.mysql.strengthen;

public class SelectMerge {
    /*
        合并查询
        介绍
        有时在实际应用中，为了合并多个 select 语句的结果，可以使用集合操作符号 union , union all。
        · union all：该操作符用于取得两个结果集的并集。当使用该操作符时，不会取消重复行。
        · union：该操作赋与union all相似,但是会自动去掉结果集中重复行

                -- 合并查询
        SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
        SELECT ename,sal,job FROM emp WHERE job='MANAGER' -- 3

        -- union all 就是将两个查询结果合并，不会去重
        SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
        UNION ALL
        SELECT ename,sal,job FROM emp WHERE job='MANAGER' -- 3

        -- union  就是将两个查询结果合并，会去重
        SELECT ename,sal,job FROM emp WHERE sal>2500 -- 5
        UNION
        SELECT ename,sal,job FROM emp WHERE job='MANAGER' -- 3
     */
}
