package com.wyr.test;

import java.util.List;

import com.wyr.daoimpl.UserDaoImpl;
import com.wyr.pojo.UserEntity;

public class Tset {
	static UserDaoImpl udi=new UserDaoImpl();

public static void main(String[] args) {
		List<UserEntity> list=udi.select(null);
		System.out.println("����װ�ˣ�"+list.size()+"����");
		
		//��ӡ���󼯺�
		for(UserEntity u:list){
			System.out.println(u.getUid()+" "+u.getUname()+" "+u.getUsex());
		}
		//�Բ�������һ�β��ԵĴ��룡
		
	}

}
