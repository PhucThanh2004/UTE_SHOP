package vn.iotstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iotstar.configs.DBConnectSQL;
import vn.iotstar.dao.IAccountDao;
import vn.iotstar.models.AccountModel;

public class AccountDaoImpl extends DBConnectSQL implements IAccountDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public AccountModel findByUserName(String email) {
		String sql = "SELECT * from accounts where email = ?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();

			while (rs.next()) {
				AccountModel user = new AccountModel();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setSeller(rs.getBoolean("is_seller"));
				user.setPhone(rs.getString("phone"));
				user.setAvatar(rs.getString("avatar"));
				user.setCover_image(rs.getString("cover_image"));

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void insert(AccountModel acc) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args)
	{
		AccountDaoImpl userDao = new AccountDaoImpl();
		//List<UserModel> list = userDao.findAll();
		
		//for(UserModel user : list)
		//{
			//System.out.println(user);
		//}
		
		System.out.print(userDao.findByUserName("huyen123"));
		userDao.updateAvatar(new AccountModel("thanh@gmail.com", "abc"));
		//userDao.updateAccount(new AccountModel("phucThanh", "0394601129", "thanh@gmail.com"));
		
	}

	@Override
	public void updateAvatar(AccountModel acc) {
		 String sql = "UPDATE accounts SET avatar=? WHERE email=?";

		    try {
		        conn = super.getConnection();
		        ps = conn.prepareStatement(sql);

		        ps.setString(1, acc.getAvatar());
		        ps.setString(2, acc.getEmail());

		        ps.executeUpdate();

		        conn.close();
		        ps.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		
	}

	public void updateAccount(AccountModel acc) {
	    String sql = "UPDATE accounts SET name=?, phone=? WHERE email=?";

	    try {
	        conn = super.getConnection();
	        ps = conn.prepareStatement(sql);

	        ps.setString(1, acc.getName());
	        ps.setString(2, acc.getPhone());
	        ps.setString(3, acc.getEmail());

	        ps.executeUpdate();

	        conn.close();
	        ps.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void updateCoverImage(AccountModel acc) {
		String sql = "UPDATE accounts SET cover_image=? WHERE email=?";

	    try {
	        conn = super.getConnection();
	        ps = conn.prepareStatement(sql);

	        ps.setString(1, acc.getCover_image());
	        ps.setString(2, acc.getEmail());

	        ps.executeUpdate();

	        conn.close();
	        ps.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
