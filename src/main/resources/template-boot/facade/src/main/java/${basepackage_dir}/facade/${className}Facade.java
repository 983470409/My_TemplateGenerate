<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.facade;

import com.gzhc365.ehis.core.vo.BaseFacadeParam;
import com.gzhc365.ehis.core.vo.PageBean;
import com.gzhc365.ehis.core.vo.PageParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import ${basepackage}.entity.${className};
import ${basepackage}.vo.${className}Param;


/**
 * Description: ${className}接口
 * @author zihong
 * @version 1.0
 * @since JDK 1.7
 */
@FeignClient("${application}")
public interface ${className}Facade {
   
    @RequestMapping(value="${classNameLower}/get${className}s", method = RequestMethod.GET)
    public BaseResult<List<${className}>> get${className}s(@RequestBody ${className}Param ${classNameLower}Param );
      

    @RequestMapping(value="${classNameLower}/get${className}ById", method = RequestMethod.GET)
    public BaseResult<${className}> get${className}ById(@RequestParam("id") long id) ;

    @RequestMapping(value="${classNameLower}/get${className}", method = RequestMethod.GET)
    public BaseResult<${className}> get${className}(@RequestBody ${className}Param ${classNameLower}Param);

    @RequestMapping(value="${classNameLower}/save", method = RequestMethod.GET)
    public BaseResult<${className}> save(@RequestBody ${className}Param ${classNameLower}Param) ;

    @RequestMapping(value="${classNameLower}/update", method = RequestMethod.GET)
    public BaseResult<${className}> update(@RequestBody ${className}Param ${classNameLower}Param );

    @RequestMapping(value="${classNameLower}/listPage", method = RequestMethod.GET)
    public BaseResult<PageBean<${className}>> listPage(@RequestBody PageParam pageParam);
}
