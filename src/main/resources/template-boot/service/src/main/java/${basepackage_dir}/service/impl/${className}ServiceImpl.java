<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSON;
import com.gzhc365.ehis.component.id.IDGenerator;
import com.gzhc365.ehis.core.vo.PageBean;
import com.gzhc365.ehis.core.vo.PageParam;
import ${basepackage}.dao.read.${className}ReaderDao;
import ${basepackage}.dao.write.${className}WriterDao;
import ${basepackage}.service.${className}Service;


<#include "/java_imports.include">

/**
 <#include "/java_description.include">
 */
@Service
public class ${className}ServiceImpl implements ${className}Service {
          private static final Logger logger = LoggerFactory.getLogger(UserFacadeFallback.class);


	    @Autowired
	    ${className}ReaderDao ${classNameLower}ReaderDao;
	    @Autowired
	    ${className}WriterDao ${classNameLower}WriterDao;

	    @Override
	    public List<${className}> get${className}sBy(${className} t) {

	        return ${classNameLower}ReaderDao.get${className}sBy(t);
	    }

	    @Override
	    public ${className} getById(long id) {

	        return ${classNameLower}ReaderDao.selectByPrimaryKey(id);
	    }

		@Override
	    public PageBean<${className}> listPage(PageParam pageParam) {
                Map<String,Object>  paramMap = null;
                if (pageParam.getParamMap() == null) {
                     paramMap = new HashMap<>();
                }else {
                    paramMap = pageParam.getParamMap();
                }

           // 根据页面传来的分页参数构造SQL分页参数
	        paramMap.put("pageFirst", (pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
	        paramMap.put("pageSize", pageParam.getNumPerPage());

	     // 统计总记录数
	        Long count = ${classNameLower}ReaderDao.listPageCount(paramMap);
	        // 获取分页数据集
	        List<${className}> list = ${classNameLower}ReaderDao.listPage(paramMap);
	        // 构造分页对象
	        return new PageBean<>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
	    }

	    @Override
	    public ${className} save(${className} t) {

	        int insertSelective = ${classNameLower}WriterDao.insertSelective(t);
	        
	        if (insertSelective > 0) {
	            return t;
	        } else {
	            return null;
	        }
	       
	    }

	    @Override
	    public ${className} update(final ${className} t) throws Exception {
	    	
	    	if (t.getId() ==null ) {
	    		
	    		throw new Exception("id为空");
	    	}
	        int flag = ${classNameLower}WriterDao.updateByPrimaryKeySelective(t);
	        if (flag > 0) {
	            return t;
	        } else {
	            return null;
	        }
	    }


	    @Override
	    public ${className} get${className}By(${className} t) {
	        
	        return ${classNameLower}ReaderDao.get${className}By(t);

	    }
}
