
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

    @Reference(retries = -1,timeout = 5000)
    private ${className}Facade ${classNameLower}Facade;

    /**
     * 分页查询菜单表
     * @param
     * @param hcContext
     * @return
     */
    public Map paging(${className}Vo ${classNameLower}Vo, HcContext hcContext){
        //判断页码是否为空或者小于1
        if (${classNameLower}Vo.getPageIndex()==null || ${classNameLower}Vo.getPageIndex()<1){
        //将页码设为1
            ${classNameLower}Vo.setPageIndex(1);
        }
        //判断页面显示的大小是否为空或者小于1
        if (${classNameLower}Vo.getPageSize()==null || ${classNameLower}Vo.getPageSize()<1){
        //将页面显示的大小设为5
             ${classNameLower}Vo.setPageSize(5);
        }
        return ${classNameLower}Facade.page(${classNameLower}Vo);
    }


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
