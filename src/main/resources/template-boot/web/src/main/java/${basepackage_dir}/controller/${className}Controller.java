
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
        ApiResult apiResult = new ApiResult(0, "新增成功");
        try{
           ${classNameLower}Facade.save(${classNameLower}Vo);
        }catch (Exception e){
            logger.error("/add系统异常，请稍后重试", e);
            apiResult = ApiResult.error("新增失败");
        }
        return apiResult;
    }

    @ResponseBody
    @RequestMapping("/update")
    public ApiResult update${className}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult apiResult = new ApiResult(0, "更新成功");
        try{
            ${classNameLower}Facade.update(${classNameLower}Vo);
        }catch (Exception e){
            logger.error("/update系统异常，请稍后重试", e);
            apiResult = ApiResult.error("更新失败");
        }
        return apiResult;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ApiResult delete${className}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult apiResult = new ApiResult(0, "删除成功");
        try{
            ${classNameLower}Facade.delete(${classNameLower}Vo);
        }catch (Exception e){
            logger.error("/delete系统异常，请稍后重试:{}", e);
            apiResult = ApiResult.error("删除失败");
        }
        return apiResult;
    }

    @ResponseBody
    @RequestMapping("/page")
    public ApiResult page(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult apiResult = new ApiResult();
        try{
            PageBean<?> listPage = ${classNameLower}Facade.listPage(${classNameLower}Vo).getData();
            apiResult.setData(listPage);
        }catch (Exception e){
            logger.error("/page系统异常，请稍后重试,{}", e);
            apiResult = ApiResult.error("分页失败");
        }
        return apiResult;
    }


    @ResponseBody
    @RequestMapping("/get${classNameLower}s")
    public ApiResult ${classNameLower}s(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult apiResult = new ApiResult();
        try{
            List<${className}> ${classNameLower}s = ${classNameLower}Facade.get${className}s(${classNameLower}Vo).getData();
            apiResult.setData(${classNameLower}s);
        }catch (Exception e){
            logger.error("get${classNameLower}s:系统异常，请稍后重试,{}", e);
            apiResult = ApiResult.error("获取数据失败");
        }
        return apiResult;
    }

    @RequestMapping("/get${classNameLower}")
    public ApiResult ${classNameLower}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
        ApiResult apiResult = new ApiResult();
        try{
            ${className} ${classNameLower} = ${classNameLower}Facade.get${className}(${classNameLower}Vo).getData();
            apiResult.setData(${classNameLower});
        }catch (Exception e){
            logger.error("get${classNameLower}:系统异常，请稍后重试,{}", e);
            apiResult = ApiResult.error("获取数据失败");
        }
        return apiResult;
    }

}
