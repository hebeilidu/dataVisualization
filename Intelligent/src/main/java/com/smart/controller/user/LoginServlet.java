package com.smart.controller.user;

import com.smart.dao.user.StudentDao;
import com.smart.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 这个是设置编码格式，上同
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // String rdo = request.getParameter("rdo");
        String rdo = "student";

        password = MD5Util.encode(password); // 加密

        // 根据选中的角色不同进行不同的查询
        if ("student".equals(rdo)) {
            StudentDao studentDao = new StudentDao();
            // 获取数据库数据
            String stu_id = studentDao.queryByName(username, "id");  //根据username查询id
            String stu_pw = studentDao.queryByName(username, "password");  //根据username查询password
            // 可能发生的情况：1.此账号不存在2.查出的密码与账号不匹配,那么方法返回的String都是空的
            if (!"".equals(stu_pw) || stu_pw != null) {
                // 从数据库中获取到密码
                if (password.equals(stu_pw)) {
                    // 密码明文校验成功
                    request.setAttribute("loginInfo", "登陆成功!欢迎您！");
                    request.getSession().setAttribute("id", stu_id);
                    request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("rdo", rdo);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    // 密码明文文校验失败
                    request.setAttribute("loginInfo", "你输入的账号或密码不正确，请核对！");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                // 从数据库中未获取到密码
                request.setAttribute("loginInfo", "你输入的账号或密码不正确，请核对！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

}
