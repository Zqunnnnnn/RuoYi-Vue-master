package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysFix;

/**
 * 维修Mapper接口
 * 
 * @author zq
 * @date 2023-09-20
 */
public interface SysFixMapper 
{
    /**
     * 查询维修
     * 
     * @param fixId 维修主键
     * @return 维修
     */
    public SysFix selectSysFixByFixId(Long fixId);

    /**
     * 查询维修列表
     * 
     * @param sysFix 维修
     * @return 维修集合
     */
    public List<SysFix> selectSysFixList(SysFix sysFix);

    /**
     * 新增维修
     * 
     * @param sysFix 维修
     * @return 结果
     */
    public int insertSysFix(SysFix sysFix);

    /**
     * 修改维修
     * 
     * @param sysFix 维修
     * @return 结果
     */
    public int updateSysFix(SysFix sysFix);

    /**
     * 删除维修
     * 
     * @param fixId 维修主键
     * @return 结果
     */
    public int deleteSysFixByFixId(Long fixId);

    /**
     * 批量删除维修
     * 
     * @param fixIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysFixByFixIds(Long[] fixIds);
}
