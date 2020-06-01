//

package jp.co.aforce.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LoginBean implements Serializable {

	// フィールド
	private String username;
	private String password;
	private String emsg;

	// 引数なしのデフォルト・コンストラクタ
	public LoginBean() {
	}

	// セッター プロパティを変更する
	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// ゲッター プロパティを読み取る
	public String getEmsg() {
		return emsg;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
