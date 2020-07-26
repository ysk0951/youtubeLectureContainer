package youtube.lecture.container.vo;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverAPI20 extends DefaultApi20 implements SnsUrls {

	private NaverAPI20() {}
	private static NaverAPI20 _instance;
	public static NaverAPI20 getInstance() {
		if(_instance == null) {
			_instance = new NaverAPI20();
		}
		return _instance;
	}
	public static class InstanceHolder{
		
	}
	
	@Override
	public String getAccessTokenEndpoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
