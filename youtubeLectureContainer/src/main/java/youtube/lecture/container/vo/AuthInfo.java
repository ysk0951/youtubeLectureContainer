package youtube.lecture.container.vo;

public class AuthInfo {
	private String clientId;
	private String clientPw;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientPw() {
		return clientPw;
	}
	public void setClientPw(String clientPw) {
		this.clientPw = clientPw;
	}
	@Override
	public String toString() {
		return "AuthInfo [clientId=" + clientId + ", clientPw=" + clientPw + "]";
	}
	public AuthInfo(String clientId, String clientPw) {
		this.clientId = clientId;
		this.clientPw = clientPw;
	}
}
