<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

import com.alibaba.dubbo.config.annotation.Service;
import ${basepackage}.common.constants.CenterCode;
import ${basepackage}.common.exception.AlarmCenterException;
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.entity.${className};
import ${basepackage}.validator.${className}Validator;
import ${basepackage}.vo.${className}Vo;
import com.gzhc365.component.utils.entity.HcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 <#include "/java_description.include">
 */
@Service
public class ${className}FacadeImpl implements ${className}Facade{

    private static final Logger logger = LoggerFactory.getLogger(${className}FacadeImpl.class);

    @Autowired
    private ${className}Dao ${classNameLower}Dao;

    @Autowired
    private ${className}Validator ${classNameLower}Validator;

    @Override
    public boolean delete(Integer id, HcContext context) throws AlarmCenterException {
        ${classNameLower}Validator.validateDelete(id,context);
        try {
            ${classNameLower}Dao.delete(id);
            return true;
        }catch (Exception e){
            throw new AlarmCenterException(CenterCode.DATABASE_ERROR,"${classNameLower}Dao.delete",e);
        }
    }

    @Override
    public boolean add(${className} ${classNameLower}, HcContext context) throws AlarmCenterException {
        ${classNameLower}Validator.validateAdd(${classNameLower},context);
        try {
            ${classNameLower}Dao.add(${classNameLower});
            return true;
        }catch (Exception e){
            throw new AlarmCenterException(CenterCode.DATABASE_ERROR,"${classNameLower}Dao.add",e);
        }
    }

    @Override
    public ${className} getById(Integer id, HcContext context) throws AlarmCenterException {
        ${classNameLower}Validator.validateGetById(id,context);
        return ${classNameLower}Dao.getById(id);
    }

    @Override
    public boolean update(${className} ${classNameLower}, HcContext context) throws AlarmCenterException {
        ${classNameLower}Validator.validateUpdate(${classNameLower},context);
        try {
            ${classNameLower}Dao.update(${classNameLower});
            return true;
        }catch (Exception e){
            throw new AlarmCenterException(CenterCode.DATABASE_ERROR,"${classNameLower}Dao.update",e);
        }
    }

    @Override
    public Map<String,Object> page(${className}Vo ${classNameLower}Vo, HcContext context) throws AlarmCenterException {
        ${classNameLower}Validator.validatePage(${classNameLower}Vo,context);
        Map<String,Object> resultMap = new HashMap();//返回结果map
        resultMap.put("rows",${classNameLower}Dao.paging(${classNameLower}Vo));//放入数据集合
        Integer total = ${classNameLower}Dao.count(${classNameLower}Vo);//总记录数
        resultMap.put("total",total );//放入总记录数
        //计算总页数
        Integer pageSize = ${classNameLower}Vo.getPageSize();
        int totalPages = total / pageSize;
        if (total > pageSize * totalPages){
            totalPages++;
        }
        resultMap.put("totalPages", totalPages);//放入总记录数
        return resultMap;
    }

}
