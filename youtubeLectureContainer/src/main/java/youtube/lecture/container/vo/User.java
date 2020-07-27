package youtube.lecture.container.vo;

import java.util.Date;

public class User {
	private String uid;
	private String upw;
	private String uname;
	private Integer upoint;
	
	private String email;
	private String googleid;
	private String naverid;
	private String nickname;
	
	private String loginip;
	private Date lastlogin;
	
	public static void main(String[] args) {
		User user1 = new User();
		user1.setUid("1111111");
		user1.setUname("adsfasfsaf1212121");
		
		User user2 = new User();
		user2.setUid("1111111");
		user2.setUname("adsfasfsaf");
		System.out.println(user1.equals(user2));
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getUpoint() {
		return upoint;
	}
	public void setUpoint(Integer upoint) {
		this.upoint = upoint;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGoogleid() {
		return googleid;
	}
	public void setGoogleid(String googleid) {
		this.googleid = googleid;
	}
	public String getNaverid() {
		return naverid;
	}
	public void setNaverid(String naverid) {
		this.naverid = naverid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public Date getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", upoint=" + upoint + ", email=" + email
				+ ", googleid=" + googleid + ", naverid=" + naverid + ", nickname=" + nickname + ", loginip=" + loginip
				+ ", lastlogin=" + lastlogin + "]";
	}
	public User(String uid, String upw, String uname, Integer upoint, String email, String googleid, String naverid,
			String nickname, String loginip, Date lastlogin) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.upoint = upoint;
		this.email = email;
		this.googleid = googleid;
		this.naverid = naverid;
		this.nickname = nickname;
		this.loginip = loginip;
		this.lastlogin = lastlogin;
	}
	public User() {
	}
}
