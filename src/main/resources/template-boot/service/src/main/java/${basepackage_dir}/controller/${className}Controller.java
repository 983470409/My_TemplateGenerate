
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

package ${basepackage}.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ${basepackage}.entity.${className};
import ${basepackage}.facade.${className}Facade;
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.service.${className}Service;
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.gzhc365.${deptFlag}.common.PageBean;
import com.gzhc365.cloud.commons.api.ApiResult;
/**
 <#include "/java_description.include">
 */
@RestController
@RequestMapping("/")
public class ${className}Controller {

    private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);
   
    @Autowired
    private ${className}Service ${classNameLower}Service;

    @RequestMapping(value="${classNameLower}/get${className}s")
    public ApiResult<List<${className}>> get${className}s(@RequestBody ${className}Vo ${classNameLower}Vo) throws Exception {
        logger.info("接收的参数为 {} " ,JSONObject.toJSON(${classNameLower}Vo));
        return  new  ApiResult<>(${classNameLower}Service.get${className}sBy(${classNameLower}Vo));
    }

    @RequestMapping(value="${classNameLower}/get${className}ById")
    public ApiResult<${className}> get${className}ById( @RequestParam("id") long id) throws Exception {
        return new  ApiResult<>(${classNameLower}Service.getById(id));
    }

    @RequestMapping(value="${classNameLower}/get${className}")
    public ApiResult<${className}> get${className} (@RequestBody ${className}Vo ${classNameLower}Vo) throws Exception {
        logger.info(" ${classNameLower}/get${className} 接收的参数为 {} " ,JSONObject.toJSON( ${classNameLower}Vo));
        return  new  ApiResult<>(${classNameLower}Service.get${className}By(${classNameLower}Vo));
    }

    @RequestMapping(value="${classNameLower}/save")
    public ApiResult<${className}> save(@RequestBody ${className}Vo ${classNameLower}Vo)  throws Exception {
        logger.info("${classNameLower}/save 接收的参数为 {} " ,JSONObject.toJSON(${classNameLower}Vo));
        ${className} ${classNameLower} = new ${className}();
        BeanUtils.copyProperties(${classNameLower}, ${classNameLower}Vo);
        return new  ApiResult<>( ${classNameLower}Service.save(${classNameLower}));
    }

    @RequestMapping(value="${classNameLower}/update")
    public ApiResult<${className}> update(@RequestBody ${className}Vo ${classNameLower}Vo) throws Exception {
        
        logger.info(" ${classNameLower}/update 接收的参数为 {} " ,JSONObject.toJSON(${classNameLower}Vo));
        ${className} ${classNameLower} = new ${className}();
        BeanUtils.copyProperties(${classNameLower}, ${classNameLower}Vo);
        return new  ApiResult<>(${classNameLower}Service.update(${classNameLower}));
    }

    @RequestMapping(value="${classNameLower}/listPage")
    public ApiResult<PageBean<${className}>> listPage(@RequestBody ${className}Vo ${classNameLower}Vo) throws Exception {
        logger.info("${classNameLower}/listPage 接收的参数为 {} " ,JSONObject.toJSON(${classNameLower}Vo));
        return new  ApiResult<>((PageBean<${className}>)${classNameLower}Service.listPage(${classNameLower}Vo));
    }

}
