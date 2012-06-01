package br.unifor.grafos.algoritmo;

public class BellmanFord {

	private double[][] matriz;

	private double[] peso;

	private Integer[] pai;

	private Integer grau;

	public BellmanFord(double[][] matrizAdjacencia) {
		this.matriz = matrizAdjacencia;
		this.grau = matrizAdjacencia.length;
		this.peso = new double[grau];
		this.pai = new Integer[grau];
	}

	public void executar(int inicio) {
		for (int i = 0; i < grau; i++) {
			peso[i] = Double.POSITIVE_INFINITY;
			pai[i] = null;
		}

		peso[inicio] = (double) 0;

		imprimir();
		
		for (int i = 0; i < grau - 1; i++) {
			for (int u = 0; u < matriz.length; u++) {
				for (int v = 0; v < matriz.length; v++) {
					double pesoEntreUeV = matriz[u][v];

					if (pesoEntreUeV != 0) {
						if (peso[u] + pesoEntreUeV < peso[v]) {
							peso[v] = peso[u] + pesoEntreUeV;
							pai[v] = u;
						}
					}
				}
			}

			imprimir();
		}
	}

	public boolean temCicloNegativo() {
		for (int i = 0; i < grau - 1; i++) {
			for (int u = 0; u < matriz.length; u++) {
				for (int v = 0; v < matriz.length; v++) {
					if (peso[u] + matriz[u][v] < peso[v]) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

	private void imprimir() {
		for (int i = 0; i < grau; i++) {
			String p = (peso[i] == Double.POSITIVE_INFINITY ? "INF" : String.valueOf(peso[i]));
			System.out.println(i + "-[PAI:" + pai[i] + ", PESO:" + p + "] ");
		}
		System.out.print("\n");
	}

}
