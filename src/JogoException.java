/**
 * 
 * Classe de exceção do Jogo
 * @author Saymon
 *
 */
public class JogoException extends Exception {
	private static final long serialVersionUID = 4284698191340939009L;
	private final Integer codigo;
	private final String mensagem;
	
	public JogoException(Integer codigo, String mensagem) {
		super();
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}


	public String getMensagem() {
		return mensagem;
	}

	
	
}
