import java.util.Scanner;

public class JogoLauncher {

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		Scanner sc = new Scanner(System.in);
		Boolean isContinuarJogo = Boolean.TRUE;
		System.out.println("Digite (?) a qualquer momento para pedir uma dica");
		while (isContinuarJogo) {
			System.out.println("Informe uma Letra");
			String inputString = sc.next();

			if ("?".equals(inputString)) {
				jogo.pedirDica();
			} else {
				isContinuarJogo = jogo.informarLetra(inputString);
			}
			clearConsole();
		}

		sc.close();
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}	

}
