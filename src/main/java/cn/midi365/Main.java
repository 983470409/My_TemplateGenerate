/**
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: gzhc365 </p>
 */
package cn.midi365;

import cn.org.rapid_framework.generator.GeneratorFacade;


/**
 *
 * @author zihong
 * @date: 2018年4月8日 下午2:06:44
 * @version 1.0
 * @since JDK 1.7
 */
public class Main { 

    public static void main(String[] args) throws Exception  {
        GeneratorFacade g = new GeneratorFacade();
        g.getGenerator().addTemplateRootDir(ClassLoader.getSystemResource("template-boot").getPath());
        // 删除生成器的输出目录//
        g.deleteOutRootDir();
        // 通过数据库表生成文件
        // 自动搜索数据库中的所有表并生成文件,template为模板的根目录
//         g.generateByAllTable();
         
        // 按table名字删除文件
//g.generateByTable("t_uc_recipient");
 //需要生成的表 多個用,分開 如 "t_health_inquiry","t_health_inquiry_item"
g.generateByTable("t_health_inquiry");

         
    }

}
