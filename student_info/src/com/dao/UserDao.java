package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.pojo.User;
public class UserDao extends BaseDao {
	HttpSession session = ServletActionContext.getRequest().getSession();
	public User login(String userId,String password,String type){
		User user = null;
		//封装sql语句
		String sql = "select * from user where userId = ? and password = ? and type = ?";
		//连接到数据库
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			pstmt.setString(3, type);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("user.userName"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
				
				ArrayList<User> list = new ArrayList<User>(); //初始化list
				list.add(user);
				session.setAttribute("list", list);
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
		
		return user;
	}
	
	public boolean register(String userId,String userName,String password,String type){
		boolean flag = false;
		String sql1 = "insert into user(userId,userName,password,type) values(?,?,?,?)";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, password);
			pstmt.setString(4, type);
			int num = pstmt.executeUpdate();
			if(num == 1){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return flag;
	}
	
	public ArrayList<User> list() {
		User user = null;
		ArrayList<User> userList = new ArrayList<User>();
		String sql = "select * from user";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				user = new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
				userList.add(user);
				session.setAttribute("userlist", userList);
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
		
		return userList;
	}
	
	public User queryByUserId(String userId) {
		ResultSet rs = null;
		User user = new User();
		String sql = "select * from user where userId=?";
		conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean update(User user){
		boolean flag = false;
		conn = this.getConn();
		String sql = "update user set userName=?,password=?,type=? where userId=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getType());
			pstmt.setString(4, user.getUserId());
			int num = pstmt.executeUpdate();
			if(num == 1)
				flag = true;
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
