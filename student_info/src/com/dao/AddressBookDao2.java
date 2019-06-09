package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.pojo.AddressBook2;

public class AddressBookDao2 extends BaseDao{
	HttpSession session = ServletActionContext.getRequest().getSession();
	public ArrayList<AddressBook2> list() {
		AddressBook2 addressBook2= null;
		ArrayList<AddressBook2> addressBook2List = new ArrayList<AddressBook2>();
		String sql = "SELECT * FROM test.`addressbook2`;";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				addressBook2 = new AddressBook2();
				addressBook2.setUserId(rs.getString("userId"));
				addressBook2.setTeacherName(rs.getString("teacherName"));
				addressBook2.setPhoneNum(rs.getString("phoneNum"));
				addressBook2List.add(addressBook2);
				session.setAttribute("addressBook2list", addressBook2List);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			this.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		
		return addressBook2List;
		
	}
	
}
