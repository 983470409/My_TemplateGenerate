<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzhc365.${deptFlag}.common.PageBean;
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.entity.${className};
import ${basepackage}.dao.read.${className}ReaderDao;
import ${basepackage}.dao.write.${className}WriterDao;
import ${basepackage}.service.${className}Service;
import java.util.List;

<#include "/java_imports.include">

/**
 <#include "/java_description.include">
 */
@Service
public class ${className}ServiceImpl implements ${className}Service {
	private static final Logger logger = LoggerFactory.getLogger(${className}ServiceImpl.class);


	@Autowired
	${className}ReaderDao ${classNameLower}ReaderDao;
	@Autowired
	${className}WriterDao ${classNameLower}WriterDao;

	/**
	 * 获取数据
	 * @param ${classNameLower}Vo
	 * @return
	 */
	@Override
	public List<${className}> get${className}sBy(${className}Vo ${classNameLower}Vo){
		return ${classNameLower}ReaderDao.get${className}s(${classNameLower}Vo);
	}

	/**
	 * 通过主键id获得数据
	 * @param id
	 * @return
	 */
	@Override
	public ${className} getById(long id) {
		return ${classNameLower}ReaderDao.selectByPrimaryKey(id);
	}

	/**
	 * 分页获取数据
	 * @param ${classNameLower}Vo
	 * @return
	 */
	@Override
	public PageBean<${className}> listPage(${className}Vo ${classNameLower}Vo) {
//		Map<String,Object>  paramMap = null;
//		if (pageParam.getParamMap() == null) {
//			 paramMap = new HashMap<>();
//		}else {
//			paramMap = pageParam.getParamMap();
//		}
//	   	// 根据页面传来的分页参数构造SQL分页参数
//		paramMap.put("pageFirst", (pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
//		paramMap.put("pageSize", pageParam.getNumPerPage());
//
//	 	// 统计总记录数
//		Long count = ${classNameLower}ReaderDao.listPageCount(paramMap);
//		// 获取分页数据集
//		List<${className}> list = ${classNameLower}ReaderDao.listPage(paramMap);
//		// 构造分页对象
//		return new PageBean<>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
		return null;
	}

	/**
	 * 新增对象
	 * @param ${classNameLower}
	 * @return
	 */
	@Override
	public ${className} save(${className} ${classNameLower}) {
		int insertSelective = ${classNameLower}WriterDao.insertSelective(${classNameLower});
		if (insertSelective > 0) {
			return ${classNameLower};
		} else {
			return null;
		}

	}

	/**
	 * 更新对象
	 * @param ${classNameLower}
	 * @return
	 */
	@Override
	public ${className} update(${className} ${classNameLower}){
		int flag = ${classNameLower}WriterDao.updateByPrimaryKeySelective(${classNameLower});
		if (flag > 0) {
			return ${classNameLower};
		} else {
			return null;
		}
	}

	/**
	 * 删除对象
	 * @param ${classNameLower}
	 * @return
	 */
	@Override
	public ${className} delete(${className} ${classNameLower}){
		int flag = ${classNameLower}WriterDao.deleteSelective(${classNameLower});
		if (flag > 0) {
			return ${classNameLower};
		} else {
			return null;
		}
	}


	/**
	 * 通过Vo获得单个对象
	 * @param ${classNameLower}Vo
	 * @return
	 */
	@Override
	public ${className} get${className}By(${className}Vo ${classNameLower}Vo) {
		return ${classNameLower}ReaderDao.get${className}By(${classNameLower}Vo);
	}
}
