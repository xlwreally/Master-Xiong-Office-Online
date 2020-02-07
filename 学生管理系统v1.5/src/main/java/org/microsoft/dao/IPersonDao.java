package org.microsoft.dao;

import org.apache.ibatis.annotations.Select;
import org.microsoft.daomain.Person;

import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/1/22 16:45
 */
public interface IPersonDao {
        /**
         * 查找所有用户
         * @return
         */
        @Select("select * from stu ")
        List<Person> findAll();
       Boolean add(Person a) ;
       Boolean remove(Person a);
       Boolean change(Person a);
        List<Person> getOne(String s);

}
