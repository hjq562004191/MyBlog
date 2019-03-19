package com.myblog.Service;

import com.myblog.Pojo.Blog;
import com.myblog.Pojo.User;

import java.util.List;


public interface UserService {
    User checkUserLoginService(String uname, String pwd);

    int pwd(String newpwd, int id);

    void changeinfo(User user);

    void reguser(User user);


    void writeblog(Blog blog);

    List<Blog> myblog(int aid);

    void updatablog(String title, String markdown, String essay, int id);

    void deleteblog(int id);

    List<Blog> allblog();

    Blog Getblog(int id);
}
