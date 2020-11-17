
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

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
@Service
public class ${className}Service {
    private static final Logger logger = LoggerFactory.getLogger(${className}Service.class);

    @Autowired
    private ${className}Facade ${classNameLower}Facade;

    public ApiResult add(HttpServletRequest request, HttpServletResponse response, ${className}AddVo ${classNameLower}AddVo) {
        ${className}AddDto ${classNameLower}AddDto = new ${className}AddDto();

        BeanUtils.copyProperties(${classNameLower}AddVo, ${classNameLower}AddDto);
        ${classNameLower}Facade.save(${classNameLower}AddDto);

        return ApiResult.success("新增成功");
    }

    public ApiResult update${className}(HttpServletRequest request, HttpServletResponse response, ${className}UptVo ${classNameLower}UptVo) {

        ${className}UptDto ${classNameLower}UptDto = new ${className}UptDto();

        BeanUtils.copyProperties(${classNameLower}UpdVo, ${classNameLower}UptDto);
        ${classNameLower}Facade.update(${classNameLower}UptDto);

        return ApiResult.success("更新成功");
    }

    public ApiResult delete${className}(HttpServletRequest request, HttpServletResponse response, ${className}DelVo ${classNameLower}DelVo) {

        ${className}DelDto ${classNameLower}DelDto = new ${className}DelDto();

        BeanUtils.copyProperties(${classNameLower}DelVo, ${classNameLower}DelDto);
        ${classNameLower}Facade.delete(${classNameLower}Vo);

        return ApiResult.success("删除成功");
    }

    public ApiResult deleteById${className}(HttpServletRequest request, HttpServletResponse response, Long id) {

        ${className}DelDto ${classNameLower}DelDto = new ${className}DelDto();

        BeanUtils.copyProperties(${classNameLower}DelVo, ${classNameLower}DelDto);
        ${classNameLower}Facade.deleteById(${classNameLower}Vo);

        return ApiResult.success("删除成功");

    }

    public ApiResult page(HttpServletRequest request, HttpServletResponse response, ${className}PageVo ${classNameLower}PageVo) {

        ${className}PageDto ${classNameLower}PageDto = new ${className}PageDto();

        BeanUtils.copyProperties(${classNameLower}PageVo, ${classNameLower}PageDto);
        PageBean<?> listPage = ${classNameLower}Facade.listPage(${classNameLower}PageDto).getData();

        return ApiResult.success(listPage);
    }

    public ApiResult get${classNameLower}s(HttpServletRequest request, HttpServletResponse response, ${className}ListVo ${classNameLower}ListVo) {
        ${className}ListDto ${classNameLower}ListDto = new ${className}ListDto();

        BeanUtils.copyProperties(${classNameLower}ListVo, ${classNameLower}ListDto);
        List<${className}> ${classNameLower}s = ${classNameLower}Facade.get${className}s(${classNameLower}ListDto).getData();

        return ApiResult.success(${classNameLower}s);
    }

    public ApiResult get${classNameLower}ById(HttpServletRequest request, HttpServletResponse response, Long id) {

        ${className} ${classNameLower} = ${classNameLower}Facade.get${className}ById(id).getData();
        return ApiResult.success(${classNameLower});

    }

}