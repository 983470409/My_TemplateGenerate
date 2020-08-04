<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;


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
public class  ${className}Service {
	private static final Logger logger = LoggerFactory.getLogger(${className}Service.class);

	@Autowired
	private ${className}Facade ${classNameLower}Facade;

@ResponseBody
@RequestMapping("/add")
public ApiResult add${className}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
		ApiResult apiResult = new ApiResult(0, "新增成功");
		try{
		${classNameLower}Facade.save(${classNameLower}Vo);
		}catch (Exception e){
		logger.error("/add方法系统异常，请稍后重试", e);
		apiResult = ApiResult.error("新增失败");
		}
		return apiResult;
		}

@ResponseBody
@RequestMapping("/update")
public ApiResult update${className}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
		ApiResult apiResult = new ApiResult(0, "更新成功");
		try{
		${classNameLower}Facade.update(${classNameLower}Vo);
		}catch (Exception e){
		logger.error("/update方法系统异常，请稍后重试", e);
		apiResult = ApiResult.error("更新失败");
		}
		return apiResult;
		}

@ResponseBody
@RequestMapping("/delete")
public ApiResult delete${className}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
		ApiResult apiResult = new ApiResult(0, "删除成功");
		try{
		${classNameLower}Facade.delete(${classNameLower}Vo);
		}catch (Exception e){
		logger.error("/delete方法系统异常，请稍后重试:{}", e);
		apiResult = ApiResult.error("删除失败");
		}
		return apiResult;
		}

@ResponseBody
@RequestMapping("/page")
public ApiResult page(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
		ApiResult apiResult = new ApiResult();
		try{
		PageBean<?> listPage = ${classNameLower}Facade.listPage(${classNameLower}Vo).getData();
		apiResult.setData(listPage);
		}catch (Exception e){
		logger.error("/page方法系统异常，请稍后重试,{}", e);
		apiResult = ApiResult.error("分页失败");
		}
		return apiResult;
		}


@ResponseBody
@RequestMapping("/get${classNameLower}s")
public ApiResult ${classNameLower}s(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
		ApiResult apiResult = new ApiResult();
		try{
		List<${className}> ${classNameLower}s = ${classNameLower}Facade.get${className}s(${classNameLower}Vo).getData();
		apiResult.setData(${classNameLower}s);
		}catch (Exception e){
		logger.error("/get${classNameLower}s:方法系统异常，请稍后重试,{}", e);
		apiResult = ApiResult.error("获取数据失败");
		}
		return apiResult;
		}

@ResponseBody
@RequestMapping("/get${classNameLower}")
public ApiResult ${classNameLower}(HttpServletRequest request, HttpServletResponse response, ${className}Vo ${classNameLower}Vo) {
		ApiResult apiResult = new ApiResult();
		try{
		${className} ${classNameLower} = ${classNameLower}Facade.get${className}(${classNameLower}Vo).getData();
		apiResult.setData(${classNameLower});
		}catch (Exception e){
		logger.error("/get${classNameLower}方法系统异常，请稍后重试,{}", e);
		apiResult = ApiResult.error("获取数据失败");
		}
		return apiResult;
		}

		@ResponseBody
		@RequestMapping("/get${classNameLower}byid")
		public ApiResult ${classNameLower}(HttpServletRequest request, HttpServletResponse response, Long id) {
			ApiResult apiResult = new ApiResult();
			try{
				${className} ${classNameLower} = ${classNameLower}Facade.get${className}ById(id).getData();
				apiResult.setData(${classNameLower});
			}catch (Exception e){
				logger.error("/get${classNameLower}byid:方法系统异常，请稍后重试,{}", e);
				apiResult = ApiResult.error("获取数据失败");
			}
			return apiResult;
		}
}
