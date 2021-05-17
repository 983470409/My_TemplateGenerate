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
        g.getGenerator().addTemplateRootDir(ClassLoader.getSystemResource("template-hdj").getPath());
        // 删除生成器的输出目录//
        g.deleteOutRootDir();
//        g.generateByTable("t_fusing_switch","t_bizfusing_mapping","t_gwfusing_profile");
//        g.generateByTable("t_hc_leader","t_hc_team","t_hc_member","t_hc_member_apply","t_hc_team_source","t_hc_lead_apply","t_hc_team_notice","t_hc_team_notice_read");
//          g.generateByTable("t_hc_lead_apply","t_hc_leader");
//        g.generateByTable("t_hc_video","t_hc_video_file_directory","t_hc_user_address");
//        g.generateByTable("t_hc_miniapp_live_invite_member","t_hc_miniapp_live_room_info","t_hc_miniapp_live_user_coupon","t_hc_miniapp_live_user_learn","t_hc_miniapp_live_user_room");

//        g.generateByAllTable();
//        g.generateByTable("t_hc_hdj_nurse_order_comment","t_hc_hdj_his_patient_relation","t_hc_hdj_patient_contagion_record");
        g.generateByTable("t_hc_hdj_shop");



    }







}
