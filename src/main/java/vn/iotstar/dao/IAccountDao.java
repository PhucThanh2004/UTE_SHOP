package vn.iotstar.dao;

import vn.iotstar.models.AccountModel;

public interface IAccountDao {
	
	AccountModel findByUserName(String email);
	
	void insert(AccountModel acc);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistPhone(String phone);
}
