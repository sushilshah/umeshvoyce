/**
 * 
 */
package voyce.com.template.model;

/**
 * @author DeadCode
 *
 */
public class FeedTemplate {

	private String templateType;
	private String temlatexyz;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return templateType+","+temlatexyz;
	}

	/**
	 * @return the templateType
	 */
	public String getTemplateType() {
		return templateType;
	}

	/**
	 * @param templateType the templateType to set
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	/**
	 * @return the temlatexyz
	 */
	public String getTemlatexyz() {
		return temlatexyz;
	}

	/**
	 * @param temlatexyz the temlatexyz to set
	 */
	public void setTemlatexyz(String temlatexyz) {
		this.temlatexyz = temlatexyz;
	}
}
