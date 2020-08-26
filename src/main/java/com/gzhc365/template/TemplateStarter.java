/**
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: gzhc365 </p>
 */
package com.gzhc365.template;

import cn.org.rapid_framework.generator.GeneratorFacade;


/**
 * 模板工程启动类
 * @author zhang_yx
 * @date 2020/7/1
 * @time 17:58
 * @since JDK 1.8
 */
public class TemplateStarter {

    public static void main(String[] args) throws Exception  {
        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().addTemplateRootDir(ClassLoader.getSystemResource("template-jdbcTemplate").getPath());
        // 删除生成器的输出目录//
        g.deleteOutRootDir();
        // 通过数据库表生成文件
//        g.generateByAllTable();
        // 需要生成的表 多個用,分開 如 "t_health_inquiry","t_health_inquiry_item"
//        g.generateByTable("t_logpaltform_service_type","t_logpaltform_judge_jgresult","t_logpaltform_service_judge","t_logpaltform_service_type","t_logpaltform_service_uri","t_logpaltform_uri","t_logpaltform_review");
//        g.generateByTable( "t_alarm_front_monitor_data","t_alarm_front_status","t_alarm_front_health_data","t_alarm_warning_threshold_his_health");
                g.generateByTable( "t_alarm_front_monitor_data","t_alarm_front_status","t_alarm_front_health_data","t_alarm_warning_threshold_his_health");
    }




}
