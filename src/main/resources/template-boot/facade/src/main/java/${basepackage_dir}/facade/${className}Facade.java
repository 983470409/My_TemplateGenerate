<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.facade;
import com.gzhc365.cloud.commons.api.ApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import ${basepackage}.entity.${className};
import ${basepackage}.vo.${className}Vo;


/**
 <#include "/java_description.include">
 */
@FeignClient("${application}")
public interface ${className}Facade {

    @RequestMapping(value="${classNameLower}/get${className}s", method = RequestMethod.GET)
    public ApiResult<List<${className}>> get${className}s(@RequestBody ${className}Vo ${classNameLower}Vo );


    @RequestMapping(value="${classNameLower}/get${className}ById", method = RequestMethod.GET)
    public ApiResult<${className}> get${className}ById(@RequestParam("id") long id);

    @RequestMapping(value="${classNameLower}/get${className}", method = RequestMethod.GET)
    public ApiResult<${className}> get${className}(@RequestBody ${className}Vo ${classNameLower}Vo);

    @RequestMapping(value="${classNameLower}/save", method = RequestMethod.GET)
    public ApiResult<${className}> save(@RequestBody ${className}Vo ${classNameLower}Vo) ;

    @RequestMapping(value="${classNameLower}/update", method = RequestMethod.GET)
    public ApiResult<${className}> update(@RequestBody ${className}Vo ${classNameLower}Vo );

    @RequestMapping(value="${classNameLower}/listPage", method = RequestMethod.GET)
    public ApiResult<PageBean<${className}>> listPage(@RequestBody ${className}Vo ${classNameLower}Vo);
}
