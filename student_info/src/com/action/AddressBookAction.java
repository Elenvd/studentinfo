package com.action;

import java.util.ArrayList;

import com.dao.AddressBookDao;
import com.dao.DepartmentDao;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.AddressBook;

public class AddressBookAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private AddressBook addressBook;
	private ArrayList<AddressBook> addressBookList;
	private String userid;
	private String key;
	private String strKey;
	public String list() {
		AddressBookDao addressBookDao = new AddressBookDao();
		addressBookList = addressBookDao.list();
		addressBook = addressBookList.get(0);
		if (addressBookList != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
