package youtube.lecture.container.vo;

import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	public User getUserProfile(String code) throws Exception{
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
		OAuthRequest request = new OAuthRequest(Verb.GET, this.profileUrl);
		oauthService.signRequest(accessToken, request);
		Response response = oauthService.execute(request);
		return parseJson(response.getBody());
	}
	private User parseJson(String body) throws JsonProcessingException, IOException {
		User user = new User();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(body);
		String id = rootNode.get("id").asText();
		String displayNode = rootNode.get("displayName").asText();
		JsonNode nameNode = rootNode.path("name");
		String realName = nameNode.get("familyName").asText()+nameNode.get("givenName").asText();
		//Iterator
		Iterator<JsonNode> iterEmails = rootNode.path("emails").elements();
		
		while(iterEmails.hasNext()) {
			JsonNode emailNode = iterEmails.next();
			String email = emailNode.get("value").asText();
			user.getEmail();
		}
		
		return user;
	}
}
