package listaFamilia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lista {

	private static String nomeArquivo = "/Users/Sergio/Google Drive/Igreja/Lista de Discípulos/LISTA DE FAMÍLIAS 2016.csv";
	private static String nomeArquivoNovo = "/Users/Sergio/Google Drive/Igreja/Lista de Discípulos/LISTA_FAMILIAS_2016.csv";
	
	public static void main(String[] args) throws IOException {
		String splitter = ",";
		File arquivo = new File(nomeArquivo);
		File arquivoNovo = new File(nomeArquivoNovo);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "windows-1252"));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivoNovo), "windows-1252"));
		
		String linha = reader.readLine();
		System.out.println(linha);
		String novaLinha = linha + splitter + linha + splitter + linha + splitter + linha + splitter + linha + splitter + linha;
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
			novaLinha += linha + splitter;
		}
		writer.flush();
		writer.close();
		reader.close();
	}
}
