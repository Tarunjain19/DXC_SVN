package com.rcom.prepaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name="TBL_MENUMASTER")
@NamedStoredProcedureQuery(name="GetMenuDetailSP", procedureName = "PROC_GETALLMENUS", resultClasses = com.rcom.prepaid.model.MenuMaster.class)
public class MenuMaster {
	
	@Id
	@Column(name = "MENUID")
	private String menuId;
	@Column(name = "MENUDESCRIPTION")
	private String menuDescription;
	@Column(name = "CREATEDDATE")
	private String createDate;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "PARENTID")
	private String parentId;
	@Column(name = "FORMNAME")
	private String  formName;
	
	
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getMenuDescription() {
		return menuDescription;
	}
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	
	
	@Override
	public String toString() {
	System.out.println(menuId+","+parentId+","+status+","+menuId);
		return (menuId+","+parentId+","+status+","+menuId).toString();
	}
	

}
