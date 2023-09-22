package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysFix;
import com.ruoyi.system.service.ISysFixService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修Controller
 *
 * @author zq
 * @date 2023-09-20
 */
@RestController
@RequestMapping("/system/fix")
public class SysFixController extends BaseController
{
    @Autowired
    private ISysFixService sysFixService;

    /**
     * 查询维修列表
     */
    @PreAuthorize("@ss.hasPermi('system:fix:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysFix sysFix)
    {
        startPage();
        List<SysFix> list = sysFixService.selectSysFixList(sysFix);
        return getDataTable(list);
    }

    /**
     * 导出维修列表
     */
    @PreAuthorize("@ss.hasPermi('system:fix:export')")
    @Log(title = "维修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysFix sysFix)
    {
        List<SysFix> list = sysFixService.selectSysFixList(sysFix);
        ExcelUtil<SysFix> util = new ExcelUtil<SysFix>(SysFix.class);
        util.exportExcel(response, list, "维修数据");
    }

    /**
     * 获取维修详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:fix:query')")
    @GetMapping(value = "/{fixId}")
    public AjaxResult getInfo(@PathVariable("fixId") Long fixId)
    {
        return success(sysFixService.selectSysFixByFixId(fixId));
    }

    /**
     * 新增维修
     */
    @PreAuthorize("@ss.hasPermi('system:fix:add')")
    @Log(title = "维修", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysFix sysFix)
    {
        return toAjax(sysFixService.insertSysFix(sysFix));
    }

    /**
     * 修改维修
     */
    @PreAuthorize("@ss.hasPermi('system:fix:edit')")
    @Log(title = "维修", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysFix sysFix)
    {
        return toAjax(sysFixService.updateSysFix(sysFix));
    }

    /**
     * 删除维修
     */
    @PreAuthorize("@ss.hasPermi('system:fix:remove')")
    @Log(title = "维修", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fixIds}")
    public AjaxResult remove(@PathVariable Long[] fixIds)
    {
        return toAjax(sysFixService.deleteSysFixByFixIds(fixIds));
    }
}
