package vn.iotstar.service;

import vn.iotstar.models.AccountModel;

public interface IAccountService {

		AccountModel login(String email, String password);
		AccountModel findByUserName(String email);
		
		void insert(AccountModel acc);
		
		boolean checkExistEmail(String email);
		
		boolean checkExistPhone(String phone);
}
