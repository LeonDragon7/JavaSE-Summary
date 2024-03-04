package com.mysql.strengthen.subquery;

public class Temporary {
    /*
        子查询当做临时表使用
        可以将子查询当做一张临时表使用  解决复杂的查询问题
        -- 子查询练习

        -- 查询ecshop中各个类别中，价格最高的商品

        -- 查询 商品表
        -- 先得到 各个类别中，价格最高的商品 max + group by cat_id, 当做临时表
        -- 把子查询当做一张临时表可以解决很多很多复杂的查询

        select cat_id , max(shop_price)
            from ecs_goods
            group by cat_id


        -- 这个最后答案
        select goods_id, ecs_goods.cat_id, goods_name, shop_price
            from (
                SELECT cat_id , MAX(shop_price) as max_price
                FROM ecs_goods
                GROUP BY cat_id
            ) temp , ecs_goods
            where  temp.cat_id = ecs_goods.cat_id
            and temp.max_price = ecs_goods.shop_price
     */
}
