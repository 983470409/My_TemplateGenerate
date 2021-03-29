<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.gzhc365.alarm.common.util.JdbcUtil;
import org.apache.commons.lang3.StringUtils;
import ${basepackage}.vo.${className}Vo;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
<#include "/java_imports.include">

/**
 <#include "/java_description.include">
 */
@Repository
public class ${className}Dao {

	private static final Logger logger = LoggerFactory.getLogger( ${className}Dao.class);

	private static final RowMapper<${className}> ${classNameLower}RowMapper = BeanPropertyRowMapper.newInstance(${className}.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * 根据ids获得数据
	 * @param id
	 * @return
	 */
	public List<${className}> getByIds(Integer[] id){
		String sql = "select " +Sql.BASE + " from ${table.sqlName} where id in (" + JdbcUtil.placeHolder(id.length) + ")";
		return jdbcTemplate.query(sql,${classNameLower}RowMapper,id);
	}

	/**
	 * 依据id删除
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id){
		String sql = "delete from ${table.sqlName} where id=?;";
		return jdbcTemplate.update(sql,id);
	}

	/**
	 * 添加数据
	 * @param ${classNameLower}
	 * @return
	 */
	public Integer add(${className} ${classNameLower}){
		return namedParameterJdbcTemplate.update(Sql.ADD,JdbcUtil.getSqlParameterSource(${classNameLower}));
	}

	/**
	 * 根据id获得数据
	 * @param id
	 * @return
	 */
	public ${className} getById(Integer id){
		return JdbcUtil.queryForObject(jdbcTemplate,Sql.FINDBYID , ${classNameLower}RowMapper,id);
	}


	/**
	 * 更新
	 * @param ${classNameLower}
	 * @return
	 */
	public Integer update(${className} ${classNameLower}){
		return namedParameterJdbcTemplate.update(Sql.UPDATE,JdbcUtil.getSqlParameterSource(${classNameLower}));
	}

	/**
	 * 分页条件查询信息
	 * @param ${classNameLower}Vo
	 * @return
 	*/
	public List<${className}> paging(${className}Vo ${classNameLower}Vo){
		StringBuilder builder = new StringBuilder(Sql.PAGING);
		<#list table.columns as column>
		<#if column.sqlName != "id">
		<#if column.isStringColumn>
		if (StringUtils.isNotBlank(${classNameLower}Vo.get${column.columnName}())){
			builder.append(" and ${column.sqlName} = :${column.columnNameFirstLower} ");
		}
		</#if>
		<#if !column.isStringColumn>
		if (${classNameLower}Vo.get${column.columnName}() != null){
			builder.append(" and ${column.sqlName} = :${column.columnNameFirstLower} ");
		}
		</#if>
		</#if>
		</#list>
		builder.append(" limit :start,:endRow");
		return namedParameterJdbcTemplate.query(builder.toString(), JdbcUtil.getSqlParameterSource(${classNameLower}Vo),${classNameLower}RowMapper);
	}

	/**
	 * 查询总记录数
	 * @return
	 */
	public Integer count(${className}Vo ${classNameLower}Vo){
		StringBuilder builder = new StringBuilder(Sql.COUNT);
		<#list table.columns as column>
		<#if column.sqlName != "id">
		<#if column.isStringColumn>
		if (StringUtils.isNotBlank(${classNameLower}Vo.get${column.columnName}())){
			builder.append(" and ${column.sqlName} = :${column.columnNameFirstLower} ");
		}
		</#if>
		<#if !column.isStringColumn>
		if (${classNameLower}Vo.get${column.columnName}() != null){
			builder.append(" and ${column.sqlName} = :${column.columnNameFirstLower} ");
		}
		</#if>
		</#if>
		</#list>
		return namedParameterJdbcTemplate.queryForObject(builder.toString(), JdbcUtil.getSqlParameterSource(${classNameLower}Vo),Integer.class);
	}

	/**
	 * 查询所有的收集器
	 * @return
	 */
	public List<${className}> findAll(){
		String sql = "select "+Sql.BASE+" from ${table.sqlName}";
		return jdbcTemplate.query(sql, ${classNameLower}RowMapper);
	}


private static final class Sql{
	private static final String BASE =	"<#list table.columns as column>${column.sqlName}<#if column_has_next>,</#if></#list>";
	private static final String ADD = "insert into ${table.sqlName} (<#list table.columns as column><#if column.sqlName != "id" && column.sqlName != "create_time" && column.sqlName != "update_time">${column.sqlName}<#if column_has_next>,</#if></#if></#list>)"
			+ "values (<#list table.columns as column><#if column.sqlName != "id" && column.sqlName != "create_time" && column.sqlName != "update_time">:${column.columnNameFirstLower}<#if column_has_next>,</#if></#if></#list>)";
	private static final String UPDATE= "UPDATE ${table.sqlName} set "
			+"<#list table.columns as column><#if column.sqlName != "id" && column.sqlName != "create_time" && column.sqlName != "update_time">${column.sqlName}=ifnull(:${column.columnNameFirstLower},${column.sqlName})<#if column_has_next>,</#if></#if></#list>"
			+"WHERE id = :id";
	private static final String PAGING= "select " + BASE + " from ${table.sqlName} where 1 = 1";
	private static final String FINDBYID = "select " + BASE + " from ${table.sqlName} where id = ?";
	private static final String COUNT = "select count(*) from ${table.sqlName} where 1 = 1";
}
}
