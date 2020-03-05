package com.xlw.oa.dao.safty;

import com.xlw.oa.model.TModule;
import com.xlw.oa.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/5 20:09
 */
@Repository
public interface ModuleDao {
    @Select("select * from t_module m left join t_um u on m.m_id=u.m_id  where u.u_id=#{name} or m.m_pid is null order by m.m_id")
    public List<TModule> findAllList(String name);

    @Select("select u_id from t_user")
    public List<User> findAlluser();
}
