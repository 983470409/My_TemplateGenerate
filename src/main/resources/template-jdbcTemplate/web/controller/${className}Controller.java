
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
import ${basepackage}.vo.${className}Vo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 <#include "/java_description.include">
 */
@Api
@Controller
@RequestMapping("/api/${appModule}/${classNameLower}")
public class ${className}Controller extends BaseController{
    private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);

    @Autowired
    private ${className}Service ${classNameLower}Service;


    @RequestMapping(value = "/add",method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "新增${className}",response = ${className}.class)
    public void add${className}(HttpServletRequest request, HttpServletResponse response,  @RequestBody ${className} ${classNameLower}) {
        Map<String, Object> resultMap = ${classNameLower}Service.add(${classNameLower}, getHcContext(request));
        this.sendData(response,resultMap );
    }

    @RequestMapping(value = "/update",method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "更新${className}",response = String.class)
    public void update${className}(HttpServletRequest request, HttpServletResponse response, @RequestBody ${className} ${classNameLower}) {
        Map<String, Object> resultMap = ${classNameLower}Service.update(${classNameLower}, getHcContext(request));
        this.sendData(response,resultMap );
    }

    @RequestMapping(value = "/delete",method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "删除${className}",response = String.class)
    public void delete${className}(HttpServletRequest request, HttpServletResponse response, @RequestParam Integer id) {
        Map<String, Object> resultMap = ${classNameLower}Service.delete(id, getHcContext(request));
        this.sendData(response,resultMap );
    }

    @RequestMapping(value = "/getbyid",method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "根据id查询${className}信息",response = ${className}.class)
    public void getById(HttpServletRequest request, HttpServletResponse response, @RequestParam Integer id) {
        ${className} ${classNameLower} = ${classNameLower}Service.getById(id, getHcContext(request));
        this.sendSuccessData(response, ${classNameLower} );
    }

    @RequestMapping(value = "/findall",method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "获取${className}列表",response = ${className}.class)
    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        List<${className}> ${classNameLower}List = ${classNameLower}Service.findAll(getHcContext(request));
        this.sendSuccessData(response, ${classNameLower}List);
    }

    /**
     * 分页查询
     * @param  ${classNameLower}Vo
     * @param request
     * @param response
     */
    @RequestMapping(value = "/paging",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询",response = Map.class)
    public void paging(@ApiParam(value = "必填，条件查询对象")  @RequestBody ${className}Vo ${classNameLower}Vo,
        HttpServletRequest request, HttpServletResponse response){
        Map resultMap = ${classNameLower}Service.paging(${classNameLower}Vo, getHcContext(request));
        this.sendSuccessData(response,resultMap );
    }

}
