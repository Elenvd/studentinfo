package com.action;

import java.util.ArrayList;

import com.dao.BjDao;
import com.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Bj;

public class BjListAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Bj bj;
	private ArrayList<Bj> bjList;
	private String id;
	private String key;
	private String strKey;

	

	public String list() {
		BjDao bjDao = new BjDao();
		bjList = bjDao.list();
		bj = bjList.get(0);
		if(bjList != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}
	 
	public String update() {
		BjDao bjDao = new BjDao();
		boolean flag = bjDao.update(bj);
		if (flag) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String add() {
		BjDao bjDao = new BjDao();
		boolean flag = bjDao.add(bj.getId(), bj.getClassName());
		if(flag) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public String current() {
		BjDao bjDao = new BjDao();
		bj = bjDao.queryById(id);
		if (bj != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String delete() {
		BjDao bjDao = new BjDao();
		boolean flag = bjDao.delete(id);
		if (flag) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String findClass() {
		BjDao bjDao = new BjDao();
		bjList = bjDao.findClass(bj.getKey(), bj.getStrKey());
		bj = bjList.get(0);
		if (bjList != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public Bj getBj() {
		return bj;
	}

	public void setBj(Bj bj) {
		this.bj = bj;
	}

	public ArrayList<Bj> getBjList() {
		return bjList;
	}

	public void setBjList(ArrayList<Bj> bjList) {
		this.bjList = bjList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getStrKey() {
		return strKey;
	}

	public void setStrKey(String strKey) {
		this.strKey = strKey;
	}
	
	
	
	
}
