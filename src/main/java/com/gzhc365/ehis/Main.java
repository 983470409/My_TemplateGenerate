/**
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: gzhc365 </p>
 */
package com.gzhc365.ehis;

import cn.org.rapid_framework.generator.GeneratorFacade;


/**
 *
 * @author zihong
 * @date: 2018年4月8日 下午2:06:44 * @version 1.0
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
//g.generateByTable("t_hc_consultant","t_hc_consultation","t_hc_consultation_item","t_hc_his_union","t_hc_his_union_member");
// 需要生成的表 多個用,分開 如 "t_health_inquiry","t_health_inquiry_item"
//g.generateByAllTable();
        g.generateByTable("t_logpaltform_judge");


   	Long i = 9223372036854775807l;
        int i1 = (int) (i & 0x00000000ffffffffL); //低32位
        int i2 = (int) (i >> 32); //高32位
        System.out.println("i1:" + i1 + "\ti2:" + i2);
        long l1 = (i2 & 0x000000ffffffffL) << 32;
        long l2 = i1 & 0x00000000ffffffffL;
        long l = l1 | l2;
        
        long hash1 =  i.intValue();
        int hash2 = (int) (i >>> 32);
        long longValue = 9223372036854775807l;
        cal(longValue );
        
   	 
 
         
    
   
}

public static void cal(long longValue) {
    if(longValue > Integer.MAX_VALUE) {
        
        long aa = longValue / 4294967296l;
        long bb = longValue % 4294967296l;
    }
   
    
}

}
