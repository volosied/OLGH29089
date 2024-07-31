package myapp;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;;

public class ServletConfigWrapper implements ServletConfig {

    private ServletContextWrapper context = null;
    private ServletConfig config = null;

    public ServletConfigWrapper(ServletConfig config){
        this.config = config;
    }

    @Override
    public ServletContext getServletContext() {
        return (ServletContext) context;
        // return context.getServletContext();
    }

    public void setServletContext(ServletContextWrapper context) {

        this.context = context;
    }

    @Override
    public String getServletName() {
        return config.getServletName();
    }

    @Override
    public String getInitParameter(String name) {
        return config.getInitParameter(name);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return config.getInitParameterNames();
    }

}
