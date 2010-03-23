package defensio.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.defensio.exceptions.AccesDeniedException;
import com.defensio.exceptions.DefensioException;

import defensio.model.data.AuditCommentResponse;
import defensio.model.data.DefensioResponse;
import defensio.requests.AuditCommentRequest;

/**
 * Wraps the available procedures of the Defensio API.
 * @author Remy Giard
 */
public class DefensioWrapper {
	
	public DefensioWrapper() {
	}
	
	/**
	 * Sends the post request to the API server and returns
	 * the response in string. 
	 * @param post
	 * @return
	 * @throws DefensioException
	 */
	private String sendRequest(PostMethod post) throws DefensioException {
		
		try {
			// send the post request and get response
			HttpClient client = new HttpClient();
			int statusCode = client.executeMethod(post);
			switch (statusCode) {
				case -1:
					throw new DefensioException("No response returned.");
					
				case 401:
					throw new AccesDeniedException();
					
				case 200:
					String contents = post.getResponseBodyAsString();
					post.releaseConnection();
				    return contents;
				    
				default :
					throw new DefensioException("Invalid response : " + statusCode);
			}
			
		} catch (DefensioException e) {
			throw e;
			
		} catch (HttpException e) {
			throw new DefensioException(e);
			
		} catch (IOException e) {
			throw new DefensioException(e);
		}
	}
	
	/**
	 * Returned the parameters contained in the response as a HashMap
	 * where the key is the parameter name and the value is the 
	 * parameter value.
	 * @param response
	 * @return
	 * @throws DefensioException
	 */
	private HashMap parseResponse(String response) throws DefensioException {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			ByteArrayInputStream in = new ByteArrayInputStream(response.getBytes());
			Document doc = builder.parse(in);
			
			// find the "defensio-result" node
			Node result = doc.getChildNodes().item(0);
			if (!"defensio-result".equals(result.getNodeName())) {
				throw new DefensioException("Invalid response.");
			}
			
			HashMap<String, String> params = new HashMap<String, String>();
			for (int i = 0; i < result.getChildNodes().getLength(); i++) {
				Node node = (Node) result.getChildNodes().item(i);
				
				if (!"#text".equals(node.getNodeName())) {
					params.put(node.getNodeName(), node.getTextContent());
				}
				
				if ("message".equals(node.getNodeName()) 
						&& node.getTextContent().trim().length() > 0) {
					 throw new DefensioException(node.getTextContent());
				}
			}
			
			return params;
			
		} catch (SAXException e) {
			throw new DefensioException("Invalid response.");
			
		} catch (IOException e) {
			throw new DefensioException(e);
			
		} catch (ParserConfigurationException e) {
			throw new DefensioException(e);
		}		
	}
	
	/**
	 * Populates in the response the parameters contained in every Defensio response.
	 * @param response
	 * @param params
	 */
	private void populateDefaultParametersInResponse(DefensioResponse response, HashMap params) {
		response.setMessage((String) params.get("message"));
		response.setStatus((String) params.get("status"));
		response.setApiVersion((String) params.get("api-version"));
	}

	/**
	 * API call to audit-comment
	 * @param request
	 * @return
	 * @throws DefensioException
	 */
	public AuditCommentResponse auditComment(AuditCommentRequest request) throws DefensioException {
		PostMethod post = new PostMethod(request.getFullURL());
		post.addParameter("client", request.getClient());
		post.addParameter("content", request.getContent());
		post.addParameter("platform", request.getPlatform());
		post.addParameter("type", request.getType());
		
		System.out.println(request.getFullURL());
		String postResponse = sendRequest(post);
		System.out.println("Response: " + postResponse);
		HashMap parsedResponse = parseResponse(postResponse);
		
		AuditCommentResponse response = new AuditCommentResponse();
		populateDefaultParametersInResponse(response, parsedResponse);
		response.setAllow((Boolean.parseBoolean((String)parsedResponse.get("allow"))));
		response.setClassification((String)parsedResponse.get("classification"));
		response.setProfanityMatch((Boolean.parseBoolean((String)parsedResponse.get("profanity-match"))));
		response.setSignature((String)parsedResponse.get("signature"));
		response.setSpaminess(Float.valueOf((String)parsedResponse.get("spaminess")));
		
		return response;
	}
}
