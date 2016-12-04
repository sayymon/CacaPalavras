
public enum TipoFimJogoEnum {
	GANHOU(1),
	PERDEU(2);
	
	private final Integer codigo;

	private TipoFimJogoEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	
}
