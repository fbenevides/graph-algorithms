package br.unifor.grafos.main;

import java.io.IOException;

import br.unifor.grafos.algoritmo.BellmanFord;
import br.unifor.grafos.io.LeitorDeArquivo;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		LeitorDeArquivo leitor = new LeitorDeArquivo("3.txt");
		double[][] matriz = leitor.ler();
		
		BellmanFord b = new BellmanFord(matriz);
		b.executar(0);
		
		System.out.println("Tem ciclo: " + b.temCicloNegativo());
	}
	
}
