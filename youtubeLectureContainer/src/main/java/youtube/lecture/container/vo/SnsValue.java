package youtube.lecture.container.vo;

import org.apache.commons.lang3.StringUtils;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.api.DefaultApi20;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;

public class SnsValue implements SnsUrls{

	private String service;
	private String clientID;
	private String clientSecret;
	private String rdirectUrl;
	private DefaultApi20 api20Instance;
	private String profileUrl;
	
	public SnsValue(String service, String clientID, String clientSecret, String rdirectUrl) {
		super();
		this.service = service;
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.rdirectUrl = rdirectUrl;
		if(StringUtils.equalsIgnoreCase(service, "naver")) {
			this.api20Instance = NaverAPI20.getInstance();
			this.profileUrl = "";
		}else if(StringUtils.equalsIgnoreCase(service, "google")) {
			this.api20Instance = GoogleApi20.instance();
			this.profileUrl = GOOGLE_PROFILE_URL;
		}
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public DefaultApi20 getApi20Instance() {
		return api20Instance;
	}
	public void setApi20Instance(DefaultApi20 api20Instance) {
		this.api20Instance = api20Instance;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getRdirectUrl() {
		return rdirectUrl;
	}
	public void setRdirectUrl(String rdirectUrl) {
		this.rdirectUrl = rdirectUrl;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	
}
