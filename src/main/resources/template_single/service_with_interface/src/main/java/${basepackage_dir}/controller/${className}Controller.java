<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

package ${basepackage}.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import ${basepackage}.common.ErrorCode;

import com.eteam.common.entity.TeamContext;
import com.eteam.common.web.controller.BaseController;
import com.eteam.entity.PageBean;
import com.eteam.entity.PageParam;

import ${basepackage}.entity.${className};
import ${basepackage}.service.${className}Service;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("${appModule}/api/${classNameLower}")
public class ${className}Controller extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);
    
    @Autowired
    private  ${className}Service  ${classNameLower}Service;
    
    @RequestMapping("/add")
    public void add${className}(HttpServletRequest request, HttpServletResponse response, ${className} ${classNameLower} ) {
        TeamContext context = BaseController.getContext(request);
        try {
            
            ${classNameLower}Service.save(${classNameLower} , context);
           
        } catch (Exception e) {
            logger.error("sequence:{}加载失败 ", context, e);
            this.sendFailureMessage(response, ErrorCode.INPUT_PARAMS_ERROR, "加载失败");
        }
    }

    @RequestMapping("/pages")
    public void pages(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, Object> paramMap,
            PageParam pageParam) {
        TeamContext context = BaseController.getContext(request);
        try {
            PageBean<?> listPage = ${classNameLower}Service.(pageParam, paramMap, context);
            this.sendSuccessData(response,listPage);

        } catch (Exception e) {
            logger.error("sequence:{}加载失败  ", context, e);
            this.sendFailureMessage(response, ErrorCode.INPUT_PARAMS_ERROR, "加载失败 ");
        }
    }

}
