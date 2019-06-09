package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.pojo.Department;
import com.pojo.User;

public class DepartmentDao extends BaseDao{
	HttpSession session = ServletActionContext.getRequest().getSession();
	public Department print(String id,String departmentName){
		Department department = null;
		//封装sql语句
		String sql = "select * from department where id = ? and departmentName = ?";
		//连接到数据库
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, departmentName);
			
			
			ResultSet rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				department = new Department();
				department.setId(rs.getString("id"));
				department.setDepartmentName(rs.getString("department.departmentName"));
				ArrayList<Department> list = new ArrayList<Department>(); //初始化list
				list.add(department);
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
		
		return department;
		
	}
	public boolean add(String id,String departmentName){
		boolean flag = false;
		String sql1 = "insert into department(id,departmentName) values(?,?)";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);
			pstmt.setString(2, departmentName);
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
	
	public ArrayList<Department> list() {
		Department department= null;
		ArrayList<Department> departmentList = new ArrayList<Department>();
		String sql = "select * from department";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				department = new Department();
				department.setId(rs.getString("id"));
				department.setDepartmentName(rs.getString("departmentName"));
				departmentList.add(department);
				session.setAttribute("departmentlist", departmentList);
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
		
		return departmentList;
	}
	
	public Department queryById(String id) {
		ResultSet rs = null;
		Department department = new Department();
		String sql = "select * from department where id=?";
		conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				department.setId(rs.getString("id"));
				department.setDepartmentName(rs.getString("departmentName"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department;
	}
	
	public boolean update(Department department){
		boolean flag = false;
		conn = this.getConn();
		String sql = "update department set departmentName=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department.getDepartmentName());
			pstmt.setString(2, department.getId());
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
	
	
	public boolean delete(String id){
		boolean flag = false;
		conn = this.getConn();
		String sql1 = "delete from department where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);
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
	
	public ArrayList<Department> findClass(String key,String strKey){
		Department department = null;
		ArrayList<Department> departmentList = new ArrayList<Department>();
		String sql = "select * from department";
		if(strKey!=null){

			sql="select * from department where "+key+" like'%"+strKey+"%'";

		}
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				department = new Department();
				department.setId(rs.getString("id"));
				department.setDepartmentName(rs.getString("departmentName"));
				departmentList.add(department);
				session.setAttribute("departmentlist", departmentList);
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
		
		return departmentList;
	}
}
