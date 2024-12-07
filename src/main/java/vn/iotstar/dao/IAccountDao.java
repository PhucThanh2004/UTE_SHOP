package vn.iotstar.dao;

import vn.iotstar.models.AccountModel;

public interface IAccountDao {
	
	AccountModel findByUserName(String email);
	
	void insert(AccountModel acc);
	
	void updateAvatar(AccountModel acc);
	
	void updateCoverImage(AccountModel acc);
	
	void updateAccount(AccountModel acc);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistPhone(String phone);
}
