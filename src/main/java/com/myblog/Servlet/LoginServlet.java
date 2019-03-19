package com.myblog.Servlet;


import com.myblog.Pojo.Blog;
import com.myblog.Pojo.User;
import com.myblog.Service.UserService;
import com.myblog.Service.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet" , urlPatterns = "/user/*")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        String url1 = req.getRequestURI();
        String[] url2 = url1.split("/");
        String url = url2[2];

        HttpSession hs = req.getSession();
        List<Blog> list = userService.allblog();
        if (list !=null) {
            for (Blog b:list
                 ) {
                String s = b.getMarkdown();
                String reg = "[^0-9a-zA-Z\u4e00-\u9fa5]+";
                String s1 = s.replaceAll(reg,"");
                if (s1.length()>251){
                    s1 = s1.substring(0,251);
                    s1+="...";
                }
                b.setIntroduction(s1);
            }
            hs.setAttribute("allblog", list);
        }
        String oper = url;
        System.out.println(oper);
        if ("login".equals(oper)){
            checkUserLogin(req,resp);
        } else if ("pwd".equals(oper)){
            pwd(req,resp);
        }else if ("changeinfo".equals(oper)){
            ChangeInfo(req,resp);
        }else if ("reg".equals(oper)){
            UserReg(req,resp);
        }else if ("tourist".equals(oper)){
            Tourist(req,resp);
        }else if ("out".equals(oper)){
            userout(req,resp);
        }


    }

    private void userout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            HttpSession hs = req.getSession();
            hs.invalidate();

            resp.sendRedirect("/login.jsp");
            return;
    }

    private void Tourist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession hs = req.getSession();

        hs.setAttribute("id",0);
        hs.setAttribute("tour",1);

        resp.sendRedirect("/main.jsp");
        return;
    }

    private void UserReg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("regname");
        String sex = req.getParameter("regsex");
        String birthday = req.getParameter("regbirthday");
        String personal = req.getParameter("regpersonal");
        String pwd = req.getParameter("regpwd");

        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setPersonal(personal);

        userService.reguser(user);

        resp.sendRedirect("/login.jsp");
        return;
    }

    private void ChangeInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession hs = req.getSession();
        User user = (User) hs.getAttribute("user");
        String newname = req.getParameter("newname");
        String newsex = req.getParameter("newsex");
        String newbirthday = req.getParameter("newbirthday");
        String newpersonal = req.getParameter("newpersonal");

        user.setName(newname);
        user.setSex(newsex);
        user.setBirthday(newbirthday);
        user.setPersonal(newpersonal);

        hs.setAttribute("user",user);
        hs.setAttribute("name",user.getName());
        hs.setAttribute("sex",user.getSex());
        hs.setAttribute("birthday",user.getBirthday());
        hs.setAttribute("personal",user.getPersonal());

        userService.changeinfo(user);


        resp.sendRedirect("/main.jsp");
        return;
    }

    private void pwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String newpwd = req.getParameter("newpwd");

        HttpSession hs = req.getSession();

        User user = (User) hs.getAttribute("user");
        int id = user.getId();

        int i = userService.pwd(newpwd,id);

        if (i>0){
            HttpSession h = req.getSession();
            h.setAttribute("pwd","true");
        }
        resp.sendRedirect("/login.jsp");
        return;
    }

    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        User u = userService.checkUserLoginService(name,pwd);

        HttpSession hs = req.getSession();

        hs.setAttribute("tour",null);
        if (u != null){
            hs.setAttribute("user",u);
            hs.setAttribute("name",u.getName());
            hs.setAttribute("sex",u.getSex());
            hs.setAttribute("birthday",u.getBirthday());
            hs.setAttribute("personal",u.getPersonal());
            hs.setAttribute("id",u.getId());
            hs.setAttribute("pwd",u.getPwd());

            resp.sendRedirect("/main.jsp");
            return;
        }else {
            hs.setAttribute("flag",0);
            resp.sendRedirect("/login.jsp");
            return;
        }
    }
}
