package myapp;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.HttpJspPage;


public abstract class HttpJspBase extends HttpServlet implements HttpJspPage {

    private static final long serialVersionUID = 1L;

    private ServletConfigWrapper wrappedConfig;

    protected HttpJspBase() {
    }

    @Override
    public final void init(ServletConfig config) throws ServletException {
        super.init(config);
        wrappedConfig = new ServletConfigWrapper(config);
        wrappedConfig.setServletContext(new ServletContextWrapper(config.getServletContext()));
        System.out.println("INIT DONE");
        jspInit();
        _jspInit();
    }

    @Override
    public String getServletInfo() {
        return "Localizer.getMessage(";
    }

    @Override
    public final void destroy() {
        jspDestroy();
        _jspDestroy();
    }

    @Override
    public final void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        _jspService(request, response);
    }

    @Override
    public void jspInit() {
    }

    public void _jspInit() {
    }

    @Override
    public void jspDestroy() {
    }

    protected void _jspDestroy() {
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("GETTING CONFIG!");
        Thread.dumpStack();
        return wrappedConfig;
    }

    @Override
    public abstract void _jspService(HttpServletRequest request,
                                     HttpServletResponse response)
        throws ServletException, IOException;
}