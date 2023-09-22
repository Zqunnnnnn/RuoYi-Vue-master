package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysFixMapper;
import com.ruoyi.system.domain.SysFix;
import com.ruoyi.system.service.ISysFixService;

/**
 * 维修Service业务层处理
 * 
 * @author zq
 * @date 2023-09-20
 */
@Service
public class SysFixServiceImpl implements ISysFixService 
{
    @Autowired
    private SysFixMapper sysFixMapper;

    /**
     * 查询维修
     * 
     * @param fixId 维修主键
     * @return 维修
     */
    @Override
    public SysFix selectSysFixByFixId(Long fixId)
    {
        return sysFixMapper.selectSysFixByFixId(fixId);
    }

    /**
     * 查询维修列表
     * 
     * @param sysFix 维修
     * @return 维修
     */
    @Override
    public List<SysFix> selectSysFixList(SysFix sysFix)
    {
        return sysFixMapper.selectSysFixList(sysFix);
    }

    /**
     * 新增维修
     * 
     * @param sysFix 维修
     * @return 结果
     */
    @Override
    public int insertSysFix(SysFix sysFix)
    {
        sysFix.setCreateTime(DateUtils.getNowDate());
        return sysFixMapper.insertSysFix(sysFix);
    }

    /**
     * 修改维修
     * 
     * @param sysFix 维修
     * @return 结果
     */
    @Override
    public int updateSysFix(SysFix sysFix)
    {
        sysFix.setUpdateTime(DateUtils.getNowDate());
        return sysFixMapper.updateSysFix(sysFix);
    }

    /**
     * 批量删除维修
     * 
     * @param fixIds 需要删除的维修主键
     * @return 结果
     */
    @Override
    public int deleteSysFixByFixIds(Long[] fixIds)
    {
        return sysFixMapper.deleteSysFixByFixIds(fixIds);
    }

    /**
     * 删除维修信息
     * 
     * @param fixId 维修主键
     * @return 结果
     */
    @Override
    public int deleteSysFixByFixId(Long fixId)
    {
        return sysFixMapper.deleteSysFixByFixId(fixId);
    }
}
