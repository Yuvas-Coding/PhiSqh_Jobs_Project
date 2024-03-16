package my.com.cmg.iwp.integration;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import my.com.cmg.iwp.webui.constant.RefCodeConstant;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Acknowledgement implements Serializable{
	
	String entityName;
	String primaryKeyColumnName;
	String updateColumnName;
	String updateColumnValue = RefCodeConstant.BOOLEAN_NO;
	List<Long> primaryKeyValues;
	
	Map<String, Object> additionalInfo;

	public String getEntityName() {
		return entityName;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getPrimaryKeyColumnName() {
		return primaryKeyColumnName;
	}
	public void setPrimaryKeyColumnName(String primaryKeyColumnName) {
		this.primaryKeyColumnName = primaryKeyColumnName;
	}
	public String getUpdateColumnName() {
		return updateColumnName;
	}
	public void setUpdateColumnName(String updateColumnName) {
		this.updateColumnName = updateColumnName;
	}
	public String getUpdateColumnValue() {
		return updateColumnValue;
	}
	public void setUpdateColumnValue(String updateColumnValue) {
		this.updateColumnValue = updateColumnValue;
	}

	public List<Long> getPrimaryKeyValues() {
		return primaryKeyValues;
	}
	public void setPrimaryKeyValues(List<Long> primaryKeyValues) {
		this.primaryKeyValues = primaryKeyValues;
	}

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, Object> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	
	

}
