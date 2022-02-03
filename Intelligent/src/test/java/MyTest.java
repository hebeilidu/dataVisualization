
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.smart.dao.major.MajorDao;
import com.smart.dao.user.StudentDao;
import com.smart.pojo.Major_situation;
import com.smart.pojo.Teaching_situation;
import org.junit.Test;

public class MyTest {
    private static Connection dbConn = null;

    public static void main(String[] args) {
        String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=smart";

        try {
            //1.加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("加载驱动成功！");
            //2.连接
            dbConn = DriverManager.getConnection(dbURL, "sa", "123456");
            System.out.println("连接数据库成功！");
            String sql="select * from student";
            PreparedStatement statement=null;
            statement = dbConn.prepareStatement(sql);
            ResultSet res = null;
            res = statement.executeQuery();
            while(res.next()){
                String title=res.getString("name");
                System.out.println("结果：" + title);
            }
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败！");
        }

    }

    @Test
    public void testConn(){

        String uri= "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=smart";
        Connection con=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    //加载驱动
            con = DriverManager.getConnection(uri, "sa", "123456");    //获取数据库连接对象
            System.out.println("连接数据库成功！！！");
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    // 查询学生
    @Test
    public void testQueryStudent(){

        StudentDao studentDao = new StudentDao();
        String res = studentDao.queryStudent(1);
        System.out.println(res);

    }

    // 查询登录
    @Test
    public void testQueryLogin(){

        StudentDao studentDao = new StudentDao();
        String res = studentDao.queryByName("原柯","password");
        System.out.println(res);

    }

    // 查询专业名
    @Test
    public void testQueryMajorSitu(){

        MajorDao majorDao = new MajorDao();
        ArrayList<Major_situation> res = majorDao.queryMajorSitu();

        for (Major_situation re : res) {
            System.out.println(re.getMajor_name());
        }
    }

    // 查询学生与本学院授课教师之比
    @Test
    public void testQueryRate(){
        MajorDao majorDao = new MajorDao();
        Float res = majorDao.queryRate("信息安全");

        System.out.println(res);
    }

    // 查询教学情况
    @Test
    public void testTesSitu(){
        MajorDao majorDao = new MajorDao();
        ArrayList<Teaching_situation> res = majorDao.queryTeaSitu();

        System.out.println(res.toString());
    }

}
