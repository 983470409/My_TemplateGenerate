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
import com.gzhc365.component.id.IDGenerator;
import com.eteam.common.entity.PageBean;
import com.eteam.common.entity.PageParam;
import com.eteam.common.entity.TeamContext;
import com.eteam.common.entity.TeamContext;
import ${basepackage}.dao.read.${className}ReaderDao;
import ${basepackage}.dao.write.${className}WriterDao;
import ${basepackage}.service.${className}Service;


<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
@Service
@Transactional
public class ${className}ServiceImpl implements ${className}Service {
    Logger logger = LoggerFactory.getLogger(getClass());

	    @Autowired
	    ${className}ReaderDao ${classNameLower}ReaderDao;
	    @Autowired
	    ${className}WriterDao ${classNameLower}WriterDao;



	    @Resource(name = "component-db-iDGenerator")
	    private IDGenerator idDGenerator;

	    private String db_pre = "${table.sqlName}";

	    @Override
	    public List<${className}> getBy(${className} t, TeamContext context) {

	        return ${classNameLower}ReaderDao.getBy(t);
	    }

	    @Override
	    public ${className} getById(long id, TeamContext context) {

	        return ${classNameLower}ReaderDao.selectByPrimaryKey(id);
	    }

	    @Override
	    public PageBean<?> listPage(PageParam pageParam, Map<String, Object> paramMap, TeamContext context) {
	        
	        if (paramMap == null) {
	            paramMap = new HashMap<>();
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
	    public ${className} save(${className} t, TeamContext context) {

	        long id = idDGenerator.next(db_pre).id;
	        t.setId(id);
	        logger.debug("sequence:{}待保存的数据:{}", context, JSON.toJSONString(t));
	        int insertSelective = ${classNameLower}WriterDao.insertSelective(t);
	        
	        if (insertSelective > 0) {
	            return t;
	        } else {
	            return null;
	        }
	       
	    }

	    @Override
	    public ${className} update(final ${className} t, TeamContext context) {
	        int flag = ${classNameLower}WriterDao.updateByPrimaryKeySelective(t);
	        if (flag > 0) {
	            return t;
	        } else {
	            return null;
	        }
	    }


	    @Override
	    public ${className} getById(${className} t, TeamContext context) {
	        
	        return ${classNameLower}ReaderDao.getById(t);

	    }
}
