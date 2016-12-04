
public enum ParteCorpoEnum {
	CABECA		  (" ( )"),
	MAO_ESQUERDA  ("o"),
	BRACO_ESQUERDO("-"),
	BRACO_DIREITO ("-"),
	MAO_DIREITA   ("o"),
	COLUNA        ("|"),
	PE_ESQUERDO   ("o"),
	PERNA_ESQUERDA("/ "),
	PERNA_DIREITA ("\\"),
	PE_DIREITO    ("o");
	
	private final String caracterParteCorpo;

	private ParteCorpoEnum(String caracterParteCorpo) {
		this.caracterParteCorpo = caracterParteCorpo;
	}

	public String getCaracterParteCorpo() {
		return caracterParteCorpo;
	}
	
	
	
	
}
