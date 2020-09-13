<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.jianxin.timeb.util.GuidUtil;
import tech.jianxin.timeb.util.TransferUtil;
import tech.jianxin.timeb.vo.paging.PagingUtil;
import ${basepackage}.dto.${moduleName}.${className}Dto;
import ${basepackage}.domain.${moduleName}.${className};
import ${basepackage}.mapper.${moduleName}.${className}Mapper;
import java.util.Date;
import java.util.List;

<#include "/java_imports.include">

/**
 <#include "/java_description.include">
 */
@Slf4j
@Service
public class ${className}ServiceImpl {

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

		${classNameLower}Mapper.insert(${classNameLower});

		return TransferUtil.transfer(${classNameLower}, DemoDto.class);
	}

	public DemoDto getById(String id) {

		Demo demo = demoMapper.selectByPrimaryKey(id);

		return TransferUtil.transfer(demo, DemoDto.class);
	}

	public DemoDto getDemoBy(DemoDto demoDto) {

		Demo demo = TransferUtil.transfer(demoDto, Demo.class);
		Demo result = demoMapper.getDemoBy(demo);

		return TransferUtil.transfer(result, DemoDto.class);
	}

	public void deleteById(String id) {
		demoMapper.deleteByPrimaryKey(id);
	}

	public void deleteBy(DemoDto demoDto) {
		Demo demo = TransferUtil.transfer(demoDto, Demo.class);
		demoMapper.deleteSelective(demo);
	}

	public void batchDelete(List<String> idList) {
		demoMapper.batchDelete(idList);
	}

	public DemoDto create(DemoDto demoDto) {

		Demo demo = TransferUtil.transfer(demoDto, Demo.class);
		demo.setId(GuidUtil.guid());

		Date now = new Date();

		demo.setCreateTime(now);
		demo.setUpdateTime(now);

		demoMapper.insert(demo);

		return TransferUtil.transfer(demo, DemoDto.class);
	}

	public DemoDto update(DemoDto demoDto) {

		Demo demo = TransferUtil.transfer(demoDto, Demo.class);
		demo.setUpdateTime(new Date());
		demoMapper.updateByPrimaryKeySelective(demo);

		return TransferUtil.transfer(demo, DemoDto.class);
	}

	public void batchCreate(List<DemoDto> demoDtoList) {

		List<Demo> demoList = TransferUtil.transfer(demoDtoList, Demo.class);
		for (Demo demo : demoList) {
			demo.setId(GuidUtil.guid());
			Date now = new Date();
			demo.setCreateTime(now);
			demo.setUpdateTime(now);
		}
		demoMapper.batchInsert(demoList);
	}

	public List<DemoDto> list(int pageIndex, int pageSize, DemoDto demoDto) {

		PagingUtil.reset();

		Demo demo = TransferUtil.transfer(demoDto, Demo.class);
		Page<Demo> page = PageHelper.startPage(pageIndex, pageSize);
		List<Demo> resultList = demoMapper.list(demo);

		PagingUtil.set(page, resultList.size());

		log.info("service.demo.list: pageIndex: " + pageIndex + ", pageSize"  + pageSize + ", demoDto" + JsonUtil.asString(demoDto));

		return TransferUtil.transfer(resultList, DemoDto.class);
	}
}
