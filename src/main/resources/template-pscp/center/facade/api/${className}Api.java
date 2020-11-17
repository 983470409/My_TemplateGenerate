
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
import ${basepackage}.dto.*;
import com.gzhc365.${deptFlag}.common.vo.PageBean;

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
    ApiResult<List<${className}>> get${className}s(@RequestBody ${className}ListDto ${classNameLower}ListDto);

    /**
     * 根据id获得数据
     * @param id
     * @return
     */
    @RequestMapping(value="${classNameLower}/get${className}ById",  method = { RequestMethod.POST })
    ApiResult<${className}> get${className}ById(@RequestParam("id") long id);

    /**
     * 新增数据
     * @param  ${classNameLower}AddDto
     * @return
     */
    @RequestMapping(value="${classNameLower}/save",  method = { RequestMethod.POST })
    ApiResult<${className}> save(@RequestBody ${className}AddDto ${classNameLower}AddDto);

    /**
     * 更新数据
     * @param  ${classNameLower}UptDto
     * @return
     */
    @RequestMapping(value="${classNameLower}/update",  method = { RequestMethod.POST })
    ApiResult<Integer> update(@RequestBody ${className}UptDto ${classNameLower}UptDto);

    /**
     * 删除数据
     * @param  ${classNameLower}DelDto
     * @return
     */
    @RequestMapping(value="${classNameLower}/delete",  method = { RequestMethod.POST })
    ApiResult<Integer> delete(@RequestBody ${className}DelDto ${classNameLower}DelDto);

    /**
     * 根据主键id删除数据
     * @param  id
     * @return
     */
    @RequestMapping(value="${classNameLower}/deleteById",  method = { RequestMethod.POST })
    ApiResult<Integer> deleteById(@RequestParam("id") long id);

    /**
     * 分页查询
     * @param  ${classNameLower}PageDto
     * @return
     */
    @RequestMapping(value="${classNameLower}/listPage",  method = { RequestMethod.POST })
    ApiResult<PageBean<${className}>> listPage(@RequestBody ${className}PageDto ${classNameLower}PageDto);
}