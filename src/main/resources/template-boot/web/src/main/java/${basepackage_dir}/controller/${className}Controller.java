<#include "/java_copyright.include">
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


import com.gzhc365.template.core.vo.ApiResult;
{basepackage}.entity.${className};
{basepackage}.facade.${className}Facade;
{basepackage}.vo.${className}Param;

import com.gzhc365.template.core.vo.PageBean;
import com.gzhc365.template.core.vo.PageParam;
import io.swagger.annotations.Api;
/**
 <#include "/java_description.include">
 */
@Api
@Controller
@RequestMapping("${appModule}/api/${classNameLower}")
public class ${className}Controller  {
    private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);

    @Autowired
    private ${className}Facade ${classNameLower}Facade;

    @ResponseBody
    @RequestMapping("/add")
    public ApiResult add${className}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult ApiResult = new ApiResult(0, "success");
        try {
           ${classNameLower}Facade.save(${classNameLower}Param);
        } catch (Exception e) {
            logger.error("sequence:{}系统异常，请稍后重试", e);
            ApiResult.setCode(-1);
            ApiResult.setMsg("系统异常，请稍后重试");
        }
        return ApiResult;
    }

    @ResponseBody
    @RequestMapping("/page")
    public ApiResult page(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        Map<String, Object> map = new HashMap<>();
        ApiResult ApiResult = new ApiResult(0, "success");
        try {
            pageParam.setParamMap(paramMap);
            PageBean<?> listPage = ${classNameLower}Facade.listPage(pageParam).getData();
            ApiResult.setData(listPage);

        } catch (Exception e) {
            logger.error("sequence:{}系统异常，请稍后重试 error:", e);
            ApiResult.setCode(-1);
            ApiResult.setMsg("系统异常，请稍后重试");
        }

        return ApiResult;
    }

    /**
     * 
     */
    @ResponseBody
    @RequestMapping("/${classNameLower}s")
    public ApiResult ${classNameLower}s(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult ApiResult = new ApiResult(0, "success");
        try {
            List<${className}> ${classNameLower}s = ${classNameLower}Facade.get${className}s(${classNameLower}Param).getData();
            ApiResult.setData(${classNameLower}s);
        } catch (Exception e) {
            logger.error("系统异常，请稍后重试", e);
            ApiResult.setCode(-1);
            ApiResult.setMsg("系统异常，请稍后重试");
        }

        return ApiResult;
    }

    @RequestMapping("/${classNameLower}")
    public ApiResult ${classNameLower}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult ApiResult = new ApiResult(0, "success");
        try {
            ${className} ${classNameLower} = ${classNameLower}Facade.get${className}(${classNameLower}Param).getData();
            ApiResult.setData(${classNameLower});

        } catch (Exception e) {
            logger.error("sequence:{}系统异常，请稍后重试", e);
            ApiResult.setCode(-1);
            ApiResult.setMsg("系统异常，请稍后重试");
        }
        return ApiResult;
    }

}
