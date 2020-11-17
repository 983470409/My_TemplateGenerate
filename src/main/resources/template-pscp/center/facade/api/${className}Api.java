
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.facade.api;

import com.gzhc365.cloud.commons.api.ApiResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import ${basepackage}.entity.${className};
import ${basepackage}.vo.${className}Vo;
import com.gzhc365.${deptFlag}.common.PageBean;

/**
 <#include "/java_description.include">
 */
public interface ${className}Api{

    /**
     * 获得数据列表
     * @param ${classNameLower}ListDto
     * @return
     */
    @RequestMapping(value="${classNameLower}/get${className}s",  method = { RequestMethod.POST })
    public ApiResult<List<${className}>> get${className}s(@RequestBody ${className}ListDto ${classNameLower}ListDto);

    /**
     * 根据id获得数据
     * @param id
     * @return
     */
    @RequestMapping(value="${classNameLower}/get${className}ById",  method = { RequestMethod.POST })
    public ApiResult<${className}> get${className}ById(@RequestParam("id") long id);

    /**
     * 新增数据
     * @param  ${classNameLower}AddDto
     * @return
     */
    @RequestMapping(value="${classNameLower}/save",  method = { RequestMethod.POST })
    public ApiResult<${className}> save(@RequestBody ${className}AddDto ${classNameLower}AddDto);

    /**
     * 更新数据
     * @param  ${classNameLower}UpdDto
     * @return
     */
    @RequestMapping(value="${classNameLower}/update",  method = { RequestMethod.POST })
    public ApiResult<${className}> update(@RequestBody ${className}UpdDto ${classNameLower}UpdDto);

    /**
     * 删除数据
     * @param  ${classNameLower}DelDto
     * @return
     */
    @RequestMapping(value="${classNameLower}/delete",  method = { RequestMethod.POST })
    public ApiResult<${className}> delete(@RequestBody ${className}DelDto ${classNameLower}DelDto);

    /**
     * 根据主键id删除数据
     * @param  id
     * @return
     */
    @RequestMapping(value="${classNameLower}/deleteById",  method = { RequestMethod.POST })
    public ApiResult<${className}> deleteById(@RequestParam("id") long id);

    /**
     * 分页查询
     * @param  ${classNameLower}PageDto
     * @return
     */
    @RequestMapping(value="${classNameLower}/listPage",  method = { RequestMethod.POST })
    public ApiResult<PageBean<${className}>> listPage(@RequestBody ${className}PageDto ${classNameLower}PageDto);
}
