package jp.co.aforce.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.beans.UserBean;
import jp.co.aforce.models.LoginModel;
import jp.co.aforce.models.UserModel;

// 親クラスに HttpServlet を指定する
@SuppressWarnings("serial") // これがないと waring がでる
public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// GETリクエストはあり得ないので、無条件でログイン画面に飛ばす
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
		rDispatcher.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 文字のエンコードを UTF-8 とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

		// ユーザによって入力された情報を取り出す リクエストパラメータの取得
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 取り出した情報を loginBean に格納する
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		// モデルをインスタンス化する
		LoginModel loginModel = new LoginModel();
		String forward_jsp = "/views/login.jsp";

		// 入力された情報がDBに存在するか調べる
		if (loginModel.loginCheck(username, password)) {

			// TODO ここはオリジナル処理を考える ↓↓
			// 例）ログインしたユーザの情報を表示する
			UserModel userModel = new UserModel();

			// DB上にある全てのユーザ情報を取得
			List<UserBean> users = userModel.getAllUsers();

			// ログインユーザ情報を取得
			UserBean loginUser = userModel.getLoginUser(username, password);

			// リクエストオブジェクトに設定
			request.setAttribute("users", users);
			request.setAttribute("loginUser", loginUser);

			// ログインに成功した先の JSP を指定
			forward_jsp = "/views/success.jsp";

			// ログインが失敗したときの処理
		} else {
			// エラーメッセージを設定
			loginBean.setEmsg("ユーザ名またはパスワードが違います");
			request.setAttribute("loginBean", loginBean); // リクエストスコープにインスタンスを保存
		}
		// forwaed_jsp に設定されているJSPへディスパッチ
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forward_jsp);
		rDispatcher.forward(request, response);
	}

}