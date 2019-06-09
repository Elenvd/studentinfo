package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.pojo.AddressBook;


public class AddressBookDao extends BaseDao{
	HttpSession session = ServletActionContext.getRequest().getSession();
	public ArrayList<AddressBook> list() {
		AddressBook addressBook= null;
		ArrayList<AddressBook> addressBookList = new ArrayList<AddressBook>();
		String sql = "SELECT * FROM test.`addressBook1`;";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				addressBook = new AddressBook();
				addressBook.setUserid(rs.getString("userid"));
				addressBook.setStudentName(rs.getString("studentName"));
				addressBook.setMajor(rs.getString("major"));
				addressBook.setCs(rs.getString("cs"));
				addressBook.setDepartmentName(rs.getString("departmentName"));
				addressBook.setPhoneNum(rs.getString("phoneNum"));
				addressBookList.add(addressBook);
				session.setAttribute("addressBooklist", addressBookList);
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
		
		return addressBookList;
		
	}
	
}
