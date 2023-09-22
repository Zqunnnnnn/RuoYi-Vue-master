package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 维修对象 sys_fix
 * 
 * @author zq
 * @date 2023-09-20
 */
public class SysFix extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 修理单号 */
    private Long fixId;

    /** 用户号 */
    @Excel(name = "用户号")
    private Long userId;

    public void setFixId(Long fixId) 
    {
        this.fixId = fixId;
    }

    public Long getFixId() 
    {
        return fixId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fixId", getFixId())
            .append("userId", getUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
