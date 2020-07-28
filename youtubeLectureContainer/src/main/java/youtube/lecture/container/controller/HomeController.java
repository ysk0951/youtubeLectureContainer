package youtube.lecture.container.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import youtube.lecture.container.vo.SNSLogin;
import youtube.lecture.container.vo.SnsValue;
import youtube.lecture.container.vo.User;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private SnsValue naverSns;
	@Inject
	private SnsValue googleSns;
	@Inject
	private GoogleConnectionFactory googleConnectionFactory;
	@Inject
	private OAuth2Parameters googleOauth2parameters;
	
	//main
	@RequestMapping(value = "/", method = {RequestMethod.GET , RequestMethod.POST})
	public String join(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("Setting... YOUTUBE CONTAINER", locale);
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOauth2parameters);
		model.addAttribute("google_url", url);
		return "main";
	}
	
	//error 404 page
	@RequestMapping(value = "/error404", method = RequestMethod.GET)
	public String error(HttpServletResponse response,Model model) {
		response.setStatus(HttpServletResponse.SC_OK);
		logger.warn("404 Error");
		model.addAttribute("content", "1");
		return "error";
	} 
	
	//senior coding 1 : 07 : 04
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) throws Exception{
		logger.info("login GET ... ");
		//naver
		SNSLogin naverLogin = new SNSLogin(naverSns);
		model.addAttribute("naver_url", naverLogin.getNaverAuthURL());
		//google-scribeJava
		//SNSLogin googleLogin = new SNSLogin(googleSns);
		//model.addAttribute("google_url", googleLogin.getGoogleAuthURL());
		//goole 다른방식
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOauth2parameters);
		model.addAttribute("google_url", url);
		return "main";
	} 
	
	@RequestMapping(value = "/auth/google/callback",
			method = {RequestMethod.GET ,RequestMethod.POST})
	public String snsLoginCallback(Model model,@RequestParam String code) throws Exception{
		
		System.out.println("OAUTH2 CODE : "+code);
		//1. code를 이용해서 access_token 받기
		// 2. access_token을 이용해서 사용자 profile 정보 가져오기
		SNSLogin snsLogin = new SNSLogin(googleSns);
		User snsUser = snsLogin.getUserProfile(code); // 1,2번 동시
		//3. DB Check
		//User user = service.getBySns(snsUser);
		
		System.out.println("Profile>>" + snsUser);
		model.addAttribute("result", snsUser.getUname() + "님 반갑습니다.");
		
		//4. 강제 로그인
		return "loginResult";
	}
}
