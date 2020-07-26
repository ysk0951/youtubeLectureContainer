package youtube.lecture.container.vo;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;


public class SnsValue implements SnsUrls{

	private String service;
	private String clientID;
	private String clientSecret;
	private String rdirectUrl;
	public SnsValue(String service, String clientID, String clientSecret, String rdirectUrl) {
		super();
		this.service = service;
		this.clientID = clientID;
		this.clientSecret = clientSecret;
		this.rdirectUrl = rdirectUrl;
	}
}
