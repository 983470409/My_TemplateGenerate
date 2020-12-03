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
        g.getGenerator().addTemplateRootDir(ClassLoader.getSystemResource("template-pscp").getPath());
        // 删除生成器的输出目录//
        g.deleteOutRootDir();
        g.generateByTable("t_pscpopen_his_dict");
//        g.generateByAllTable();

    }




}
