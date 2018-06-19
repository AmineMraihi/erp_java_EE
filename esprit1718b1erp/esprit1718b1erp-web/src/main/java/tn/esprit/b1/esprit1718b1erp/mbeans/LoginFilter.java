package tn.esprit.b1.esprit1718b1erp.mbeans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("url = " + ((HttpServletRequest) request).getRequestURL());

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        Identity identity = (Identity) servletRequest.getSession().getAttribute("identity");
        if ((identity != null && identity.getIsLogged())
                || servletRequest.getRequestURL().toString().contains("login.jsf")) {
            chain.doFilter(servletRequest, servletResponse);
        }else {
            servletResponse.sendRedirect(servletRequest.getContextPath()+"/login.jsf");
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
