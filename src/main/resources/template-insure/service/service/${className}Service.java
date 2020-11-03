<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gzhc365.insurance.profile.request.*;
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.po.${className};
import ${basepackage}.dao.${className}ReaderDao;
import ${basepackage}.dao.${className}WriterDao;
import java.util.List;
import org.springframework.beans.BeanUtils;
import ${basepackage}.utils.BeanConvertUtils;
import ${basepackage}.vo.PageBean;
import ${basepackage}.vo.${className}PagingQueryVo;


/**
 <#include "/java_description.include">
 */
@Service
public class ${className}Service{

	private static final Logger logger = LoggerFactory.getLogger(${className}Service.class);

	@Autowired
	private ${className}ReaderDao ${classNameLower}ReaderDao;
	@Autowired
	private ${className}WriterDao ${classNameLower}WriterDao;

	/**
	 * 获取数据
	 * @param ${classNameLower}QueryReq
	 * @return
	 */
	public List<${className}> get${className}sBy(${className}QueryReq ${classNameLower}QueryReq){
		${className} ${classNameLower} = new ${className}();
		BeanUtils.copyProperties(${classNameLower}QueryReq, ${classNameLower});
		return ${classNameLower}ReaderDao.get${className}s(${classNameLower});
	}

	/**
	 * 通过主键id获得数据
	 * @param id
	 * @return
	 */
	public ${className}Vo getById(long id) {
		return ${classNameLower}ReaderDao.selectByPrimaryKey(id);
	}


	/**
	 * 添加
	 * @param ${classNameLower}AddReq
	 * @return
	 */
	public Long add(${className}AddReq ${classNameLower}AddReq) {
		${className} ${classNameLower} = new ${className}();
		BeanUtils.copyProperties(${classNameLower}AddReq, ${classNameLower});
		${classNameLower}WriterDao.insertSelective(${classNameLower});
		return ${classNameLower}.getId();
	}

	/**
	 * 更新数据
	 * @param ${classNameLower}UpdateReq
	 */
	public void update${className}(${className}UpdateReq ${classNameLower}UpdateReq) {
		${className} ${classNameLower} = new ${className}();
		BeanUtils.copyProperties(${classNameLower}UpdateReq, ${classNameLower});
		${classNameLower}WriterDao.updateByPrimaryKeySelective(${classNameLower});
	}

	/**
	 * 删除
	 * @param id
	 */
	public void delete${className}(Long id) {
		${classNameLower}WriterDao.deleteByPrimaryKey(id);
	}


	/**
	 * 分页获取数据
	 * @param ${classNameLower}PagingQueryVo
	 * @return
	 */
	public PageBean<${className}Vo> paging(${className}PagingQueryVo ${classNameLower}PagingQueryVo) {
		// 统计总记录数
		Long count = ${classNameLower}ReaderDao.listPageCount(${classNameLower}PagingQueryVo);
		// 获取分页数据集
		List<${className}Vo> list = BeanConvertUtils.copyList(${classNameLower}ReaderDao.listPage(${classNameLower}PagingQueryVo),${className}Vo.class);
		// 构造分页对象
		return new PageBean<>(${classNameLower}PagingQueryVo.getPageIndex(), ${classNameLower}PagingQueryVo.getPageSize(), count.intValue(), list);
	}

}
