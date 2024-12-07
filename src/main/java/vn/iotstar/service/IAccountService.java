package vn.iotstar.service;

import vn.iotstar.models.AccountModel;

public interface IAccountService {

		AccountModel login(String email, String password);
		AccountModel findByUserName(String email);
		void updateAvatar(AccountModel acc);
		
		void insert(AccountModel acc);
		void updateAccount(AccountModel acc);
		
		void updateCoverImage(AccountModel acc);
		
		boolean checkExistEmail(String email);
		
		boolean checkExistPhone(String phone);
}
