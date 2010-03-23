package defensio.requests;

import defensio.model.constants.Defensio;

public abstract class DefensioRequest {

	private String _apiUrl = Defensio.REST_SERVER;
	private String _serviceType = "users";
	private String _apiVersion = "2.0";
	private String _action = "documents";
	private String _apiKey = null;
	private String _format = "xml";
	
	public String getFullURL() {
		return _apiUrl + "/" + _apiVersion + "/" + _serviceType + "/" + _apiKey +  "/" + _action 
						+ "." + _format; 
	}
	
	public String getApiUrl() {
		return _apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		_apiUrl = apiUrl;
	}
	public String getAction() {
		return _action;
	}
	public void setAction(String action) {
		_action = action;
	}
	public String getApiKey() {
		return _apiKey;
	}
	public void setApiKey(String apiKey) {
		_apiKey = apiKey;
	}
	public String getApiVersion() {
		return _apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		_apiVersion = apiVersion;
	}
	public String getServiceType() {
		return _serviceType;
	}
	public void setServiceType(String serviceType) {
		_serviceType = serviceType;
	}
	public String getFormat() {
		return _format;
	}
	public void setFormat(String format) {
		_format = format;
	}
}
