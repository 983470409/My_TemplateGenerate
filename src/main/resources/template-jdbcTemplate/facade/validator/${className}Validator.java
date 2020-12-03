
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

import ${basepackage}.common.constants.CenterCode;
import ${basepackage}.common.validator.BaseValidator;
import ${basepackage}.entity.${className};
import ${basepackage}.vo.${className}Vo;
import com.gzhc365.component.utils.entity.HcContext;
import org.springframework.stereotype.Component;

/**
 <#include "/java_description.include">
 */
@Component
public class ${className}Validator extends BaseValidator {

    public void validateDelete(Integer id, HcContext hcContext) {
        validateIntegerTypeIsNull(id, CenterCode.PARAM_NULL, "id");
        validateIntegerTypeIsError(id, CenterCode.PARAM_ERROR, "id");
    }

    public void validateAdd(${className} ${classNameLower}, HcContext hcContext) {
        validateObjectIsNull(${classNameLower}, CenterCode.PARAM_NULL, "${classNameLower}");
    }

    public void validateGetById(Integer id, HcContext hcContext) {
        validateIntegerTypeIsNull(id, CenterCode.PARAM_NULL, "id");
        validateIntegerTypeIsError(id, CenterCode.PARAM_ERROR, "id");
    }

    public void validateUpdate(${className} ${classNameLower}, HcContext hcContext) {
        validateObjectIsNull(${classNameLower}, CenterCode.PARAM_NULL, "${classNameLower}");
    }

    public void validatePage(${className}Vo ${classNameLower}Vo, HcContext hcContext) {
        validateObjectIsNull(${classNameLower}Vo, CenterCode.PARAM_NULL, "${classNameLower}Vo");
        validateIndexAndSize(${classNameLower}Vo);
    }
}