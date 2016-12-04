import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public final class ControladorJogo {
	
	
	private static final Short QTD_TENTATIVAS_MAXIMO = 9;
	private static final Short QTD_DICAS_MAXIMO = 1;
	private String palavra;
	private String palavraSendoFormada = "";
	private Short tentativas = 0;
	private Set<String> letrasInformadas = new HashSet<String>();
	private Short pedidoDica = 0;
	private BonecoForca bonecoForca;


	public static ControladorJogo iniciarJogo(){
		return new ControladorJogo();
	}
	private ControladorJogo() {
		this.palavra = obterPalavraForcaRandomicamente();
		for (int i = 0; i < palavra.length(); i++) {
			palavraSendoFormada = palavraSendoFormada+"_";
		}
		bonecoForca = new BonecoForca();
	}
	private String obterPalavraForcaRandomicamente() {
		List<String> palavrasForca = BuscadorPalavrasChaves.buscarListaPalavrasForca();
		return palavrasForca.get(ThreadLocalRandom.current().nextInt(0,palavrasForca.size()));
	}
	
	private Boolean verificarLetraEmPalavra(String letra){
		return palavra.contains(letra);
	}

	public String informarLetra(String letra) throws JogoException{
		if (letra != null && letra.length() == 1) {
			String letraUp = letra.toUpperCase();
			if (!letrasInformadas.contains(letraUp) && verificarLetraEmPalavra(letraUp)) {
				atualizarPalavraSendoInformada(letra.toUpperCase());
			}else{
				bonecoForca.getPartesCorpoBoneco().add(ParteCorpoEnum.values()[tentativas]);
				tentativas++;
			}
			letrasInformadas.add(letraUp);
		}
		
		verificarFimDeJogo();
		
		return palavraSendoFormada;
	}
	
	private void atualizarPalavraSendoInformada(String letra) {
		int qtdLetrasNaPalavra = palavra.length() - palavra.replaceAll(letra, "").length();
		
		int indexOf = 0; 
		for (int i = 0; i < qtdLetrasNaPalavra; i++) {

			if (i == 0) {
				indexOf = palavra.indexOf(letra);
			}else{
				indexOf++;
				indexOf = palavra.indexOf(letra, indexOf);
			}
			
			if ((indexOf+1) != palavra.length()) {
				if (indexOf == 0) {
					palavraSendoFormada = letra + palavraSendoFormada.substring(indexOf+1,palavra.length());
				}else{
					palavraSendoFormada = palavraSendoFormada.substring(0,indexOf)+letra+palavraSendoFormada.substring(indexOf+1,palavraSendoFormada.length());
				}
			}else{
				palavraSendoFormada = palavraSendoFormada.substring(0,indexOf)+letra;
			}				
		}
	}	
	
	void verificarFimDeJogo() throws JogoException{
		if (tentativas > QTD_TENTATIVAS_MAXIMO) {
			throw new JogoException(TipoFimJogoEnum.PERDEU.getCodigo(),"Que pena,vc perdeu !!! a palavra era :"+palavra);
		}
		
		if (palavraSendoFormada.equals(palavra)){
			throw new JogoException(TipoFimJogoEnum.GANHOU.getCodigo(),"Parabéns você ganhou a palavra é : " + getPalavraSendoFormada());
		}
	}
	public String getPalavraSendoFormada() {
		return palavraSendoFormada;
	}
	public Short getTentativas() {
		return tentativas;
	}
	public Set<String> getLetrasInformadas() {
		return letrasInformadas;
	}
	public String obterLetraDica() throws JogoException {
		pedidoDica++;
		if (pedidoDica > QTD_DICAS_MAXIMO) {
			throw new JogoException(99,"acabaram a quantidade de dicas : " + QTD_DICAS_MAXIMO);
		}
		String letraDica = "";
		
		for (char c : palavra.toCharArray()) {
			if (!letrasInformadas.contains(String.valueOf(c))) {
				letraDica = String.valueOf(c);
				break;
			}
		}
		return letraDica;
	}
	public BonecoForca getBonecoForca() {
		return bonecoForca;
	}
	
	
	
}
