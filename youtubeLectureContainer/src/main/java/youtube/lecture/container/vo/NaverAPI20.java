package youtube.lecture.container.vo;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class NaverAPI20 extends DefaultApi20 implements SnsUrls {

	private NaverAPI20() {}
	public static NaverAPI20 getInstance() {
		return InstanceHolder.INSTANCE;
	}
	public static class InstanceHolder{
		private static final NaverAPI20 INSTANCE = new NaverAPI20();
	}
	
	@Override
	public String getAccessTokenEndpoint() {
		return null;
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		return null;
	}

}
