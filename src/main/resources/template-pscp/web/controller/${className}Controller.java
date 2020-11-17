
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ${basepackage}.entity.${className};
import ${basepackage}.facade.${className}Facade;
import io.swagger.annotations.Api;
import com.gzhc365.${deptFlag}.common.vo.PageBean;
import com.gzhc365.cloud.commons.api.ApiResult;
import java.util.List;
import ${basepackage}.module.${classNameLower}.model.reqVo.*;
import ${basepackage}.module.${classNameLower}.model.respVo.*;
import ${basepackage}.module.${classNameLower}.service.*;
/**
 <#include "/java_description.include">
 */
@Api
@Controller
@RequestMapping("/api/${appModule}/${classNameLower}")
public class ${className}Controller  {
    private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);

    @Autowired
    private ${className}Service ${classNameLower}Service;

    @ResponseBody
    @RequestMapping("/add")
    public ApiResult add${className}(HttpServletRequest request, HttpServletResponse response, ${className}AddVo ${classNameLower}AddVo) {
        return ${classNameLower}Service.add(${classNameLower}AddVo);
    }

    @ResponseBody
    @RequestMapping("/update")
    public ApiResult update${className}(HttpServletRequest request, HttpServletResponse response, ${className}UptVo ${classNameLower}UptVo) {
        return ${classNameLower}Service.update(${classNameLower}UptVo);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ApiResult delete${className}(HttpServletRequest request, HttpServletResponse response, ${className}DelVo ${classNameLower}DelVo) {
        return ${classNameLower}Service.delete(${classNameLower}DelVo);
    }

    @ResponseBody
    @RequestMapping("/page")
    public ApiResult page(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        return ${classNameLower}Service.page(${classNameLower}PageVo);
    }

    @ResponseBody
    @RequestMapping("/get${classNameLower}s")
    public ApiResult ${classNameLower}s(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        return ${classNameLower}Service.get${classNameLower}s(${classNameLower}ListVo);
    }



    @ResponseBody
    @RequestMapping("/get${classNameLower}byid")
    public ApiResult get${classNameLower}ById(HttpServletRequest request, HttpServletResponse response, Long id) {
        return ${classNameLower}Service.get${classNameLower}ById(id);
    }

}
