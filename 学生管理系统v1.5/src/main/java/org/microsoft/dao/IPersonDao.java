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
        @Select("select * from stu")
        List<Person> findAll();
}
