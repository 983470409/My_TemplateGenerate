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
import org.apache.commons.compress.utils.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.midi365.mall.constant.PictureType;
import cn.midi365.mall.entity.Complaint;
import cn.midi365.mall.vo.ComplaintVo;

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

@RestController
@RequestMapping("${classNameLower}")
public class ${className}Controller {
    private static Logger logger = LoggerFactory.getLogger(${className}Controller.class);
    
   
    @RequestMapping("/add")
    public void add${className}(HttpServletRequest request, HttpServletResponse response, ${className} ${classNameLower} ) {
        HcContext context = BaseController.getHcContext(request);
        try {
            
            ${classNameLower}Facade.save(${classNameLower} , context);
           
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
            PageBean<?> listPage = ${classNameLower}Facade.listPage(pageParam, paramMap, context);
            map.put("pages", listPage);
            this.sendSuccessData(response, map);
        } catch (Exception e) {
            logger.error("sequence:{}加载失败 error:", context, e);
            this.sendFailureMessage(response, ErrorCode.SYSTEM_VALUE_ERROR, "加载失败");

        }
    }

    
    @RequestMapping("/${classNameLower}s")
    public void ${classNameLower}s (HttpServletRequest request, HttpServletResponse response, String picture , Complaint  complaint ) {
        HcContext context = BaseController.getHcContext(request);
        try {
            
            List<${className}> ${classNameLower}s = ${classNameLower}Facade.getBy(${classNameLower}, context);
            
            this.sendSuccessData(response,  ${classNameLower}s);
            
        } catch (Exception e) {
            logger.error("sequence:{}加载失败", context, e);
            this.sendFailureMessage(response, ErrorCode.INPUT_PARAMS_ERROR, "加载失败");
        }
    }
    
    
    
    @RequestMapping("/${classNameLower}")
    public void ${classNameLower} (HttpServletRequest request, HttpServletResponse response, String picture , Complaint  complaint ) {
        HcContext context = BaseController.getHcContext(request);
        try {
            ${className} ${classNameLower} = ${classNameLower}Facade.getById(${classNameLower}, context);
            this.sendSuccessData(response,  ${classNameLower});
            
        } catch (Exception e) {
            logger.error("sequence:{}加载失败", context, e);
            this.sendFailureMessage(response, ErrorCode.INPUT_PARAMS_ERROR, "加载失败");
        }
    }

}
