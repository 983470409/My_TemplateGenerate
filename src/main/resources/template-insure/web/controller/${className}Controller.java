
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ${basepackage}.po.*;
import ${basepackage}.facade.${className}Facade;
import ${basepackage}.vo.*;
import io.swagger.annotations.*;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.gzhc365.insurance.profile.request.*;

/**
 <#include "/java_description.include">
 */
@Api
@RestController
@RequestMapping("/api/${appModule}/${classNameLower}")
public class ${className}Controller extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);

    @Autowired
    private ${className}Facade ${classNameLower}Facade;

    @RequestMapping(value = "/paging",method = { RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "分页获取${className}",response = PageBean.class)
    public void paging(HttpServletRequest request, HttpServletResponse response, @RequestBody ${className}PagingQueryVo  ${classNameLower}pagingQueryVo){
        try{
            logger.info("分页获取${className} request = {} ", JSON.toJSONString(${classNameLower}pagingQueryVo));
            PageBean<${className}Vo> pageBean = ${classNameLower}Facade.listPage(${classNameLower}pagingQueryVo);
            this.sendSuccessData(response, pageBean);
        }catch (Exception e){
            logger.error("分页获取${className} request = {} " ,JSON.toJSONString(${classNameLower}pagingQueryVo), e);
            this.sendFailData(response, "分页获取${className}失败");
        }
    }

    @RequestMapping(value = "/add",method = { RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "新增${classNameLower}",response = Long.class)
    public void paging(HttpServletRequest request, HttpServletResponse response, @RequestBody ${className}AddReq ${classNameLower}AddReq){
        try{
            logger.info("新增${classNameLower} request = {} ", JSON.toJSONString(${classNameLower}AddReq));
            Long id = ${classNameLower}Facade.add(${classNameLower}AddReq);
            this.sendSuccessData(response, id);
        }catch (Exception e){
            logger.error("新增${classNameLower} request = {} " ,JSON.toJSONString(${classNameLower}AddReq), e);
            this.sendFailData(response, "新增渠道异常");
        }
    }

    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    @ApiOperation(value = "编辑${classNameLower}")
    public void update(HttpServletRequest request, HttpServletResponse response, @RequestBody ${className}UpdateReq ${classNameLower}UpdateReq){
        try{
            logger.info("编辑${classNameLower} request = {} ", JSON.toJSONString(${classNameLower}UpdateReq));
            ${classNameLower}Facade.update(${classNameLower}UpdateReq);
            this.sendSuccessData(response, "编辑${classNameLower}成功");
        }catch (Exception e){
            logger.error("编辑${classNameLower}异常 request = {} ",JSON.toJSONString(${classNameLower}UpdateReq), e);
            this.sendFailData(response, "编辑${classNameLower}异常");
        }
    }

    @RequestMapping(value = "/query",method = { RequestMethod.GET, RequestMethod.POST })
    @ApiOperation(value = "查询${classNameLower}",response = PlatformProfileVo.class)
    public void get${className}s(HttpServletRequest request, HttpServletResponse response, @RequestBody ${className}QueryReq ${classNameLower}QueryReq){
        try{
            logger.info("查询${classNameLower} request = {} ", JSON.toJSONString(${classNameLower}QueryReq));
            List<${className}> ${classNameLower}VoList = ${classNameLower}Facade.get${className}s(${classNameLower}QueryReq);
            this.sendSuccessData(response, ${classNameLower}VoList);
        }catch (Exception e){
            logger.error("查询${classNameLower} request = {} ",JSON.toJSONString(${classNameLower}QueryReq), e);
            this.sendFailData(response, "查询${classNameLower}异常");
        }
    }

    @RequestMapping(value = "/del",method = { RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "删除${classNameLower}")
    public void delete(HttpServletRequest request, HttpServletResponse response, @RequestBody ${className}DeleteReq ${classNameLower}DeleteReq){
        try{

            logger.info("删除${classNameLower} request = {} ", JSON.toJSONString(${classNameLower}DeleteReq));
            ${classNameLower}Facade.delete(${classNameLower}DeleteReq);
            this.sendSuccessData(response, "删除${classNameLower}成功");
        }catch (Exception e){
            logger.error("删除${classNameLower} request = {} ",JSON.toJSONString(${classNameLower}DeleteReq), e);
            this.sendFailData(response, "删除${classNameLower}异常");
        }
    }

    @RequestMapping(value = "/getById",method = { RequestMethod.GET, RequestMethod.POST })
    @ApiOperation(value = "查询${classNameLower}",response = PlatformProfileVo.class)
    public void getById(HttpServletRequest request, HttpServletResponse response, Long id){
        try{
            logger.info("查询${classNameLower} request = {} ", id);
            ${className}Vo ${classNameLower}Vo = ${classNameLower}Facade.get${className}ById(id);
            this.sendSuccessData(response, ${classNameLower}Vo);
        }catch (Exception e){
            logger.error("查询${classNameLower} request = {} ",JSON.toJSONString(id), e);
            this.sendFailData(response, "查询${classNameLower}异常");
        }
    }

}
