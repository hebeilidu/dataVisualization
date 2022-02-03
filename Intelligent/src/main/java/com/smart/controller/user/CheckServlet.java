package com.smart.controller.user;

import com.smart.dao.user.StudentDao;
import com.smart.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 这个是设置编码格式，上同
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 获取数据
        // 获取用户填写验证码
        String verifycode = request.getParameter("verifycode");
        //4.校验验证码是否正确
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");

        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性，获取之后立即移除


        PrintWriter out = response.getWriter();
        try {
            if (!checkcode_server.equalsIgnoreCase(verifycode)) {
                // 验证码不正确
                out.write("false");
            } else {
                out.write("true");
            }
        } finally {
            out.flush();
            out.close();

        }

    }

}
