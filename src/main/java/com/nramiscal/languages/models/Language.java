package com.nramiscal.languages.models;

import javax.validation.constraints.Size;

public class Language {
	@Size(min = 3, max = 20)
    private String name;
	@Size(min = 3, max = 20)
    private String creator;
	@Size(min = 1, max = 20)
    private String version;
    
    public Language() {
    }

	public Language(String name, String creator, String version) {
		super();
		this.name = name;
		this.creator = creator;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public String getCreator() {
		return creator;
	}

	public String getVersion() {
		return version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setVersion(String version) {
		this.version = version;
	}
    
    
    
}