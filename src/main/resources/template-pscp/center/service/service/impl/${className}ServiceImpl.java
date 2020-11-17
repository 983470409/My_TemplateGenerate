<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzhc365.${deptFlag}.common.PageBean;
import ${basepackage}.dto.*;
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
	private ${className}ReaderDao ${classNameLower}ReaderDao;
	@Autowired
	private ${className}WriterDao ${classNameLower}WriterDao;

	/**
	 * 获取数据列表
	 * @param ${classNameLower}Vo
	 * @return
	 */
	@Override
	public List<${className}> get${className}sBy(${className}ListDto ${classNameLower}ListDto){
		return ${classNameLower}ReaderDao.get${className}s(${classNameLower}ListDto);
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
	public PageBean<${className}> listPage(${className}PageDto ${classNameLower}PageDto) {
		// 统计总记录数
		Long count = ${classNameLower}ReaderDao.listPageCount(${classNameLower}PageDto);
		// 获取分页数据集
		List<${className}> list = ${classNameLower}ReaderDao.listPage(${classNameLower}PageDto);
		// 构造分页对象
		return new PageBean<>(${classNameLower}PageDto.getPageIndex(), ${classNameLower}PageDto.getPageSize(), count.intValue(), list);
	}

	/**
	 * 新增对象
	 * @param ${classNameLower}
	 * @return
	 */
	@Override
	public ${className} save(${className} ${classNameLower}){
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
	public int update(${className} ${classNameLower}){
		return ${classNameLower}WriterDao.updateByPrimaryKeySelective(${classNameLower});
	}

	/**
	 * 删除对象
	 * @param ${classNameLower}
	 * @return
	 */
	@Override
	public int delete(${className} ${classNameLower}){
		return ${classNameLower}WriterDao.deleteSelective(${classNameLower});
	}

	/**
	 * 删除
	 * @param ${classNameLower}
	 * @return
	 */
	@Override
	public int deleteById(Long id){
		return ${classNameLower}WriterDao.deleteByPrimaryKey(id);
	}

	/**
	 * 根据主键id列表获得数据
	 * @param ids
	 * @return
	 */
	@Override
	public List<${className}> selectByPrimaryKeys(List<String> ids){
		return ${classNameLower}ReaderDao.selectByPrimaryKeys(ids);
	}
}
