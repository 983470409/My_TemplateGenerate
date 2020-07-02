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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import com.gzhc365.ehis.core.vo.BaseResult;
import ${basepackage}.entity.${className};
import ${basepackage}.facade.${className}Facade;
import ${basepackage}.vo.${className}Param;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gzhc365.ehis.core.vo.PageBean;
import com.gzhc365.ehis.core.vo.PageParam;


@Controller
@RequestMapping("${appModule}/api/${classNameLower}")
public class ${className}Controller  {
    private static Logger logger = LoggerFactory.getLogger(${className}Controller.class);

    @Autowired
    private ${className}Facade ${classNameLower}Facade;

    @ResponseBody
    @RequestMapping("/add")
    public BaseResult add${className}(HttpServletRequest request, HttpServletResponse response, ${className}Param ${classNameLower}Param) {
        BaseResult baseResult = new BaseResult(0, "success");
        try {
           ${classNameLower}Facade.save(${classNameLower}Param);

        } catch (Exception e) {
            logger.error("sequence:{}系统异常，请稍后重试", e);
            baseResult.setCode(-1);
            baseResult.setMsg("系统异常，请稍后重试");
        }
        return baseResult;
    }

    @ResponseBody
    @RequestMapping("/page")
    public BaseResult page(HttpServletRequest request, HttpServletResponse response, PageParam pageParam,
            @RequestParam Map<String, Object> paramMap) {
        Map<String, Object> map = new HashMap<>();
        logger.info("sequence:{} 分页查询的参数 map:{} pageParam: {}", JSONObject.toJSONString(map),
                JSONObject.toJSONString(pageParam, true));
        BaseResult baseResult = new BaseResult(0, "success");
        try {
            pageParam.setParamMap(paramMap);
            PageBean<?> listPage = ${classNameLower}Facade.listPage(pageParam).getData();
            baseResult.setData(listPage);

        } catch (Exception e) {
            logger.error("sequence:{}系统异常，请稍后重试 error:", e);
            baseResult.setCode(-1);
            baseResult.setMsg("系统异常，请稍后重试");
        }

        return baseResult;
    }

    /**
     * 
     */
    @ResponseBody
    @RequestMapping("/${classNameLower}s")
    public BaseResult ${classNameLower}s(HttpServletRequest request, HttpServletResponse response, ${className}Param ${classNameLower}Param) {
        BaseResult baseResult = new BaseResult(0, "success");
        try {

            List<${className}> ${classNameLower}s = ${classNameLower}Facade.get${className}s(${classNameLower}Param).getData();
            baseResult.setData(${classNameLower}s);

        } catch (Exception e) {
            logger.error("sequence:{}系统异常，请稍后重试", e);
            baseResult.setCode(-1);
            baseResult.setMsg("系统异常，请稍后重试");
        }

        return baseResult;
    }

    @RequestMapping("/${classNameLower}")
    public BaseResult ${classNameLower}(HttpServletRequest request, HttpServletResponse response, ${className}Param ${classNameLower}Param) {
        BaseResult baseResult = new BaseResult(0, "success");
        try {
            ${className} ${classNameLower} = ${classNameLower}Facade.get${className}(${classNameLower}Param).getData();
            baseResult.setData(${classNameLower});

        } catch (Exception e) {
            logger.error("sequence:{}系统异常，请稍后重试", e);
            baseResult.setCode(-1);
            baseResult.setMsg("系统异常，请稍后重试");
        }
        return baseResult;
    }

}
