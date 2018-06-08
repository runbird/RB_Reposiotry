package com.scy.wechat.service.serviceImpl;

import com.scy.wechat.dao.AreaDao;
import com.scy.wechat.po.Area;
import com.scy.wechat.service.AreaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 类名： AreaServiceImpl <br>
 * 描述：TODO <br>
 * 创建日期： 2018/3/25 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
@Service(value = "areaService")
public class AreaServiceImpl implements AreaService {

    @Resource(name = "areaDao")
    private AreaDao areaDao;

    @Override
    public List<Area> listArea() {
        return areaDao.listArea();
    }

    @Override
    public Area getAreaByAreaId(int areaId) {
        return areaDao.getAreaByAreaId(areaId);
    }

    @Override
    //@Transactional(rollbackFor = Exception.class)
    @Transactional //采用默认的异常处理
    public boolean saveArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int result = areaDao.insertArea(area);
                if (result > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }

    }

    @Override
    public boolean updateArea(Area area) {
        if (area.getAreaName() != null && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());
            try {
                int result = areaDao.updateArea(area);
                if (result > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }

    }

    @Override
    public boolean deleteAreaByAreaId(int areaId) {
        if (areaId > 0) {
            try {
                int result = areaDao.deleteAreaByAreaId(areaId);
                if (result > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }
}
