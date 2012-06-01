package br.unifor.grafos.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDeArquivo {

	private final File arquivo;

	private final FileReader reader;
	
	public LeitorDeArquivo(String nomeDoArquivo) throws FileNotFoundException {
		this.arquivo = new File(nomeDoArquivo);
		this.reader = new FileReader("resources/" + this.arquivo);
	}
	
	public double[][] ler() throws NumberFormatException, IOException {
		BufferedReader leitor = new BufferedReader(this.reader);

		String line;
		Integer numeroDaLinha = 0;
		Integer numeroDaColuna;

		Integer numeroDeVertices = Integer.parseInt(leitor.readLine().trim());

		double[][] matrizDeAdjacencia = new double[numeroDeVertices][numeroDeVertices];
		
		while ((line = leitor.readLine()) != null) {
			numeroDaColuna = 0;

			String[] splitted = line.split("\\s");

			for (int i = 0; i < splitted.length; i++) {

				if ("inf".equalsIgnoreCase(splitted[i].trim())) {
					matrizDeAdjacencia[numeroDaLinha][numeroDaColuna] = Double.POSITIVE_INFINITY;
				} else {
					Integer valor = Integer.parseInt(splitted[i].trim());
					matrizDeAdjacencia[numeroDaLinha][numeroDaColuna] = valor;
				}

				numeroDaColuna++;
			}

			numeroDaLinha++;
		}

		return matrizDeAdjacencia;
	}

}
