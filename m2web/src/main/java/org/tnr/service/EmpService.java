package org.tnr.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.mapper.Empmapper;
import org.tnr.model.Emp;



public class EmpService {
	
	
	public List<Emp> getEmpList() {
		String resource = "MyBatis.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sess=sqlSessionFactory.openSession(ExecutorType.REUSE);
		Empmapper emp=sess.getMapper(Empmapper.class);
		try {
			List<Emp> list=emp.findEmplist();
			return list;
		}catch (Exception e){
			sess.rollback();
			throw e;
		}finally {
			sess.close();
		}



		
	}

}
