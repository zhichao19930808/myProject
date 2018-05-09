package com.my.service;

import com.my.pojo.TbItem;
import com.my.utils.EUDataGridResult;

public interface TbItemService {
    /*
     * 查询单个商品的信息
     */
    TbItem getIteam(long itemId);

    /*
     * 分页查询商品列表
     */
    EUDataGridResult getItemList(int page, int rows);
}
