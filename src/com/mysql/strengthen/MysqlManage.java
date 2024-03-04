package com.mysql.strengthen;

public class MysqlManage {
    /*
        Mysql 管理
        Mysql 用户
        mysql中的用户，都存储在系数据库mysql中user表中
        其中user表的重要字段说明:
        1.host: 允许登录的“位置”，localhost表示该用户只允许本机登录，也可以指定ip地址，比如:192.168.1.100
        2.user:用户名;
        3.authentication string:密码，是通过mysql的password()函数加密之后 的密码。

        创建用户
        create user '用户名'@'允许登录位置' identified by '密码'
        说明:创建用户，同时指定密码

        删除用户
        drop user '用户名'@'允许登录位置';

        用户修改密码
        修改自己的密码:
        set password = password('密码');

        修改他人的密码(需要有修改用户密码权限):
        set password for '用户名'@'登录位置'=password('密码');

        mysql 中的权限

        给用户授权
        基本语法:
        grant 权限列表 on 库.对象名 to '用户名'@'登录位置'【identified  by '密码'】
        说明:
        1.权限列表，多个权限用逗号分开
        grant select on .....
        grant select,delete,create on ......
        grant all [privileges] on .... //表示赋予该用户在该对象上的所有权限
        2.特别说明 *.*:代表本系统中的所有数据库的所有对象(表，视图，存储过程)
        库.*:表示某个数据库中的所有数据对象(表，视图，存储过程等)
        3.identified by可以省略，也可以写出.
        (1)如果用户存在，就是同时修改该用户的密码。
        (2)如果该用户不存在，就是创建该用户!

        回收用户授权
        基本语法:
        revoke 权限列表 on 库.对象名 from '用户名'@'登录位置';

        权限生效指令
        如果权限没有生效，可以执行下面命令，基本语法:
        FLUSH PRIVILEGES;

        -- Mysql用户的管理
        -- 原因：当我们做项目开发时，可以根据不同的开发人员，赋给他相应的Mysql操作权限
        -- 所以，Mysql数据库管理人员(root), 根据需要创建不同的用户，赋给相应的权限，供人员使用

        -- 1. 创建新的用户
        -- 解读 (1) 'hsp_edu'@'localhost' 表示用户的完整信息 'hsp_edu' 用户名 'localhost' 登录的IP
        -- (2) 123456 密码, 但是注意 存放到 mysql.user表时，是password('123456') 加密后的密码
        --     *6BB4837EB74329105EE4568DDA7DC67ED2CA2AD9
        CREATE USER 'hsp_edu'@'localhost' IDENTIFIED BY '123456'

        SELECT `host`, `user`, authentication_string
            FROM mysql.user

        -- 2. 删除用户
        DROP USER 'hsp_edu'@'localhost'

        -- 3. 登录

        -- root 用户修改 hsp_edu@localhost 密码, 是可以成功.
        SET PASSWORD FOR 'hsp_edu'@'localhost' = PASSWORD('123456')

        用户管理练习题
        1.创建一个用户(你的名字，拼音)，密码123，并且只可以从本地登录，不让远程登录mysql
        2.创建库和表testdb下的news表,要求:使用root用户创建
        3.给用户分配查看news表和添加数据的权限
        4.测试看看用户是否只有这几个权限
        5.修改密码为abc ,要求:使用root用户完成
        6.重新登录
        7.使用root 用户删除你的用户
        -- 演示 用户权限的管理

        -- 创建用户 shunping  密码 123 , 从本地登录
        CREATE USER 'shunping'@'localhost' IDENTIFIED BY '123'

        -- 使用root 用户创建 testdb  ,表 news
        CREATE DATABASE testdb
        CREATE TABLE news (
            id INT ,
            content VARCHAR(32));
        -- 添加一条测试数据
        INSERT INTO news VALUES(100, '北京新闻');
        SELECT * FROM news;

        -- 给 shunping 分配查看 news 表和 添加news的权限
        GRANT SELECT , INSERT
            ON testdb.news
            TO 'shunping'@'localhost'

        -- 可以增加update权限
        GRANT UPDATE
            ON testdb.news
            TO 'shunping'@'localhost'


        -- 修改 shunping的密码为 abc
        SET PASSWORD FOR 'shunping'@'localhost' = PASSWORD('abc');

        -- 回收 shunping 用户在 testdb.news 表的所有权限
        REVOKE SELECT , UPDATE, INSERT ON testdb.news FROM 'shunping'@'localhost'
        REVOKE ALL ON testdb.news FROM 'shunping'@'localhost'

        -- 删除 shunping
        DROP USER 'shunping'@'localhost'

        细节说明
        1.在创建用户的时候，如果不指定Host,则为%，%表示表示所有IP都有连接权限
        create user XX;
        2.你也可以这样指定 create user 'xxx'@'192.168.1.%' 表示xx用户在 192.168.1.* 的ip可以登录mysql
        3.在删除用户的时候，如果 host 不是%, 需要明确指定‘用户'@'host值'
        -- 说明 用户管理的细节
        -- 在创建用户的时候，如果不指定Host, 则为% , %表示表示所有IP都有连接权限
        -- create user  xxx;

        CREATE USER jack

        SELECT `host`, `user` FROM mysql.user

        -- 你也可以这样指定
        -- create user  'xxx'@'192.168.1.%'  表示 xxx用户在 192.168.1.*的ip可以登录mysql

        CREATE USER 'smith'@'192.168.1.%'

        -- 在删除用户的时候，如果 host 不是 %, 需要明确指定  '用户'@'host值'

        DROP USER jack -- 默认就是 DROP USER 'jack'@'%'

        DROP USER 'smith'@'192.168.1.%'
     */
}
