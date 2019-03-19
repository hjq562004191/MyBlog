package com.myblog.Servlet;

import com.myblog.Pojo.Blog;
import com.myblog.Service.UserService;
import com.myblog.Service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SuppressWarnings("all")
@WebServlet(name = "BolgServlet" , urlPatterns = "/boke/*")
public class BlogServlet extends HttpServlet {

    UserService us = new UserServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        String url1 = req.getRequestURI();
        String[] url2 = url1.split("/");
        String url = url2[2];

        String oper = url;

        if (oper.equals("write")){
            writeblog(req,resp);
        }else if (oper.equals("myblog")){
            myblog(req,resp);
        }else if (oper.equals("delete")){
            Deleteblog(req,resp);
        }else if (oper.equals("showallblog")){
            Allblog(req,resp);
        }else if (oper.equals("showmyblog")){
            Showmyblog(req,resp);
        }else if (oper.equals("updatablog")){
            Updatablog(req,resp);
        }else if (oper.equals("main")){
            main(req,resp);
        }
    }

    private void main(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession hs = req.getSession();
        List<Blog> list = userService.allblog();
        if (list !=null)
            for (Blog b:list
                    ) {
                String s2 = b.getMarkdown();
                String reg = "[^0-9a-zA-Z\u4e00-\u9fa5]+";
                String s1 = s2.replaceAll(reg,"");
                if (s1.length()>251){
                    s1 = s1.substring(0,251);
                    s1+="...";
                }
                b.setIntroduction(s1);
            }

        hs.setAttribute("allblog",list);
        resp.sendRedirect("/main.jsp");
        return;
    }

    private void Updatablog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("id");
        int id = Integer.parseInt(s);
        UserService us = new UserServiceImpl();

        String title = req.getParameter("title");
        String markdown = req.getParameter("markdown");
        String essay = req.getParameter("essay");

        us.updatablog(title,markdown,essay,id);

        resp.sendRedirect("/main.jsp");
        return;
    }

    private void Showmyblog(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String s = req.getParameter("id2");
        int id = Integer.parseInt(s);

        HttpSession hs = req.getSession();
        List<Blog> list = (List<Blog>) hs.getAttribute("myblog");

        for (Blog b:list
                ) {
            if (b.getId() == id){
                hs.setAttribute("seeblog",b);
                resp.sendRedirect("/showmyblog.jsp");
                return;
            }
        }
    }

    private void Allblog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("id3");
        int id = Integer.parseInt(s);

        Blog b = userService.Getblog(id);

        HttpSession hs = req.getSession();
        if (b!=null) {
            hs.setAttribute("seeblog2", b);
            resp.sendRedirect("/showallblog.jsp");
            return;
        }
        }

    private void Deleteblog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("id");
        int id = Integer.parseInt(s);
        UserService us = new UserServiceImpl();

        us.deleteblog(id);
        HttpSession hs = req.getSession();
        List<Blog> list = userService.allblog();
        if (list !=null)
            for (Blog b:list
                    ) {
                String s2 = b.getMarkdown();
                String reg = "[^0-9a-zA-Z\u4e00-\u9fa5]+";
                String s1 = s2.replaceAll(reg,"");
                if (s1.length()>251){
                    s1 = s1.substring(0,251);
                    s1+="...";
                }
                b.setIntroduction(s1);
            }

            hs.setAttribute("allblog",list);
        resp.sendRedirect("/main.jsp");
        return;
    }


    private void myblog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        int aid = (int) hs.getAttribute("id");
        List<Blog> list = us.myblog(aid);

        if (list !=null) {
            hs.setAttribute("myblog", list);
            resp.sendRedirect("/myblog.jsp");
            return;
        }

    }

    private void writeblog(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String author = req.getParameter("author");
        String title = req.getParameter("title");
        String markdown = req.getParameter("markdown");
        String essay = req.getParameter("essay");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

        HttpSession hs = req.getSession();
        hs.setAttribute("author",author);
        hs.setAttribute("title",title);
        hs.setAttribute("aid",hs.getAttribute("id"));
        hs.setAttribute("date",date);
        hs.setAttribute("essay",essay);

        Blog blog = new Blog();
        blog.setAid((Integer) hs.getAttribute("id"));
        blog.setAuthor(author);
        blog.setTitle(title);
        blog.setDate(date);
        blog.setMarkdown(markdown);
        blog.setEssay(essay);

        us.writeblog(blog);
        List<Blog> list = userService.allblog();
        if (list !=null) {
            for (Blog b:list
                    ) {
                String s2 = b.getMarkdown();
                String reg = "[^0-9a-zA-Z\u4e00-\u9fa5]+";
                String s1 = s2.replaceAll(reg,"");
                if (s1.length()>251){
                    s1 = s1.substring(0,251);
                    s1+="...";
                }
                b.setIntroduction(s1);
            }
            hs.setAttribute("allblog", list);
            resp.sendRedirect("/main.jsp");
            return;
        }
    }



}
