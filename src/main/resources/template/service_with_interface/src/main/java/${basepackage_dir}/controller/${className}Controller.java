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

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.gzhc365.common.ErrorCode;
import com.gzhc365.component.utils.entity.HcContext;
import com.gzhc365.component.utils.entity.PageBean;
import com.gzhc365.component.utils.entity.PageParam;
import com.gzhc365.component.web.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ${basepackage}.entity.${className};
import ${basepackage}.facade.${className}Facade;

@Controller
@RequestMapping("${appModule}/api/${classNameLower}")
public class ${className}Controller extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(${className}Controller.class);
    
    @Autowired
    private  ${className}Service  ${classNameLower}Service;
    
    @RequestMapping("/add")
    public void add${className}(HttpServletRequest request, HttpServletResponse response, ${className} ${classNameLower} ) {
        HcContext context = BaseController.getHcContext(request);
        try {
            
            ${classNameLower}Service.save(${classNameLower} , context);
           
        } catch (Exception e) {
            logger.error("sequence:{}加载失败", context, e);
            this.sendFailureMessage(response, ErrorCode.INPUT_PARAMS_ERROR, "加载失败");
        }
    }
    
    @RequestMapping("/page")
    public void page(HttpServletRequest request, HttpServletResponse response, PageParam pageParam,
            @RequestParam Map<String, Object> paramMap) {
        HcContext context = BaseController.getHcContext(request);
        Map<String, Object> map = new HashMap<>();
        logger.info("sequence:{} 分页查询的参数 map:{} pageParam: {}", context, JSONObject.toJSONString(map, true),
                JSONObject.toJSONString(pageParam, true));
        try {
            PageBean<?> listPage = todoWorkFacade.listPage(pageParam, paramMap, context);
            map.put("pages", listPage);
            this.sendSuccessData(response, map);
        } catch (Exception e) {
            logger.error("sequence:{}加载失败 error:", context, e);
            this.sendFailureMessage(response, ErrorCode.SYSTEM_VALUE_ERROR, "加载失败");

        }
    }

    

}
