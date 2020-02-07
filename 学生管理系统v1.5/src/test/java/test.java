
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.microsoft.dao.IPersonDao;
import org.microsoft.daomain.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.microsoft.tool.function.isInteger;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/1/22 16:50
 */
public class test {

   public static void main(String[] args) {

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
        
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("======用户管理系统=======");
            System.out.println("     1、增加用户");
            System.out.println("     2、修改用户");
            System.out.println("     3、删除用户");
            System.out.println("     4、用户列表");
            System.out.println("     5、查找用户");
            System.out.println("     0、退出系统");
            System.out.println("=======================");
            System.out.println("请输入操作数：");
            int num = scan.nextInt();
            switch (num) {
                case 1:
                    Date date=new Date();

                    Person s = new Person();
                    System.out.println("姓名：");
                    s.setS_name(scan.next());
                    System.out.println("班级：");
                    s.setS_ClassName(scan.next());
                    System.out.println("请输入出生年月日，空格隔开");
                    s.setS_Birthday(scan.nextInt()+"-"+scan.nextInt()+"-"+scan.nextInt());
                    s.setS_RegistTime(date);
                    if (personDao.add(s)) {

                        System.out.println("增加成功！");
                        session.commit();
                    } else {
                        System.out.println("增加失败！");
                    }

                    break;
                case 2:
                    Person a = new Person();
                    System.out.println("学号：");
                    scan.nextLine();
                    while (true)
                    {
                        String ID=scan.nextLine();
                        if(isInteger(ID))
                        {
                            a.setS_ID(ID);
                            break;
                        }
                        System.out.println("错误，学号必须为数字，请重新输入");
                    }
                    System.out.println("姓名：");
                    a.setS_name(scan.nextLine());
                    System.out.println("班级：");
                    a.setS_ClassName(scan.nextLine());

                    if (personDao.change(a)) {

                        System.out.println("修改成功！");
                        session.commit();
                    } else {
                        System.out.println("修改失败！");
                    }
                    break;
                case 3:
                    Person c = new Person();
                    System.out.println("学号：");
                    scan.nextLine();
                    while (true)
                    {
                        String ID=scan.nextLine();
                        if(isInteger(ID))
                        {
                            c.setS_ID(ID);
                            break;
                        }
                        System.out.println("错误，学号必须为数字，请重新输入");
                    }
                    if(personDao.remove(c)) {
                        System.out.println("删除成功");
                        session.commit();
                    }
                    else System.out.println("删除失败");

                    break;
                case 4:
                    for (Person p: personDao.findAll()) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    scan.nextLine();
                    System.out.println("请输入班级");
                    for (Person p: personDao.getOne(scan.nextLine())){
                        System.out.println(p);
                    }
                    break;
                case 0:
                    session.commit();
                    session.close();
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;

                default:
                    System.out.println("输入有误，请重新输入！");
            }

        }
    }
}
