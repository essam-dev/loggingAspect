package com.itcsb.discovery.loggingAspect.enums;

public enum BusinessAction {
	EMPTY("EMPTY", "default value"), CCS("CCS", "Commande Client Saved"), CCC("CCC", "Commande Client Canceled"), BVS(
			"BVS", "Bulletin Vente Saved"), BVC("BVC",
					"Bulletin Vente Canceled"), DS("DS", "Devis Saved"), DC("DC", "Devis Canceled");

	private String name = "";
	private String editor = "";

	BusinessAction(String name, String editor) {
		this.name = name;
		this.editor = editor;
	}

	BusinessAction(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
