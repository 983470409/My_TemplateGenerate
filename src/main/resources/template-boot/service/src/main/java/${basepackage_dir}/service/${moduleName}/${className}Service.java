<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import com.mnt.sio.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.CollectionUtils;
import tech.jianxin.timeb.util.GuidUtil;
import tech.jianxin.timeb.util.TransferUtil;
import tech.jianxin.timeb.vo.paging.PagingUtil;
import ${basepackage}.dto.${moduleName}.${className}Dto;
import ${basepackage}.domain.${moduleName}.${className};
import ${basepackage}.mapper.${moduleName}.${className}Mapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 <#include "/java_description.include">
 */
@Slf4j
@Service
public class ${className}Service {

	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;

	/**
	 * 新增
	 * @param ${classNameLower}Dto
	 * @return
	 */
	public ${className}Dto create(${className}Dto ${classNameLower}Dto) {

		${className} ${classNameLower} = TransferUtil.transfer(${classNameLower}Dto, ${className}.class);
		${classNameLower}.setId(GuidUtil.guid());

		Date now = new Date();

		${classNameLower}.setCreateTime(now);
		${classNameLower}.setUpdateTime(now);

		${classNameLower}Mapper.insertSelective(${classNameLower});

		return TransferUtil.transfer(${classNameLower}, ${className}Dto.class);
	}

	/**
	 * 根据主键id获得数据
	 * @param id
	 * @return
	 */
	public ${className}Dto getById(String id) {

		${className} ${classNameLower} = ${classNameLower}Mapper.selectByPrimaryKey(id);

		return TransferUtil.transfer(${classNameLower}, ${className}Dto.class);
	}

	/**
	 * 条件获得单个数据
	 * @param ${classNameLower}Dto
	 * @return
	 */
	public ${className}Dto get${className}By(${className}Dto ${classNameLower}Dto) {

		${className} result = ${classNameLower}Mapper.getBy(${classNameLower}Dto);

		return TransferUtil.transfer(result, ${className}Dto.class);
	}

	/**
	 * 根据id删除数据
	 * @param id
	 * @return
	 */
	public void deleteById(String id) {
		${classNameLower}Mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 条件删除数据
	 * @param ${classNameLower}Dto
	 * @return
	 */
	public void deleteBy(${className}Dto ${classNameLower}Dto) {

		${classNameLower}Mapper.deleteSelective(${classNameLower}Dto);
	}

	/**
	 * 根据id列表量删除
	 * @param idList
	 * @return
	 */
	public void batchDelete(List<String> idList) {
		${classNameLower}Mapper.batchDelete(idList);
	}

	/**
	 * 更新
	 * @param ${classNameLower}Dto
	 * @return
	 */
	public ${className}Dto update(${className}Dto ${classNameLower}Dto) {

		${className} ${classNameLower} = TransferUtil.transfer(${classNameLower}Dto, ${className}.class);
		${classNameLower}.setUpdateTime(new Date());
		${classNameLower}Mapper.updateByPrimaryKeySelective(${classNameLower});

		return TransferUtil.transfer(${classNameLower}, ${className}Dto.class);
	}

	/**
	 * 批量新增
	 * @param ${classNameLower}DtoList
	 * @return
	 */
	public void batchCreate(List<${className}Dto> ${classNameLower}DtoList) {

		List<${className}> ${classNameLower}List = TransferUtil.transfer(${classNameLower}DtoList, ${className}.class);
		for (${className} ${classNameLower} : ${classNameLower}List) {
			${classNameLower}.setId(GuidUtil.guid());
			Date now = new Date();
			${classNameLower}.setCreateTime(now);
			${classNameLower}.setUpdateTime(now);
		}
		${classNameLower}Mapper.batchInsert(${classNameLower}List);
	}

	public List<${className}Dto> getBy(${className}Dto ${classNameLower}Dto) {

		List<${className}> resultList = ${classNameLower}Mapper.list(${classNameLower}Dto);

		return TransferUtil.transfer(resultList, ${className}Dto.class);
	}

	/**
	 * 根据主键id列表获得数据
	 * @param ids
	 * @return
	 */
	public List<${className}Dto> getByIds(List<String> ids) {

		if (CollectionUtils.isEmpty(ids)) return new ArrayList<>();
		List<${className}> resultList = ${classNameLower}Mapper.selectByPrimaryKeys(ids);

		return TransferUtil.transfer(resultList, ${className}Dto.class);
	}

	/**
	 * 分页
	 * @param pageIndex
	 * @param pageSize
	 * @param ${classNameLower}Dto
	 * @return
	 */
	public List<${className}Dto> list(int pageIndex, int pageSize, ${className}Dto ${classNameLower}Dto) {

		PagingUtil.reset();

		Page<${className}> page = PageHelper.startPage(pageIndex, pageSize);
		List<${className}> resultList = ${classNameLower}Mapper.list(${classNameLower}Dto);

		PagingUtil.set(page, resultList.size());

		log.info("service.${classNameLower}.list: pageIndex: " + pageIndex + ", pageSize"  + pageSize + ", ${classNameLower}Dto" + JsonUtil.asString(${classNameLower}Dto));

		return TransferUtil.transfer(resultList, ${className}Dto.class);
	}
}
