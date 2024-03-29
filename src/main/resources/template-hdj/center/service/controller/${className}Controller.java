
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

package ${basepackage}.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ${basepackage}.entity.${className};
import ${basepackage}.dto.*;
import ${basepackage}.service.${className}Service;
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.gzhc365.ehis.core.vo.PageBean;
import com.gzhc365.ehis.core.vo.BaseResult;
import ${basepackage}.facade.${className}Facade;
/**
 <#include "/java_description.include">
 */
@RestController
@RequestMapping("/")
public class ${className}Controller implements ${className}Facade{

    private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);
   
    @Autowired
    private ${className}Service ${classNameLower}Service;


    /**
     * 获得数据列表
     * @param ${classNameLower}ListDto
     * @return
     */
    @Override
    public BaseResult<List<${className}>> get${className}s(@RequestBody ${className}ListDto ${classNameLower}ListDto){
        logger.info("接收的参数为 {} " ,JSONObject.toJSON(${classNameLower}ListDto));
        return  new  BaseResult<>(${classNameLower}Service.get${className}sBy(${classNameLower}ListDto));
    }

    /**
     * 根据id获得数据
     * @param id
     * @return
     */
    @Override
    public BaseResult<${className}> get${className}ById( @RequestParam("id") long id){
        return new  BaseResult<>(${classNameLower}Service.getById(id));
    }

    /**
     * 新增数据
     * @param  ${classNameLower}AddDto
     * @return
     */
    @Override
    public BaseResult<${className}> save(@RequestBody ${className}AddDto ${classNameLower}AddDto){
        logger.info("${classNameLower}/save 接收的参数为 {} " ,JSONObject.toJSON(${classNameLower}AddDto));

        ${className} ${classNameLower} = new ${className}();
        BeanUtils.copyProperties(${classNameLower}AddDto, ${classNameLower});

        return new BaseResult<>( ${classNameLower}Service.save(${classNameLower}));
    }

    /**
     * 更新数据
     * @param  ${classNameLower}UptDto
     * @return
     */
    @Override
    public BaseResult<Integer> update(@RequestBody ${className}UptDto ${classNameLower}UptDto){
        logger.info(" ${classNameLower}/update 接收的参数为 {} " ,JSONObject.toJSON(${classNameLower}UptDto));

        ${className} ${classNameLower} = new ${className}();
        BeanUtils.copyProperties(${classNameLower}UptDto, ${classNameLower});

        return new  BaseResult<>(${classNameLower}Service.update(${classNameLower}));
    }

    /**
     * 删除数据
     * @param  ${classNameLower}DelDto
     * @return
     */
    @Override
    public BaseResult<Integer> delete(@RequestBody ${className}DelDto ${classNameLower}DelDto){
        logger.info(" ${classNameLower}/delete 接收的参数为 {} " ,JSONObject.toJSON(${classNameLower}DelDto));

        ${className} ${classNameLower} = new ${className}();
        BeanUtils.copyProperties(${classNameLower}DelDto, ${classNameLower});

        return new BaseResult<>(${classNameLower}Service.delete(${classNameLower}));
    }

    /**
     * 根据主键id删除数据
     * @param  id
     * @return
     */
    @Override
    public BaseResult<Integer> deleteById(@RequestParam("id") long id){
        logger.info(" ${classNameLower}/deleteById 接收的参数为 {} " ,JSONObject.toJSON(id));

        return new BaseResult<>(${classNameLower}Service.deleteById(id));
    }

    /**
     * 分页查询
     * @param  ${classNameLower}PageDto
     * @return
     */
    @Override
    public BaseResult<PageBean<${className}>> listPage(@RequestBody ${className}PageDto ${classNameLower}PageDto){
        logger.info("${classNameLower}/listPage 接收的参数为 {} " ,JSONObject.toJSON(${classNameLower}PageDto));
        return new  BaseResult<>((PageBean<${className}>)${classNameLower}Service.listPage(${classNameLower}PageDto));
    }

    /**
     * 获得单个对象
     * @param  ${classNameLower}GetDto
     * @return
     */
    @Override
    public BaseResult<${className}> get${className} (@RequestBody ${className}GetDto ${classNameLower}GetDto){
        logger.info(" ${classNameLower}/get${className} 接收的参数为 {} " ,JSONObject.toJSON( ${classNameLower}GetDto));
        return new BaseResult<>(${classNameLower}Service.get${className}By(${classNameLower}GetDto));
    }

}
