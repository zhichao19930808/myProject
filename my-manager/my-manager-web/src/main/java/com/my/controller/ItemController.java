package com.my.controller;

import com.my.pojo.TbItem;
import com.my.service.TbItemService;
import com.my.utils.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {
    @Autowired
    private TbItemService tbItemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItem(@PathVariable Long itemId) {
        return tbItemService.getIteam(itemId);
    }

    /*
     分页展示商品信息
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows) {
        return tbItemService.getItemList(page, rows);
    }

}
