package com.scy.wechat.dao;

import com.scy.wechat.po.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类名： AreaDao <br>
 * 描述：TODO <br>
 * 创建日期： 2018/3/25 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
@Repository( value = "areaDao")
public interface AreaDao {

    List<Area> listArea();

    Area getAreaByAreaId(int areaId);

    int insertArea(Area area);

    int updateArea(Area area);

    int deleteAreaByAreaId(int areaId);
}
