package listaFamilia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ListaProfissao {

	private static String splitter = "	";
	private static String diretorio = "/Users/Sergio/git/igreja/listaFamilia/res/";
	private static String nomeArquivo = diretorio + "LISTA DE FAMILIAS 2016 2.txt";
	private static String nomeArquivoNovo = diretorio + "LISTA_PROFISSAO_2016.txt";

	public static void main(String[] args) throws IOException {
		File arquivo = new File(nomeArquivo);
		File arquivoNovo = new File(nomeArquivoNovo);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "utf-16"));
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(arquivoNovo), "utf-16"));

		String linha = reader.readLine();
		writer.write("Nome	Profissão	Telefone");
		writer.newLine();
		while ((linha = reader.readLine()) != null) {
			String[] campos = linha.split(splitter);

			if ((campos.length > 9) && (!campos[9].equals(""))) {
				writer.write(campos[2] + " " + campos[0] + "	" + campos[9] + "	" + campos[8]);
				writer.newLine();
			}
		}

		writer.flush();
		writer.close();
		reader.close();
	}
}
