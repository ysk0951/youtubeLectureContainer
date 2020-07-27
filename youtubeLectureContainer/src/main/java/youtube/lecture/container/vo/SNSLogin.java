package youtube.lecture.container.vo;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

public class SNSLogin {
	private OAuth20Service oauthService;

	//Api instanceSetting
	//scribe Java
	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientID())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRdirectUrl())
				.scope("profile")
				.build(sns.getApi20Instance());
	};
	public String getNaverAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}
	public String getGoogleAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}
}
