package com.javaavancado.ouvidoria.entities.enums;

public enum TicketType {
	
	ELOGIO(1),
	SUGESTAO(2),
	RECLAMACAO(3);
	
	private int code;
	
	private TicketType(int code) {
		this.setCode(code);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public static TicketType valueOf(int code) {
		for(TicketType value : TicketType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Tipo de chamada inexistente.");
	}
}