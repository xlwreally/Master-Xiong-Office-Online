package org.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.tnr.model.Emp;

import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/1/15 19:19
 */
public interface Empmapper {
    @Select("select * from emp")
    public List<Emp> findEmplist();
}
