package listaFamilia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ListaAniversario {

	private static String splitter = "	";
	private static String diretorio = "./res/";
	private static String nomeArquivo = diretorio + "LISTA DE FAMILIAS 2016.txt";
	private static String nomeArquivoNovo = diretorio + "LISTA_ANIVERSARIO_2016.txt";

	public static void gerarArquivo() throws IOException {
		File arquivo = new File(nomeArquivo);
		File arquivoNovo = new File(nomeArquivoNovo);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "utf-16"));
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(arquivoNovo), "utf-16"));

		String linha = reader.readLine();
		writer.write("Nome	Nascimento	Sexo");
		writer.newLine();

		while ((linha = reader.readLine()) != null) {
			String[] campos = linha.split(splitter);

			if ((campos.length > 4) && (!campos[4].equals(""))) {
				writer.write(campos[2] + "	" + campos[4] + "	" + campos[3]);
				writer.newLine();
			}
		}

		writer.flush();
		writer.close();
		reader.close();
	}
}
