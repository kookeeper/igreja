package listaFamilia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class Lista {

	private static String splitter = "	";
	private static String diretorio = "/Users/Sergio/git/igreja/listaFamilia/res/";
	private static String nomeArquivo = diretorio + "LISTA DE FAMILIAS 2016 2.txt";
	private static String nomeArquivoNovo = diretorio + "LISTA_FAMILIAS_2016.txt";
	
	public static void main(String[] args) throws IOException {
		File arquivo = new File(nomeArquivo);
		File arquivoNovo = new File(nomeArquivoNovo);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "utf-8"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivoNovo), "utf-8"));
		processarArquivo(reader, writer);
	}

	private static void processarArquivo(BufferedReader reader, BufferedWriter writer) throws IOException {
		String linha = reader.readLine();
		String novaLinha = linha + "	" + linha + "	" + linha + "	" + linha + "	" + linha + "	" + linha;
		writer.write(novaLinha);
		writer.newLine();
		novaLinha = "";
		while ((linha = reader.readLine()) != null) {
			if (linha.split(splitter).length == 0) {
				writer.write(novaLinha);
				writer.newLine();
				novaLinha = "";
				continue;
			}
			novaLinha += linha + "	";
		}
		if (novaLinha != "") {
			writer.write(novaLinha);
			writer.newLine();
		}
		
		writer.flush();
		writer.close();
		reader.close();
	}
}
