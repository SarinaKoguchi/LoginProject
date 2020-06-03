package jp.co.aforce.models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.util.DBUtil;

public class UserModel {

	// 全ユーザ情報取得
	public List<UserBean> getAllUsers() {

		ResultSet rs = null;
		List<UserBean> users = new ArrayList<UserBean>();

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT `username`,`gender`,`address` FROM `users` ";
			rs = DBUtil.execute(SQL);

			while (rs.next()) {
				/* データを取得 */
				UserBean userBean = new UserBean();
				userBean.setUsername(rs.getString("username"));
				userBean.setGender(rs.getString("gender"));
				userBean.setAddress(rs.getString("address"));
				users.add(userBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}

		return users;
	}

	// ログインユーザ情報取得
	public List<UserBean> getLoginUser(String username, String password) {
		ResultSet rs = null;
		List<UserBean> loginUser = new ArrayList<UserBean>();

		try {
			// DBに接続するための手続
			DBUtil.makeConnection();
			DBUtil.makeStatement();

			// SQLを実行
			String SQL = "SELECT `username`,`gender`,`address` FROM `users` WHERE `username` = '"+username+"' AND `password` = '"+password+"'";
			rs = DBUtil.execute(SQL);

				/* データを取得 */
				UserBean userBean = new UserBean();
				userBean.setUsername(rs.getString("username"));
				userBean.setGender(rs.getString("gender"));
				userBean.setAddress(rs.getString("address"));
				loginUser.add(userBean);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}

		return loginUser;
	}

}
