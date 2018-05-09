package com.my.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.utils.EUDataGridResult;
import com.my.mapper.TbItemMapper;
import com.my.pojo.TbItem;
import com.my.pojo.TbItemExample;
import com.my.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TbItemServiceImpl implements TbItemService {
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public TbItem getIteam(long itemId) {
        TbItemExample example = new TbItemExample();
        //设置分页
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> itemList = itemMapper.selectByExample(example);
        if (itemList != null && itemList.size() > 0) {
            TbItem item = itemList.get(0);
            return item;
        }
        return null;
    }
    /*
     商品列表查询
     */
    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //查询商品列表
        TbItemExample example = new TbItemExample();
        //分页处理
        PageHelper.startPage(page, rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

}
