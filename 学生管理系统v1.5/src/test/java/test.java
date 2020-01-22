
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.microsoft.dao.IPersonDao;
import org.microsoft.daomain.Person;

import java.io.InputStream;
import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/1/22 16:50
 */
public class test {
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IPersonDao personDao= session.getMapper(IPersonDao.class);
        //5.使用代理对象执行方法
        List<Person> users = personDao.findAll();
        for(Person user : users){
            System.out.println(user);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
