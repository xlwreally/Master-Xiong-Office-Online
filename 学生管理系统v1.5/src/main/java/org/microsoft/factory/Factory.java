package org.microsoft.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.microsoft.dao.IPersonDao;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/1/29 11:06
 */
public class Factory {
    public static IPersonDao Instant()
    {
        //1.读取配置文件
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        IPersonDao personDao= session.getMapper(IPersonDao.class);
        return personDao;
    }
}
