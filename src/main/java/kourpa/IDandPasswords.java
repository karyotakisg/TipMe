
package kourpa;
import java.util.HashMap;

public class IDandPasswords {
	
	HashMap<String, String> logininfo = new HashMap<String,String>();
	
	IDandPasswords(){
		logininfo.put("redi", "redi");
	}
	
	protected void setLoginInfo(String username, String password) {
		logininfo.put(username,password);
	}
	protected HashMap getLogininfo(){
		return logininfo;
	}
}
