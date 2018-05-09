import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.mapper.TbItemMapper;
import com.my.pojo.TbItem;
import com.my.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PageHelperTest {
    @Test
    public void pagehelperTest() {
        //创建一个spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring中获取到mapper的代理对象
        TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
        //执行分页查询
        TbItemExample itemExample = new TbItemExample();
        //分页查询
        PageHelper.startPage(1,10);
        List<TbItem> tbItems = tbItemMapper.selectByExample(itemExample);
        //商品列表
        for (TbItem tbItem : tbItems) {
            System.out.println(tbItem.getTitle());
        }

        //获取商品信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        long total = pageInfo.getTotal();
        System.out.println("共有商品"+total);


    }
}
