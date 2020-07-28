package youtube.lecture.container.vo;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

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
	private User parseJson(String body) throws Exception {
		System.out.println("============================\n" + body + "\n==================");
		User user = new User();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(body);
			if (this.sns.isNaver()) {
			String id = rootNode.get("id").asText();
			
			if (sns.isGoogle())
				user.setGoogleid(id);
				user.setNickname(rootNode.get("displayName").asText());
				JsonNode nameNode = rootNode.path("name");
				String uname = nameNode.get("familyName").asText() + nameNode.get("givenName").asText();
				user.setUname(uname);
			Iterator<JsonNode> iterEmails = rootNode.path("emails").elements();
			while(iterEmails.hasNext()) {
				JsonNode emailNode = iterEmails.next();
				String type = emailNode.get("type").asText();
				if (StringUtils.equals(type, "account")) {
					user.setEmail(emailNode.get("value").asText());
					break;
				}
			}
		} else if (this.sns.isNaver()) {
			JsonNode resNode = rootNode.get("response");
			user.setNaverid(resNode.get("id").asText());
			user.setNickname(resNode.get("nickname").asText());
			user.setEmail(resNode.get("email").asText());
		}
		return user;
	}
}
