package com.fernando.oliveira.traveler.domain.enums;

public enum Status {
	ACTIVE("A","Ativo"),
	INACTIVE("I","Inativo");
	
	private String code;
	private String description;
	
	Status(String code, String description) {
	
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
    public static Status toEnum(String code) {
		
		if(code == null){
			return null;
		}
		
		for(Status status: Status.values()) {
			if(status.getCode().equals(code)) {
				return status;
			}
		}
		
		throw new IllegalArgumentException("código inexistente: "+ code);
		
	}
}
