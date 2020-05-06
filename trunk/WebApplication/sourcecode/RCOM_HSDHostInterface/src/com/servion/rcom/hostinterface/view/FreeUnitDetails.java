package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants;


public class FreeUnitDetails {

	private String FRU_Category;
	private String FRU_AllocatedUnits;
	private String FRU_ConsumedUnits;
	private String FRU_RemainingUnits;
	private String FRU_PeriodEndDate;
	private String FRU_UnitOfMeasurement;
	public String getFRU_Category() {
		return FRU_Category;
	}
	public void setFRU_Category(String fRU_Category) {
		FRU_Category = fRU_Category;
	}
	public String getFRU_AllocatedUnits() {
		return FRU_AllocatedUnits;
	}
	public void setFRU_AllocatedUnits(String fRU_AllocatedUnits) {
		FRU_AllocatedUnits = fRU_AllocatedUnits;
	}
	public String getFRU_ConsumedUnits() {
		return FRU_ConsumedUnits;
	}
	public void setFRU_ConsumedUnits(String fRU_ConsumedUnits) {
		FRU_ConsumedUnits = fRU_ConsumedUnits;
	}
	public String getFRU_RemainingUnits() {
		return FRU_RemainingUnits;
	}
	public void setFRU_RemainingUnits(String fRU_RemainingUnits) {
		FRU_RemainingUnits = fRU_RemainingUnits;
	}
	public String getFRU_PeriodEndDate() {
		return FRU_PeriodEndDate;
	}
	public void setFRU_PeriodEndDate(String fRU_PeriodEndDate) {
		FRU_PeriodEndDate = fRU_PeriodEndDate;
	}
	public String getFRU_UnitOfMeasurement() {
		return FRU_UnitOfMeasurement;
	}
	public void setFRU_UnitOfMeasurement(String fRU_UnitOfMeasurement) {
		FRU_UnitOfMeasurement = fRU_UnitOfMeasurement;
	}
	@Override
	public String toString() {
		return FRU_Category
				+ HostConstants.PIPE + FRU_AllocatedUnits
				+ HostConstants.PIPE + FRU_ConsumedUnits
				+ HostConstants.PIPE + FRU_RemainingUnits
				+ HostConstants.PIPE + FRU_PeriodEndDate
				+ HostConstants.PIPE + FRU_UnitOfMeasurement;
	}
	
}
