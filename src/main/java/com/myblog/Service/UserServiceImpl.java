package com.myblog.Service;


import com.myblog.Dao.UserDao;
import com.myblog.Dao.UserDaoImpl;
import com.myblog.Pojo.Blog;
import com.myblog.Pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        User u=userDao.checkUserLoginDAO(uname,pwd);
        return u;
    }

    @Override
    public void changeinfo(User user) {
        userDao.changeinfo(user);
    }

    @Override
    public void reguser(User user) {
        userDao.reguser(user);
    }

    @Override
    public void writeblog(Blog blog) {
        userDao.writeblog(blog);
    }

    @Override
    public List<Blog> myblog(int aid) {
        return userDao.myblog(aid);
    }

    @Override
    public void updatablog(String title, String markdown, String essay, int id) {
        userDao.updatablog(title,markdown,essay,id);
    }

    @Override
    public void deleteblog(int id) {
        userDao.deleteblog(id);
    }

    @Override
    public List<Blog> allblog() {
        return userDao.allblog();
    }

    @Override
    public Blog Getblog(int id) {
        return userDao.GetBlog(id);
    }


    @Override
    public int pwd(String newpwd, int id) {
        int i = userDao.pwd(newpwd,id);
        return i;
    }
}
