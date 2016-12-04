import java.util.Set;

public final class Jogo {
	
	private ControladorJogo controladorJogo;
			
	public Jogo() {
		System.out.println("Iniciando o Jogo");
		controladorJogo = ControladorJogo.iniciarJogo();
	}

	public Boolean informarLetra(String letra){
		Boolean isContinuarJogo = Boolean.TRUE; 
		try {
			controladorJogo.informarLetra(letra);
			System.out.println("Palavra Sendo Formada :"+ controladorJogo.getPalavraSendoFormada());
			System.out.println("letras Informadas :"+ controladorJogo.getLetrasInformadas());
		} catch (JogoException e) {
			System.out.println(e.getMensagem());
			isContinuarJogo = Boolean.FALSE; 
		}
		exibirBonecoForca();
		
		return isContinuarJogo;
	}

	private void exibirBonecoForca() {
		Set<ParteCorpoEnum> partesCorpoBoneco = controladorJogo.getBonecoForca().getPartesCorpoBoneco();
		System.out.println(partesCorpoBoneco.contains(ParteCorpoEnum.CABECA) ? ParteCorpoEnum.CABECA.getCaracterParteCorpo() : "");
		System.out.println((partesCorpoBoneco.contains(ParteCorpoEnum.MAO_ESQUERDA) ? ParteCorpoEnum.MAO_ESQUERDA.getCaracterParteCorpo() : " ") +
						   (partesCorpoBoneco.contains(ParteCorpoEnum.BRACO_ESQUERDO) ? ParteCorpoEnum.BRACO_ESQUERDO.getCaracterParteCorpo() : " ") +
						   (partesCorpoBoneco.contains(ParteCorpoEnum.COLUNA) ? ParteCorpoEnum.COLUNA.getCaracterParteCorpo() : " ")+
						   (partesCorpoBoneco.contains(ParteCorpoEnum.BRACO_DIREITO) ? ParteCorpoEnum.BRACO_DIREITO.getCaracterParteCorpo() : " ") +
						   (partesCorpoBoneco.contains(ParteCorpoEnum.MAO_DIREITA) ? ParteCorpoEnum.MAO_DIREITA.getCaracterParteCorpo() : " ")						   
				);
		System.out.println((partesCorpoBoneco.contains(ParteCorpoEnum.PE_ESQUERDO) ? ParteCorpoEnum.PE_ESQUERDO.getCaracterParteCorpo() : " ") +
				   (partesCorpoBoneco.contains(ParteCorpoEnum.PERNA_ESQUERDA) ? ParteCorpoEnum.PERNA_ESQUERDA.getCaracterParteCorpo() : " ") +
				   (partesCorpoBoneco.contains(ParteCorpoEnum.PERNA_DIREITA) ? ParteCorpoEnum.PERNA_DIREITA.getCaracterParteCorpo() : " ") +
				   (partesCorpoBoneco.contains(ParteCorpoEnum.PE_DIREITO) ? ParteCorpoEnum.PE_DIREITO.getCaracterParteCorpo() : " ")						   
		);		
	}
	
	public void pedirDica(){
		try {
			System.out.println(controladorJogo.obterLetraDica());
		} catch (JogoException e) {
			System.err.println(e.getMensagem());
		}
	}
	
}
