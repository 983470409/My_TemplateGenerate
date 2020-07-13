
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
import ${basepackage}.vo.${className}Vo;
import io.swagger.annotations.Api;
import com.gzhc365.${deptFlag}.common.PageBean;
import com.gzhc365.cloud.commons.api.ApiResult;
import java.util.List;

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
        ApiResult ApiResult = new ApiResult(0, "新增成功");
        try{
           ${classNameLower}Facade.save(${classNameLower}Vo);
        }catch (Exception e){
            logger.error("sequence:{}系统异常，请稍后重试", e);
            ApiResult.setCode(-1);
            ApiResult.setMsg("系统异常，请稍后重试");
        }
        return ApiResult;
    }

    @ResponseBody
    @RequestMapping("/update")
    public ApiResult add${className}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult ApiResult = new ApiResult(0, "更新成功");
        try{
            ${classNameLower}Facade.update(${classNameLower}Vo);
        }catch (Exception e){
            logger.error("sequence:{}系统异常，请稍后重试", e);
            ApiResult.setCode(-1);
            ApiResult.setMsg("系统异常，请稍后重试");
        }
        return ApiResult;
    }

    @ResponseBody
    @RequestMapping("/page")
    public ApiResult page(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult ApiResult = new ApiResult();
        try{
            PageBean<?> listPage = ${classNameLower}Facade.listPage(${classNameLower}Vo).getData();
            ApiResult.setData(listPage);
        }catch (Exception e){
            logger.error("sequence:{}系统异常，请稍后重试 error:", e);
            ApiResult.setCode(-1);
            ApiResult.setMsg("系统异常，请稍后重试");
        }

        return ApiResult;
    }


    @ResponseBody
    @RequestMapping("/get${classNameLower}s")
    public ApiResult ${classNameLower}s(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult ApiResult = new ApiResult();
        try{
            List<${className}> ${classNameLower}s = ${classNameLower}Facade.get${className}s(${classNameLower}Vo).getData();
            ApiResult.setData(${classNameLower}s);
        }catch (Exception e){
            logger.error("系统异常，请稍后重试", e);
            ApiResult.setCode(-1);
            ApiResult.setMsg("系统异常，请稍后重试");
        }
        return ApiResult;
    }

    @RequestMapping("/get${classNameLower}")
    public ApiResult ${classNameLower}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult ApiResult = new ApiResult();
        try{
            ${className} ${classNameLower} = ${classNameLower}Facade.get${className}(${classNameLower}Vo).getData();
            ApiResult.setData(${classNameLower});
        }catch (Exception e){
            logger.error("sequence:{}系统异常，请稍后重试", e);
            ApiResult.setCode(-1);
            ApiResult.setMsg("系统异常，请稍后重试");
        }
        return ApiResult;
    }

}
