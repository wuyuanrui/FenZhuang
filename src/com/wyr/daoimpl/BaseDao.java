package com.wyr.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.catalina.User;

import com.wyr.utils.JDBC;

public  class BaseDao {
	private Connection conn=null;
	private PreparedStatement pre=null;
	private ResultSet res=null;
	private JDBC jdbc=null;
	public   int num=1000;
	public BaseDao(){
		jdbc=new JDBC();
	}
	
	//��ɾ�Ĳ�
	//���ᴫ��sql�Ͳ���
	public int update(String sql,Map<Integer,Object> map){
		int i=0;
		try {
			conn=jdbc.getConnection();
			pre=conn.prepareStatement(sql);
			/*//��ȡ������
			 Set s=map.keySet();
			 //���ص�����
			Iterator c=s.iterator();
			while(c.hasNext()){
				//ͨ������ȡֵ����
				pre.setObject(1, map.get(c.next()));
				pre.setObject(2, map.get(c.next()));
			}*/
			for(Integer index:map.keySet()){
				//keySet��ȡ��ֵ��
				//��ͨ����ֵ��ȡ��ʵֵ
				pre.setObject(index, map.get(index));		
			}
			i=pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbc.close(pre, res, conn);
		}
		return i;
	}
	
	
	//��ѯ������
	public List selectActive(String sql,Map<Integer,Object> map){
		List list=new ArrayList();
		
		try {
			conn=jdbc.getConnection();
			pre=conn.prepareStatement(sql);
			//����������ȡֵ
			for(Integer i:map.keySet()){
				pre.setObject(i, map.get(i));
			}
			res=pre.executeQuery();
			
			
			
			//������
			int  col=res.getMetaData().getColumnCount();
			//��ȡ
			while(res.next()){
				//��װÿһ������
				List obj=new ArrayList();
				//�����������������ÿһ������
				for(int i=1;i<=col;i++){
					//ÿһ����ӵ�����
					obj.add(res.getObject(i));
				}
				//��ÿһ������ļ��ϣ����������ֶε���Ϣ������װ�����ϣ�һ�������󼯺ϣ�
				list.add(obj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbc.close(pre, res, conn);
		}
		
		
		return list;
	}
	
	
	
	
	
}
