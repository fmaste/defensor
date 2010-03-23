package defensio.requests;

public class AuditCommentRequest extends DefensioRequest {

	private String client = null;
	private String content = null;
	private String platform = null;
	private String type = null;
	private boolean async = false;
	private String asyncCallback = null;
	private String authorEmail = null;
	private String authorIp = null;
	private boolean authorLoggedIn = false;
	private String authorName = null;
	private String authorOpenId = null;
	private boolean authorTrusted = false;
	private String authorUrl = null;
	private Boolean browserCookies = null;
	private Boolean browserJavascript = null;
	private String documentPermalink = null;
	private String httpHeaders = null;
	private String parentDocumentDate = null;
	private String parentDocumentPermalink = null;
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAsync() {
		return async;
	}
	public void setAsync(boolean async) {
		this.async = async;
	}
	public String getAsyncCallback() {
		return asyncCallback;
	}
	public void setAsyncCallback(String asyncCallback) {
		this.asyncCallback = asyncCallback;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getAuthorIp() {
		return authorIp;
	}
	public void setAuthorIp(String authorIp) {
		this.authorIp = authorIp;
	}
	public boolean isAuthorLoggedIn() {
		return authorLoggedIn;
	}
	public void setAuthorLoggedIn(boolean authorLoggedIn) {
		this.authorLoggedIn = authorLoggedIn;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorOpenId() {
		return authorOpenId;
	}
	public void setAuthorOpenId(String authorOpenId) {
		this.authorOpenId = authorOpenId;
	}
	public boolean isAuthorTrusted() {
		return authorTrusted;
	}
	public void setAuthorTrusted(boolean authorTrusted) {
		this.authorTrusted = authorTrusted;
	}
	public String getAuthorUrl() {
		return authorUrl;
	}
	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}
	public Boolean getBrowserCookies() {
		return browserCookies;
	}
	public void setBrowserCookies(Boolean browserCookies) {
		this.browserCookies = browserCookies;
	}
	public Boolean getBrowserJavascript() {
		return browserJavascript;
	}
	public void setBrowserJavascript(Boolean browserJavascript) {
		this.browserJavascript = browserJavascript;
	}
	public String getDocumentPermalink() {
		return documentPermalink;
	}
	public void setDocumentPermalink(String documentPermalink) {
		this.documentPermalink = documentPermalink;
	}
	public String getHttpHeaders() {
		return httpHeaders;
	}
	public void setHttpHeaders(String httpHeaders) {
		this.httpHeaders = httpHeaders;
	}
	public String getParentDocumentDate() {
		return parentDocumentDate;
	}
	public void setParentDocumentDate(String parentDocumentDate) {
		this.parentDocumentDate = parentDocumentDate;
	}
	public String getParentDocumentPermalink() {
		return parentDocumentPermalink;
	}
	public void setParentDocumentPermalink(String parentDocumentPermalink) {
		this.parentDocumentPermalink = parentDocumentPermalink;
	}
	
}
