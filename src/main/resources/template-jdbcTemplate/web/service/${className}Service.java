
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ${basepackage}.entity.${className};
import ${basepackage}.facade.${className}Facade;
import ${basepackage}.vo.${className}Vo;
import com.gzhc365.${deptFlag}.common.PageBean;
import java.util.List;

/**
 <#include "/java_description.include">
 */
@Service
public class ${className}Service {
    private static final Logger logger = LoggerFactory.getLogger(${className}Service.class);

    @Autowired
    private ${className}Facade ${classNameLower}Facade;

    /**
     * 获得所有数据
     * @return
     */
    public List<${className}> findAll(HcContext context){
        return ${className}Facade.findAll(context);
    }

    /**
     * 根据id查询数据
     * @param id
     * @param context
     * @return
     */
    public ${className} getById(Integer id, HcContext context){
        return ${classNameLower}Facade.getById(id,context);
    }

    /**
     * 新增
     * @param ${classNameLower}
     * @param context
     * @return
     * @throws
     */
    public Map<String, Object> add(${className} ${classNameLower}, HcContext context){
        Map<String, Object> resultMap = new HashMap();
        if (${classNameLower}Facade.add(${classNameLower},context )){//新增成功
            resultMap.put(WebResultText.CODE,WebResultText.SUCCESS_CODE );
            resultMap.put(WebResultText.DATA,WebResultText.ADD_SUCCESS );
        }else {//新增失败
            resultMap.put(WebResultText.CODE,WebResultText.FAIL_CODE );
            resultMap.put(WebResultText.DATA,WebResultText.ADD_FAILD );
        }
        return resultMap;
    }

    /**
     * 更新
     * @param ${classNameLower}
     * @param context
     * @return
     * @throws
     */
    public Map<String, Object> update(${className} ${classNameLower}, HcContext context){
        Map<String, Object> resultMap = new HashMap();
        if (${classNameLower}Facade.update(warningThresholdThread,context )){//更新成功
            resultMap.put(WebResultText.CODE,WebResultText.SUCCESS_CODE );
            resultMap.put(WebResultText.DATA,WebResultText.UPDATE_SUCCESS );
        }else {//更新失败
            resultMap.put(WebResultText.CODE,WebResultText.FAIL_CODE );
            resultMap.put(WebResultText.DATA,WebResultText.UPDATE_FAILD );
        }
        return resultMap;
    }

    /**
     * 根据id删除
     * @param id
     * @param context
     * @return
     */
    public Map<String, Object> delete(Integer id, HcContext context){
        Map<String, Object> resultMap = new HashMap();
        if (${classNameLower}Facade.delete(id, context )){
            //删除成功
            resultMap.put(WebResultText.CODE,WebResultText.SUCCESS_CODE );
            resultMap.put(WebResultText.DATA,WebResultText.DELETE_SUCCESS );
        }else {
            //删除失败
            resultMap.put(WebResultText.CODE,WebResultText.FAIL_CODE );
            resultMap.put(WebResultText.DATA,WebResultText.DELETE_FAILD );
        }
        return resultMap;
    }
}
