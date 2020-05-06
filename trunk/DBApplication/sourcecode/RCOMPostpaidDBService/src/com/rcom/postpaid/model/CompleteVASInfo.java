package com.rcom.postpaid.model;

/**
 * 
 * @author deepanyuvaraja.r
 *
 */
public class CompleteVASInfo {
	
	private String appName;
	private String circleId;
	private String phraseId;
	private String packId;
	private String productType;
	private String startDate;
	private String endDate;
	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getPhraseId() {
		return phraseId;
	}
	public void setPhraseId(String phraseId) {
		this.phraseId = phraseId;
	}
	public String getPackId() {
		return packId;
	}
	public void setPackId(String packId) {
		this.packId = packId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[AppName:"+appName);
		builder.append(", CircleId:"+circleId);
		builder.append(", PhraseId:"+phraseId);
		builder.append(", PackId:"+packId);
		builder.append(", ProductType:"+productType);
		builder.append(", StartDate:"+startDate);
		builder.append(", EndDate:"+endDate+"]");
		return builder.toString();
	}

}
