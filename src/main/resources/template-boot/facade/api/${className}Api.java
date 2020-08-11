
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

    @RequestMapping(value="${classNameLower}/get${className}s",  method = { RequestMethod.POST })
    public ApiResult<List<${className}>> get${className}s(@RequestBody ${className}Vo ${classNameLower}Vo );


    @RequestMapping(value="${classNameLower}/get${className}ById",  method = { RequestMethod.POST })
    public ApiResult<${className}> get${className}ById(@RequestParam("id") long id);

    @RequestMapping(value="${classNameLower}/get${className}",  method = { RequestMethod.POST })
    public ApiResult<${className}> get${className}(@RequestBody ${className}Vo ${classNameLower}Vo);

    @RequestMapping(value="${classNameLower}/save",  method = { RequestMethod.POST })
    public ApiResult<${className}> save(@RequestBody ${className}Vo ${classNameLower}Vo) ;

    @RequestMapping(value="${classNameLower}/update",  method = { RequestMethod.POST })
    public ApiResult<${className}> update(@RequestBody ${className}Vo ${classNameLower}Vo);

    @RequestMapping(value="${classNameLower}/delete",  method = { RequestMethod.POST })
    public ApiResult<${className}> delete(@RequestBody ${className}Vo ${classNameLower}Vo);

    @RequestMapping(value="${classNameLower}/listPage",  method = { RequestMethod.POST })
    public ApiResult<PageBean<${className}>> listPage(@RequestBody ${className}Vo ${classNameLower}Vo);
}
