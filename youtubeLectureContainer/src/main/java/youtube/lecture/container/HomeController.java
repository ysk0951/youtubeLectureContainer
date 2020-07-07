package youtube.lecture.container;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//main
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("Setting... YOUTUBE CONTAINER", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		//googleAPI OAuth2.0 Security
		
		
		
//		Token already 
//		String accessToken = "";
//		GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
//		Plus plus = new Plus.builder(new NetHttpTransport(),
//		                             JacksonFactory.getDefaultInstance(),
//		                             credential)
//		    .setApplicationName("Google-PlusSample/1.0")
//		    .build();
		
		
		
		
		
		
		
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
