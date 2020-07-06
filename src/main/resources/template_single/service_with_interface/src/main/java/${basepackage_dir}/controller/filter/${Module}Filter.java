/**
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: gzhc365 </p>
 */
package ${basepackage}.controller.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eteam.common.entity.TeamContext;
import com.eteam.common.helper.TeamContextHelper;
import com.eteam.common.utils.JsonRespTool;
import com.eteam.common.utils.Utils;

/**
 * Description: 营销小程序过滤器
 * 
 * @author ${author}
 * @date: 2018年4月10日 下午2:38:37
 * @version 1.0
 * @since JDK 1.7
 */
public class ${Module}Filter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(${Module}Filter.class);

    private String[] oauthUrl = { "/qy/api/oauth" };


    /**
     *
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        logger.info("-------------------doFilter Request started:---------------------");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        // 获取请求的Url
        logger.info("访问链接地址：{} 参数: {} {} ", request.getRequestURL() + "?" + request.getQueryString(),
                JSONObject.toJSONString(request.getParameterMap()));
        String requestURI = request.getRequestURI();
        String encodedUrl = request.getParameter("url");
        try {

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            logger.error("参数异常：e:{}", e);
            JsonRespTool.writeJson(response, "{\"code\":-1,\"msg\":\"参数异常!\"}");
            return;
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
