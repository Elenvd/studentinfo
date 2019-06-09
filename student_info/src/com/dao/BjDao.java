package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.pojo.Bj;


public class BjDao extends BaseDao{
	HttpSession session = ServletActionContext.getRequest().getSession();
	public Bj print(String id,String className){
		Bj bj = null;
		//封装sql语句
		String sql = "select * from bj where id = ? and className = ?";
		//连接到数据库
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, className);
			
			
			ResultSet rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				bj = new Bj();
				bj.setId(rs.getString("id"));
				bj.setClassName(rs.getString("bj.className"));
				ArrayList<Bj> list = new ArrayList<Bj>(); //初始化list
				list.add(bj);
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
		
		return bj;
		
	}
	public boolean add(String id,String className){
		boolean flag = false;
		String sql1 = "insert into bj(id,className) values(?,?)";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);
			pstmt.setString(2, className);
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
	
	public ArrayList<Bj> list() {
		Bj bj= null;
		ArrayList<Bj> bjList = new ArrayList<Bj>();
		String sql = "select * from bj";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				bj = new Bj();
				bj.setId(rs.getString("id"));
				bj.setClassName(rs.getString("className"));
				bjList.add(bj);
				session.setAttribute("bjlist", bjList);
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
		
		return bjList;
	}
	
	public Bj queryById(String id) {
		ResultSet rs = null;
		Bj bj = new Bj();
		String sql = "select * from bj where id=?";
		conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				bj.setId(rs.getString("id"));
				bj.setClassName(rs.getString("className"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bj;
	}
	
	public boolean update(Bj bj){
		boolean flag = false;
		conn = this.getConn();
		String sql = "update bj set className=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bj.getClassName());
			pstmt.setString(2, bj.getId());
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
		String sql1 = "delete from bj where id=?";
		
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
	
	public ArrayList<Bj> findClass(String key,String strKey){
		Bj bj = null;
		ArrayList<Bj> bjList = new ArrayList<Bj>();
		String sql = "select * from bj";
		if(strKey!=null){

			sql="select * from bj where "+key+" like'%"+strKey+"%'";

		}
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				bj = new Bj();
				bj.setId(rs.getString("id"));
				bj.setClassName(rs.getString("className"));
				bjList.add(bj);
				session.setAttribute("bjlist", bjList);
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
		
		return bjList;
	}
}
