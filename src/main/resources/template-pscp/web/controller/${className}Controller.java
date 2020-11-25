
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ${basepackage}.entity.${className};
import ${basepackage}.facade.${className}Facade;
import io.swagger.annotations.Api;
import com.gzhc365.${deptFlag}.common.vo.PageBean;
import com.gzhc365.${deptFlag}.common.BaseResult;
import java.util.List;
import ${basepackage}.module.${classNameLower}.model.reqVo.*;
import ${basepackage}.module.${classNameLower}.model.respVo.*;
import ${basepackage}.module.${classNameLower}.service.*;
import org.springframework.validation.annotation.Validated;

/**
 <#include "/java_description.include">
 */
@Api
@Validated
@Controller
@RequestMapping("/api/${appModule}/${classNameLower}")
public class ${className}Controller  {
    private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);

    @Autowired
    private ${className}Service ${classNameLower}Service;

    @ResponseBody
    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseResult add${className}(HttpServletRequest request, HttpServletResponse response, ${className}AddVo ${classNameLower}AddVo) {
        return ${classNameLower}Service.add(${classNameLower}AddVo);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseResult update${className}(HttpServletRequest request, HttpServletResponse response, ${className}UptVo ${classNameLower}UptVo) {
        return ${classNameLower}Service.update(${classNameLower}UptVo);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseResult delete${className}(HttpServletRequest request, HttpServletResponse response, ${className}DelVo ${classNameLower}DelVo) {
        return ${classNameLower}Service.delete(${classNameLower}DelVo);
    }

    @ResponseBody
    @RequestMapping(value = "/page", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseResult page(HttpServletRequest request, HttpServletResponse response, ${className}PageVo ${classNameLower}PageVo) {
        return ${classNameLower}Service.page(${classNameLower}PageVo);
    }

    @ResponseBody
    @RequestMapping(value = "/get${classNameLower}s", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseResult ${classNameLower}s(HttpServletRequest request, HttpServletResponse response, ${className}ListVo ${classNameLower}ListVo) {
        return ${classNameLower}Service.get${classNameLower}List(${classNameLower}ListVo);
    }

    @ResponseBody
    @RequestMapping(value = "/get${classNameLower}byid", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseResult get${classNameLower}ById(HttpServletRequest request, HttpServletResponse response, Long id) {
        return ${classNameLower}Service.getById(id);
    }

}
