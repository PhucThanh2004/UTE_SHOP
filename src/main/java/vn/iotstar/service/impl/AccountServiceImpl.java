package vn.iotstar.service.impl;

import vn.iotstar.dao.IAccountDao;
import vn.iotstar.dao.impl.AccountDaoImpl;
import vn.iotstar.models.AccountModel;

public class AccountServiceImpl implements vn.iotstar.service.IAccountService {
	IAccountDao accDao = new AccountDaoImpl();

	@Override
	public AccountModel login(String email, String password) {
		AccountModel user = this.findByUserName(email);
		if(user !=null && password.equals(user.getPassword()))
		{
			return user;
		}
		return null;
	}

	@Override
	public AccountModel findByUserName(String username) {
		return accDao.findByUserName(username);
	}

	@Override
	public void insert(AccountModel acc) {
		accDao.insert(acc);
		
	}

	@Override
	public boolean checkExistEmail(String email) {
		return accDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return accDao.checkExistPhone(phone);
	}

	@Override
	public void updateAvatar(AccountModel acc) {
		accDao.updateAvatar(acc);
		
	}

	@Override
	public void updateAccount(AccountModel acc) {
		accDao.updateAccount(acc);
	}

	@Override
	public void updateCoverImage(AccountModel acc) {
		accDao.updateCoverImage(acc);
		
	}

}
