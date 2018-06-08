package com.scy.wechat.service;

import com.scy.wechat.po.Area;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名： AreaService <br>
 * 描述：TODO <br>
 * 创建日期： 2018/3/25 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public interface AreaService {

    List<Area> listArea();

    Area getAreaByAreaId(int areaId);

    boolean saveArea(Area area);

    boolean updateArea(Area area);

    boolean deleteAreaByAreaId(int areaId);
}
