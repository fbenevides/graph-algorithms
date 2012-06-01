package br.unifor.grafos.algoritmo;

public class Aresta {

	private final Integer origem;

	private final Integer destino;

	private final Double peso;

	public Aresta(int origem, int destino, double peso) {
		this.origem = origem;
		this.destino = destino;
		this.peso = peso;
	}

	public Integer getOrigem() {
		return origem;
	}

	public Integer getDestino() {
		return destino;
	}

	public Double getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return  "(" + origem + ", " + destino + ")";
		
	}
	
}
