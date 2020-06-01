// オリジナル処理で使う

package jp.co.aforce.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable {

	private String data;

	// 引数なしのデフォルト・コンストラクタ
	public UserBean() {
	}

	// セッター
	public void setData(String data) {
		this.data = data;
	}

	// ゲッター
	public String getMsg() {
		return data;
	}




}
