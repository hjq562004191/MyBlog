package com.myblog.Dao;

import com.myblog.Pojo.Blog;
import com.myblog.Pojo.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void writeblog(Blog blog) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");
            String sql = "insert into user_blog (aid,title,date,markdown,essay,author) values (?,?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blog.getAid());
            ps.setString(2,blog.getTitle());
            ps.setString(3,blog.getDate());
            ps.setString(4,blog.getMarkdown());
            ps.setString(5,blog.getEssay());
            ps.setString(6,blog.getAuthor());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Blog> myblog(int aid) {
        List<Blog> list = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Blog blog = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");

            String sql = "select * from user_blog where aid=?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,aid);

            rs = ps.executeQuery();
            list = new ArrayList<Blog>();

            while (rs.next()){
                blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setAid(rs.getInt("aid"));
                blog.setEssay(rs.getString("essay"));
                blog.setMarkdown(rs.getString("markdown"));
                blog.setTitle(rs.getString("title"));
                blog.setDate(rs.getString("date"));
                blog.setAuthor(rs.getString("author"));
                blog.setView(rs.getInt("view"));
                list.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public void updatablog(String title, String markdown, String essay, int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");
            String sql = "update user_blog set title=?,markdown=?,essay=? where id=?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(4,id);
            ps.setString(1,title);
            ps.setString(2,markdown);
            ps.setString(3,essay);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteblog(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");
            String sql = "delete from user_blog where id=?;";
            ps = conn.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Blog> allblog() {
        List<Blog> list = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Blog blog = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");

            String sql = "select * from user_blog;";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            list = new ArrayList<Blog>();

            while (rs.next()){
                blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setAid(rs.getInt("aid"));
                blog.setEssay(rs.getString("essay"));
                blog.setTitle(rs.getString("title"));
                blog.setMarkdown(rs.getString("markdown"));
                blog.setDate(rs.getString("date"));
                blog.setAuthor(rs.getString("author"));
                blog.setView(rs.getInt("view"));
                list.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public Blog GetBlog(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Blog blog = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");

            String sql = "select * from user_blog where id=?;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            int views = 0;
            while (rs.next()) {
                views = rs.getInt("view");
                blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setAid(rs.getInt("aid"));
                blog.setEssay(rs.getString("essay"));
                blog.setTitle(rs.getString("title"));
                blog.setMarkdown(rs.getString("markdown"));
                blog.setDate(rs.getString("date"));
                blog.setAuthor(rs.getString("author"));
                blog.setView(rs.getInt("view"));
            }
            views++;
            String sql2 = "update user_blog set view=? where id=?";
            ps = conn.prepareStatement(sql2);
            ps.setInt(1,views);
            ps.setInt(2,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return blog;
    }

    @Override
    public void changeinfo(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");
            String sql = "update user_login set uname=?,sex=?,birthday=?,personal=? where id=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getSex());
            ps.setString(3,user.getBirthday());
            ps.setString(4,user.getPersonal());
            ps.setInt(5,user.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void reguser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");
            String sql = "insert into user_login (uname,pwd,sex,birthday,personal) values (?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPwd());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getBirthday());
            ps.setString(5,user.getPersonal());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    @Override
    public User checkUserLoginDAO(String uname, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");

            String sql = "select * from user_login where uname=? and pwd=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,pwd);

            rs = ps.executeQuery();

            while (rs.next()){
                u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));
                u.setBirthday(rs.getString("birthday"));
                u.setPersonal(rs.getString("personal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return u;
    }

    @Override
    public int pwd(String newpwd, int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8&allowPublicKeyRetrieval=true","root","qqq1234");

            String sql = "update user_login set pwd=? where id=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1,newpwd);
            ps.setInt(2,id);

            i = ps.executeUpdate();

        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return i;
    }
}
