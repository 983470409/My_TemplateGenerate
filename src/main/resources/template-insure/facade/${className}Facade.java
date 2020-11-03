
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#macro url name>${r"${"}${name}${r"-URL:}"}</#macro>
package ${basepackage}.facade;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import ${basepackage}.request.*;
import ${basepackage}.vo.*;
import ${basepackage}.po.*;
import javax.validation.Valid;
/**
 <#include "/java_description.include">
 */
@FeignClient(value = "${application}", url="<@url "${application}"/>")
public interface ${className}Facade{

    /**
     * 新增
     * @param ${classNameLower}AddReq
     * @return
     */
    @RequestMapping(value="${classNameLower}/add",  method = { RequestMethod.POST })
    Long add(@Valid @RequestBody ${className}AddReq ${classNameLower}AddReq) ;

    /**
     * 删除
     * @param ${classNameLower}DeleteReq
     */
    @RequestMapping(value="${classNameLower}/delete",  method = { RequestMethod.POST })
    void delete(@Valid @RequestBody ${className}DeleteReq ${classNameLower}DeleteReq);

    /**
     * 更新
     * @param ${classNameLower}UpdateReq
     */
    @RequestMapping(value="${classNameLower}/update",  method = { RequestMethod.POST })
    void update(@Valid @RequestBody ${className}UpdateReq ${classNameLower}UpdateReq);

    /**
     * 通过筛选条件查找数据
     * @param ${classNameLower}QueryReq
     */
    @RequestMapping(value="${classNameLower}/get${className}s",  method = { RequestMethod.POST })
    public List<${className}> get${className}s(@RequestBody ${className}QueryReq ${classNameLower}QueryReq);

    /**
     * 通过主键id查找数据
     * @param id
     */
    @RequestMapping(value="${classNameLower}/get${className}ById",  method = { RequestMethod.POST })
    public ${className}Vo get${className}ById(@RequestParam("id") long id);

    /**
     * 根据筛选条件查询数据
     * @param ${classNameLower}PagingQueryVo
     */
    @RequestMapping(value="${classNameLower}/listPage",  method = { RequestMethod.POST })
    public PageBean<${className}Vo> listPage(@RequestBody ${className}PagingQueryVo ${classNameLower}PagingQueryVo);
}
