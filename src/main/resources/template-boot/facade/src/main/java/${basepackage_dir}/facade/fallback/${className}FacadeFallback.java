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
import com.gzhc365.cloud.commons.api.ApiParam;
import com.gzhc365.cloud.commons.api.ApiResult;
import com.gzhc365.mid.customerplatform.entity.User;
import com.gzhc365.mid.customerplatform.facade.UserFacade;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import feign.hystrix.FallbackFactory;
import ${basepackage}.entity.${className};
import ${basepackage}.vo.${className}Param;


/**
 <#include "/java_description.include">
 */
@Component
public class ${className}FacadeFallback implements FallbackFactory<${className}Facade>{

    private static final Logger logger = LoggerFactory.getLogger(${className}FacadeFallback.class);

    @Override
    public ${className}Facade create(Throwable cause) {

            logger.warn("fallback reason was: {} ", cause.getMessage());

            @Override
            public ApiResult<List<${className}>> get${className}s(@RequestBody ${className}Param ${classNameLower}Param ){
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            @Override
            public ApiResult<${className}> get${className}ById(@RequestParam("id") long id) {
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            @Override
            public ApiResult<${className}> get${className}(@RequestBody ${className}Param ${classNameLower}Param){
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            @Override
            public ApiResult<${className}> save(@RequestBody ${className}Param ${classNameLower}Param){
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            @Override
            public ApiResult<${className}> update(@RequestBody ${className}Param ${classNameLower}Param ){
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            @Override
            public ApiResult<PageBean<${className}>> listPage(@RequestBody PageParam pageParam){
                return ApiResult.error("服务繁忙，请稍候再试");
            }
        };

    }



}
