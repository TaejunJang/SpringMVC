package com.company.persistencce;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class PointDAOImpl implements PointDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.company.mapper.PointMapper";
	
	@Override
	public void updatePoint(String uid, int point) throws Exception {
		// TODO Auto-generated method stub
		Map<String , Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", uid);
		paramMap.put("point", point);
		session.update(namespace+".updatePoint", paramMap);
		
	}
	
}
