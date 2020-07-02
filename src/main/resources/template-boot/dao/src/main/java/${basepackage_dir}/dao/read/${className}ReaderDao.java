<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   

package ${basepackage}.dao.read;

import java.util.List;
import java.util.Map;
import ${basepackage}.entity.${className};


public interface ${className}ReaderDao {
    ${className} selectByPrimaryKey(Long id);

    /** 
     * TODO(这里用一句话描述这个方法的作用). <br/> 
     * 
     * @author zihong 
     * @date: 2018年4月9日 下午7:46:08
     * @version 1.0
     *
     * @param t
     * @return
     */ 
    List<${className}> get${className}sBy(${className} t);

    /** 
     * TODO(这里用一句话描述这个方法的作用). <br/> 
     * 
     * @author zihong 
     * @date: 2018年4月9日 下午7:46:16
     * @version 1.0
     *
     * @param paramMap
     * @return
     */ 
    Long listPageCount(Map<String, Object> paramMap);

    /** 
     * TODO(这里用一句话描述这个方法的作用). <br/> 
     * 
     * @author zihong 
     * @date: 2018年4月9日 下午7:46:36
     * @version 1.0
     *
     * @param t
     * @return
     */ 
    ${className} get${className}By(${className} t);
    
    List< ${className}> listPage(Map<String, Object> paramMap);

}