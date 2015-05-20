package GetDetailLevelNumberPack;

import java.util.HashMap;
import java.util.Map;

public class GetDetailLevelNumber {

	private GetDetailLevelNumberPack.Result Result;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The Result
	 */
	public GetDetailLevelNumberPack.Result getResult() {
		return Result;
	}

	/**
	 * 
	 * @param Result
	 *            The Result
	 */
	public void setResult(GetDetailLevelNumberPack.Result Result) {
		this.Result = Result;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}