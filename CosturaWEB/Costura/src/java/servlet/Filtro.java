/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Morgana
 */
/**
 * Esse trecho de código deve existir para aplicar o filtro para as paginas
 */
//@WebFilter("/*")

public class Filtro extends HttpServlet implements Filter {

    List<String> urls = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urls.add("/Costura/");
        urls.add("/Costura/Controle");
        urls.add("/Costura/index.jsp");
        urls.add("/Costura/login.jsp");
        urls.add("/Costura/login.jsp");
        urls.add("/Costura/bootstrap/*");
        urls.add("/Costura/build/*");
        urls.add("/Costura/dist/*");
        urls.add("/Costura/plugins/*");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // verifica se URL requisitada consta na lista de URLs permitidas
        // caso afirmativo, envia para página de Login
        if (urls.contains(req.getRequestURI())) {
            request.setAttribute("parametro", "login");
            chain.doFilter(request, response);
        } else {
            HttpSession sessao = ((HttpServletRequest) request).getSession();

            // caso não pertença a lista, verifica se há usuário na sessão
            // se não houver, encaminha para o Login
            if (sessao.getAttribute("usuarioLogado") == null) {
                ((HttpServletResponse) response).sendRedirect("login.jsp");
            } else {
                // se usuário estiver logado, apenas abra a página solicitada
                System.out.println("Destino: " + req.getRequestURI());
                chain.doFilter(request, response);
            }
        }
    }

}
