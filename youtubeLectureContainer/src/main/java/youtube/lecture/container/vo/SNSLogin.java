package youtube.lecture.container.vo;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

public class SNSLogin {
	private OAuth20Service oauthService;
	private String profileUrl;
	private SnsValue sns;
	//Api instanceSetting
	//scribe Java 
	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientID())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRdirectUrl())
				.scope("profile")
				.build(sns.getApi20Instance());
		this.sns = sns;
	}
	public String getNaverAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}
	public String getGoogleAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}
	
	public String getUserProfile(String code) throws Exception{
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
		OAuthRequest request = new OAuthRequest(Verb.GET, this.profileUrl);
		oauthService.signRequest(accessToken, request);
		Response response = oauthService.execute(request);
		return response.getBody();
	}
}
