package com.action;

import java.util.ArrayList;

import com.dao.AddressBookDao2;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.AddressBook2;

public class AddressBook2Action extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private AddressBook2 addressBook2;
	private ArrayList<AddressBook2> addressBook2List;
	private String userId;
	public String list() {
		AddressBookDao2 addressBook2Dao = new AddressBookDao2();
		addressBook2List = addressBook2Dao.list();
		addressBook2 = addressBook2List.get(0);
		if (addressBook2List != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
