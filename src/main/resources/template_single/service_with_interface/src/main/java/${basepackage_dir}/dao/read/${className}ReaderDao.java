<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   

package ${basepackage}.dao.read;

import java.util.List;
import java.util.Map;

import com.gzhc365.sale.entity.OrderItem;

import ${basepackage}.entity.${className};


public interface ${className}ReaderDao {
    ${className} selectByPrimaryKey(Long id);

    /** 
     *
     * 
     * @author ${author}
     * @date: 2018年4月9日 下午7:46:08
     * @version 1.0
     *
     * @param t
     * @return
     */ 
    List<${className}> getBy(${className} t);

    /** 
     *
     * 
     * @author ${author}
     * ${time}
     * @version 1.0
     *
     * @param paramMap
     * @return
     */ 
    Long listPageCount(Map<String, Object> paramMap);

    /** 
     *
     * 
     * @author ${author}
     * ${time}
     * @version 1.0
     *
     * @param t
     * @return
     */ 
    ${className} getById(${className} t);
    
    List< ${className}> listPage(Map<String, Object> paramMap);

}