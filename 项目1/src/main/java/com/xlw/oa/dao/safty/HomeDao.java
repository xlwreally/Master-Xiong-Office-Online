package com.xlw.oa.dao.safty;


import com.xlw.oa.model.TModule;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 熊立伟
 * @version 1.0
 * @date 2020/3/3 22:33
 */
@Repository
public interface HomeDao {
    @Select("select * from t_module m left join t_um u on m.m_id=u.m_id  where u.u_id=#{name} or m.m_pid is null order by m.m_id")
    public List<TModule> findMenuList(String name);
}
