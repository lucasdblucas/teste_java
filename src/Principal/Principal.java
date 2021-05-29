package Principal;

import java.io.IOException;

import arquivo_contato.Contato;

public class Principal {
	private static Contato contato;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		contato = new Contato();
		try {
			contato.RecuperarLista();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
