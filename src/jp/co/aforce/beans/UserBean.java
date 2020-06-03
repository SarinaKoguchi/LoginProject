package jp.co.aforce.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable {

	private String username;
	private String gender;
	private String address;

	// 引数なしのデフォルト・コンストラクタ
	public UserBean() {
	}

	// セッター
	public void setUsername(String username) {
		this.username = username;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// ゲッター
	public String getUsername() {
		return username;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

}
