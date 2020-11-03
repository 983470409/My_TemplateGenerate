
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

package ${basepackage}.controller;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;
import ${basepackage}.request.*;
import ${basepackage}.vo.*;
import ${basepackage}.po.*;
import ${basepackage}.facade.${className}Facade;
import ${basepackage}.service.${className}Service;
import java.util.List;
import ${basepackage}.exception.*;
import io.swagger.annotations.Api;

/**
 <#include "/java_description.include">
 */
@RestController
@RequestMapping("/")
@Api(value = "${className}Controller", description = "${className}相关接口")
public class ${className}Controller implements ${className}Facade{

    private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);
   
    @Autowired
    private ${className}Service ${classNameLower}Service;

    /**
     * 新增
     * @param ${classNameLower}AddReq
     * @return
     */
    @RequestMapping(value="${classNameLower}/add",  method = { RequestMethod.POST })
    @Override
    public Long add(@RequestBody ${className}AddReq ${classNameLower}AddReq){
        try{
            return ${classNameLower}Service.add(${classNameLower}AddReq);
        }catch (Exception e) {
            logger.error("添加${classNameLower}失败 ${classNameLower}Req = {}",JSON.toJSONString(${classNameLower}AddReq),e);
            throw new InsuranceProfileException("添加${classNameLower}异常 : " + e.getMessage());
        }
    }

    /**
     * 删除
     * @param ${classNameLower}DeleteReq
     */
    @RequestMapping(value="${classNameLower}/delete",  method = { RequestMethod.POST })
    @Override
    public void delete(@RequestBody ${className}DeleteReq ${classNameLower}DeleteReq){
        try{
            ${classNameLower}Service.delete${className}(${classNameLower}DeleteReq.get${className}Id());
        }catch (Exception e) {
            logger.error("删除${classNameLower}失败 ${classNameLower}Req = {}" ,JSON.toJSONString(${classNameLower}DeleteReq),e);
            throw new InsuranceProfileException("删除${classNameLower}异常 : " + e.getMessage());
        }
    }

    /**
     * 更新
     * @param ${classNameLower}UpdateReq
     */
    @RequestMapping(value="${classNameLower}/update",  method = { RequestMethod.POST })
    @Override
    public void update(@RequestBody ${className}UpdateReq ${classNameLower}UpdateReq){
        try{
            ${classNameLower}Service.update${className}(${classNameLower}UpdateReq);
        }catch (Exception e) {
            logger.error("编辑${classNameLower}失败 ${classNameLower}Req = {}" ,JSON.toJSONString(${classNameLower}UpdateReq),e);
            throw new InsuranceProfileException("编辑${classNameLower}异常 : " + e.getMessage());
        }
    }

    /**
     * 通过筛选条件查找数据
     * @param ${classNameLower}QueryReq
     */
    @RequestMapping(value="${classNameLower}/get${className}s",  method = { RequestMethod.POST })
    @Override
    public List<${className}> get${className}s(@RequestBody ${className}QueryReq ${classNameLower}QueryReq){
        return ${classNameLower}Service.get${className}sBy(${classNameLower}QueryReq);
    }

    /**
     * 通过主键id查找数据
     * @param id
     */
    @RequestMapping(value="${classNameLower}/get${className}ById",  method = { RequestMethod.POST })
    @Override
    public ${className}Vo get${className}ById(@RequestParam("id") long id){
        try{
            return ${classNameLower}Service.getById(id);
        }catch (Exception e) {
            logger.error("查找${classNameLower}失败 id = {}" ,JSON.toJSONString(id),e);
            throw new InsuranceProfileException("查找${classNameLower}异常 : " + e.getMessage());
        }
    }

    /**
     * 根据筛选条件查询数据
     * @param ${classNameLower}PagingQueryVo
     */
    @RequestMapping(value="${classNameLower}/listPage",  method = { RequestMethod.POST })
    @Override
    public PageBean<${className}Vo> listPage(@RequestBody ${className}PagingQueryVo ${classNameLower}PagingQueryVo){
        return ${classNameLower}Service.paging(${classNameLower}PagingQueryVo);
    }

}
