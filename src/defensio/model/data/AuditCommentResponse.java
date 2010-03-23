package defensio.model.data;

public class AuditCommentResponse extends DefensioResponse {

	private boolean _allow = false;
	private String _classification = null;
	private boolean _profanityMatch = false;
	private String _signature = null;
	private float _spaminess = 0;
	
	
	public boolean isAllow() {
		return _allow;
	}
	public void setAllow(boolean allow) {
		_allow = allow;
	}
	public String getClassification() {
		return _classification;
	}
	public void setClassification(String classification) {
		_classification = classification;
	}
	public boolean isProfanityMatch() {
		return _profanityMatch;
	}
	public void setProfanityMatch(boolean profanityMatch) {
		_profanityMatch = profanityMatch;
	}
	public String getSignature() {
		return _signature;
	}
	public void setSignature(String signature) {
		_signature = signature;
	}
	public float getSpaminess() {
		return _spaminess;
	}
	public void setSpaminess(float spaminess) {
		_spaminess = spaminess;
	}
}
