package com.scy.wechat.dao;

import com.scy.wechat.po.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

/**
 * 类名： AreaDaoTest <br>
 * 描述：TODO <br>
 * 创建日期： 2018/3/25 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Resource(name = "areaDao")
    private AreaDao areaDao;

    @Test
    @Ignore
    public void listArea(){
        List<Area> areaList = areaDao.listArea();
       // Assert.assertEquals(2,areaList.size());
        assertEquals(2,areaList.size());
    }

    @Test
    @Ignore
    public void getAreaByAreaId(){
        Area area = areaDao.getAreaByAreaId(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea(){
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int result = areaDao.insertArea(area);
        assertEquals(1,result);
    }

    @Test
    @Ignore
    public void updateArea(){
        Area area = new Area();
        area.setAreaName("西苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int result = areaDao.updateArea(area);
        assertEquals(1,result);
    }

    @Test
    public void deleteAreaByAreaId(){
        int result = areaDao.deleteAreaByAreaId(3);
        assertEquals(1,result);
    }
}
