<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

package ${basepackage}.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gzhc365.ehis.core.utils.Utils;


import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gzhc365.ehis.core.vo.PageParam;
import com.gzhc365.ehis.core.vo.PageBean;


import ${basepackage}.entity.${className};
import ${basepackage}.facade.${className}Facade;
import ${basepackage}.vo.${className}Param;

import ${basepackage}.service.${className}Service;


@RestController
@RequestMapping("/")
public class ${className}Controller {
    private static Logger logger = LoggerFactory.getLogger(${className}Controller.class);
    
   
    @Autowired
    private ${className}Service ${classNameLower}Service;

    @RequestMapping(value="${classNameLower}/get${className}s")
    public BaseResult<List<${className}>> get${className}s(@RequestBody ${className}Param param ) throws Exception {
        logger.info("接收的参数为 {} " ,JSONObject.toJSON(param));
        ${className} t = new ${className}();
        PropertyUtils.copyProperties(t, param);
        return  new  BaseResult<> (${classNameLower}Service.get${className}sBy(t));
    }

    @RequestMapping(value="${classNameLower}/get${className}ById")
    public BaseResult<${className}> get${className}ById( @RequestParam("id") long id) throws Exception {
        return new  BaseResult<> (${classNameLower}Service.getById(id));
    }

    @RequestMapping(value="${classNameLower}/get${className}")
    public BaseResult<${className}> get${className} (@RequestBody ${className}Param param) throws Exception {
        
        logger.info(" ${classNameLower}/get${className} 接收的参数为 {} " ,JSONObject.toJSON(param));
        ${className} t = new ${className}();
        PropertyUtils.copyProperties(t, param);
        return  new  BaseResult<> (${classNameLower}Service.get${className}By(t));
    }

    @RequestMapping(value="${classNameLower}/save")
    public BaseResult<${className}> save(@RequestBody ${className}Param param)  throws Exception {
        
        logger.info("${classNameLower}/save 接收的参数为 {} " ,JSONObject.toJSON(param));
        ${className} t = new ${className}();
        PropertyUtils.copyProperties(t, param);
        return new  BaseResult<> ( ${classNameLower}Service.save(t));
    }

    @RequestMapping(value="${classNameLower}/update")
    public BaseResult<${className}> update(@RequestBody ${className}Param param) throws Exception {
        
        logger.info(" ${classNameLower}/update 接收的参数为 {} " ,JSONObject.toJSON(param));
        ${className} t = new ${className}();
        PropertyUtils.copyProperties(t, param);
        return new  BaseResult<> (${classNameLower}Service.update(t));
    }

    @RequestMapping(value="${classNameLower}/listPage")
    public BaseResult<PageBean<${className}>> listPage(@RequestBody PageParam pageParam) throws Exception {
        
        logger.info("${classNameLower}/listPage 接收的参数为 {} " ,JSONObject.toJSON(pageParam));
        return new  BaseResult<> ((PageBean<${className}>)${classNameLower}Service.listPage(pageParam));
    }

}
