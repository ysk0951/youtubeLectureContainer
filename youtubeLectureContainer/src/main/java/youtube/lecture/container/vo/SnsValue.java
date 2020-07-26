package youtube.lecture.container.vo;


import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;



public class SnsValue implements SnsUrls{

	private String service;
	private String clientID;
	private String clientSecret;
	private String rdirectUrl;
	private DefaultApi20 api20Instance;
	public SnsValue(String service, String clientID, String clientSecret, String rdirectUrl) {
		super();
		this.service = service;
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.rdirectUrl = rdirectUrl;
		if(StringUtils) {
			
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
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getRdirectUrl() {
		return rdirectUrl;
	}
	public void setRdirectUrl(String rdirectUrl) {
		this.rdirectUrl = rdirectUrl;
	}
	
}
