package youtube.lecture.container.vo;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

public class SNSLogin {
	private OAuth20Service oauthService;
	
	public SNSLogin(SnsValue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientID())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRdirectUrl())
				.scope("profile")
				.build(api)
	};
	
	public String getNaverAuthURL() {
		return null;
	}
}
