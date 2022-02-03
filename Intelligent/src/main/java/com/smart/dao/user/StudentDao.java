package com.smart.dao.user;

import com.smart.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {

    //根据id查name(测试)
    public String queryStudent(int id){

        String result = "";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select username from student where id = ?";
        //获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            set = ps.executeQuery();    //执行查询
            //可能会查出多个结果，所以用循环遍历（但对于唯一主键来说只有一条记录，student有两个主键，分别为id和account）
            while(set.next()){
                result = set.getString("username");//为什么是只获取第一个，因为我们的sql只查询了一个特定字段，只有一个
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


    //根据username查询字段
    public String queryByName(String username, String attr){

        String result = "";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet set = null;

        String sql = "select " + attr + " from student where username = " + "'" + username + "'";

        //获取连接对象
        try {
            connection = DBHelper.getConn();
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();    //执行查询
            while(set.next()){
                result = set.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
                ps.close();
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }





}
