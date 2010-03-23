package defensio;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.defensio.exceptions.DefensioException;

import defensio.dao.DefensioWrapper;
import defensio.model.data.AuditCommentResponse;
import defensio.requests.AuditCommentRequest;

public class Main {

	private static final String API_KEY = "BC81EC7FD73D8026B47CCE65B23D5471";
	private static final String SITE_URL = "http://mysite.com";
	private static DefensioWrapper _wrapper = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		_wrapper = new DefensioWrapper();
	
		AuditCommentRequest request = new AuditCommentRequest();
		request.setApiKey(API_KEY);
		request.setClient("MyPluginName | 1.0 | Joe Author | joe@author-domain.com");
		request.setContent("check this comment");
		request.setPlatform("wordpress");
		// FIXME: test shouldn't be used un production
		request.setType("test");
		
		/*
		request.setAsync(false);
		request.setAsyncCallback("http://mysite.com/receiveAnswer"); // Unused, async in false
		request.setAuthorEmail("author@example.com");
		request.setAuthorIp("0.0.0.0");
		request.setAuthorLoggedIn(false);
		request.setAuthorName("simon cobo");
		// request.setAuthorOpenId(authorOpenId);
		request.setAuthorTrusted(false);
		request.setAuthorUrl("http://simoncobo.com");
		request.setDocumentPermalink("http://mysite/article#comment-51");
		request.setParentDocumentDate("2010-03-10");
		request.setParentDocumentPermalink("http://mysite/article");*/
		
		try {
			AuditCommentResponse response = _wrapper.auditComment(request);
		} catch (DefensioException e) {
			e.printStackTrace();
		}
	}

}
