
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.facade;

import com.gzhc365.${deptFlag}.common.PageBean;
import org.springframework.cloud.openfeign.FeignClient;
import com.gzhc365.cloud.commons.api.ApiParam;
import com.gzhc365.cloud.commons.api.ApiResult;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.List;
import ${basepackage}.entity.${className};
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.facade.${className}Facade;


/**
 <#include "/java_description.include">
 */
@Component
public class ${className}FacadeFallback implements FallbackFactory<${className}Facade>{

    private static final Logger logger = LoggerFactory.getLogger(${className}FacadeFallback.class);

    @Override
    public ${className}Facade create(Throwable cause) {

        logger.warn("fallback reason was: {} ", cause.getMessage());

        return new ${className}Facade() {

            public ApiResult<List<${className}>> get${className}s(${className}ListDto ${classNameLower}ListDto){
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            public ApiResult<${className}> get${className}ById(long id) {
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            public ApiResult<${className}> save(${className}AddDto ${classNameLower}AddDto){
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            public ApiResult<${className}> update(${className}UptDto ${classNameLower}UptDto){
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            public ApiResult<${className}> delete(${className}DelDto ${classNameLower}DelDto){
                return ApiResult.error("服务繁忙，请稍候再试");
            }

            public ApiResult<PageBean<${className}>> listPage(${className}PageDto ${classNameLower}PageDto){
                return ApiResult.error("服务繁忙，请稍候再试");
            }
        };

    }



}
