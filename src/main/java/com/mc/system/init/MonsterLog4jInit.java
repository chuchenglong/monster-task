package com.mc.system.init;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.net.URL;

/**
 * @author ChenglongChu
 * @description log4j加载
 * @create 2017/09/19 14:07
 * @since v1.0
 */
public class MonsterLog4jInit extends HttpServlet {
    public void init() throws ServletException {
        ClassLoader classLoader = MonsterLog4jInit.class.getClassLoader();
        URL resource = classLoader.getResource("log4j.properties");
        String path = resource.getPath();
        // if the log4j-init-file is not set, then no point in trying
        if (path != null) {
            PropertyConfigurator.configure(path);
        }
    }
}
