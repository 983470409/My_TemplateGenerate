
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.facade;

import com.gzhc365.${deptFlag}.common.vo.PageBean;
import com.gzhc365.${deptFlag}.common.BaseResult;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.List;
import ${basepackage}.entity.${className};
import ${basepackage}.dto.*;
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

            public BaseResult<List<${className}>> get${className}s(${className}ListDto ${classNameLower}ListDto){
                return BaseResult.error("服务繁忙，请稍候再试");
            }

            public BaseResult<${className}> get${className}ById(long id) {
                return BaseResult.error("服务繁忙，请稍候再试");
            }

            public BaseResult<${className}> save(${className}AddDto ${classNameLower}AddDto){
                return BaseResult.error("服务繁忙，请稍候再试");
            }

            public BaseResult<Integer> update(${className}UptDto ${classNameLower}UptDto){
                return BaseResult.error("服务繁忙，请稍候再试");
            }

            public BaseResult<Integer> delete(${className}DelDto ${classNameLower}DelDto){
                return BaseResult.error("服务繁忙，请稍候再试");
            }

            public BaseResult<PageBean<${className}>> listPage(${className}PageDto ${classNameLower}PageDto){
                return BaseResult.error("服务繁忙，请稍候再试");
            }

            public BaseResult<Integer> deleteById(long id) {
                return BaseResult.error("服务繁忙，请稍候再试");
            }

            public BaseResult<${className}> get${className}(${className}GetDto ${classNameLower}GetDto){
                return BaseResult.error("服务繁忙，请稍候再试");
            }

        };

    }



}
