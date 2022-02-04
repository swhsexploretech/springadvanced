package com.demo.jpa.ssc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminConsoleMaster {
	
	private int id;
	
	private int category_id;
	
	private int region_id;
	
	private String keyDesc;
	
	private String biz_svc_line;
	
	private String biz_owner;
	
	private int active_flag;
	
	private String keyValue;
	
	private int encrypted;
	
	private String isPublic;
	

	public AdminConsoleMaster() {
		super();
	}

	public AdminConsoleMaster(int id, int category_id, int region_id, String keyDesc, String biz_svc_line,
			String biz_owner, int active_flag, String keyValue, int encrypted, String isPublic) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.region_id = region_id;
		this.keyDesc = keyDesc;
		this.biz_svc_line = biz_svc_line;
		this.biz_owner = biz_owner;
		this.active_flag = active_flag;
		this.keyValue = keyValue;
		this.encrypted = encrypted;
		this.isPublic = isPublic;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public String getKeyDesc() {
		return keyDesc;
	}

	public void setKeyDesc(String keyDesc) {
		this.keyDesc = keyDesc;
	}

	public String getBiz_svc_line() {
		return biz_svc_line;
	}

	public void setBiz_svc_line(String biz_svc_line) {
		this.biz_svc_line = biz_svc_line;
	}

	public String getBiz_owner() {
		return biz_owner;
	}

	public void setBiz_owner(String biz_owner) {
		this.biz_owner = biz_owner;
	}

	public int getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(int active_flag) {
		this.active_flag = active_flag;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public int getEncrypted() {
		return encrypted;
	}

	public void setEncrypted(int encrypted) {
		this.encrypted = encrypted;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	@Override
	public String toString() {
		return "AdminConsoleMaster [id=" + id + ", category_id=" + category_id + ", regionID=" + region_id + ", keyDesc="
				+ keyDesc + ", biz_svc_line=" + biz_svc_line + ", biz_owner=" + biz_owner + ", active_flag="
				+ active_flag + ", keyValue=" + keyValue + ", encrypted=" + encrypted + ", isPublic=" + isPublic + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active_flag;
		result = prime * result + ((biz_owner == null) ? 0 : biz_owner.hashCode());
		result = prime * result + ((biz_svc_line == null) ? 0 : biz_svc_line.hashCode());
		result = prime * result + category_id;
		result = prime * result + encrypted;
		result = prime * result + id;
		result = prime * result + ((isPublic == null) ? 0 : isPublic.hashCode());
		result = prime * result + ((keyDesc == null) ? 0 : keyDesc.hashCode());
		result = prime * result + ((keyValue == null) ? 0 : keyValue.hashCode());
		result = prime * result + region_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminConsoleMaster other = (AdminConsoleMaster) obj;
		if (active_flag != other.active_flag)
			return false;
		if (biz_owner == null) {
			if (other.biz_owner != null)
				return false;
		} else if (!biz_owner.equals(other.biz_owner))
			return false;
		if (biz_svc_line == null) {
			if (other.biz_svc_line != null)
				return false;
		} else if (!biz_svc_line.equals(other.biz_svc_line))
			return false;
		if (category_id != other.category_id)
			return false;
		if (encrypted != other.encrypted)
			return false;
		if (id != other.id)
			return false;
		if (isPublic == null) {
			if (other.isPublic != null)
				return false;
		} else if (!isPublic.equals(other.isPublic))
			return false;
		if (keyDesc == null) {
			if (other.keyDesc != null)
				return false;
		} else if (!keyDesc.equals(other.keyDesc))
			return false;
		if (keyValue == null) {
			if (other.keyValue != null)
				return false;
		} else if (!keyValue.equals(other.keyValue))
			return false;
		if (region_id != other.region_id)
			return false;
		return true;
	}
	
	
	
	

}
