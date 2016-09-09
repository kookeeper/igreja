package listaFamilia;

import java.io.IOException;

public class Lista {
	
	public static void main(String[] args) throws IOException {
		ListaAniversario.gerarArquivo();
		ListaCasamento.gerarArquivo();
		ListaFamilia.gerarArquivo();
		ListaNome.gerarArquivo();
		ListaProfissao.gerarArquivo();
	}

}
