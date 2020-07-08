package youtube.lecture.container.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleOAuth2Template;
import org.springframework.social.oauth1.OAuth1Parameters;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import youtube.lecture.container.vo.AuthInfo;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private AuthInfo authInfo;
	@Autowired
	private GoogleOAuth2Template googleoAuth2Template;
	@Autowired
	private OAuth2Parameters oAuth2Parameters;
	//main
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("Setting... YOUTUBE CONTAINER", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		//googleAPI OAuth2.0 Security
		
		model.addAttribute("serverTime", formattedDate );
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
	
}
