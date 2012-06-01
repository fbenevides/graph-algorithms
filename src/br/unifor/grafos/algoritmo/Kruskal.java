package br.unifor.grafos.algoritmo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Kruskal {

	private double[][] matriz;

	private int numeroDeVertices;

	private FilaDePrioridade filaDePrioridade;

	private HashSet<Integer>[] componentes;

	private ArrayList<Aresta> solucao;

	@SuppressWarnings("unchecked")
	public Kruskal(double[][] matriz) {
		this.matriz = matriz;
		this.numeroDeVertices = matriz.length;
		this.filaDePrioridade = new FilaDePrioridade(numeroDeVertices);
		this.componentes = new HashSet[numeroDeVertices];

		for (int i = 0; i < numeroDeVertices; i++) {
			for (int j = 0; j < numeroDeVertices; j++) {

				double peso = matriz[i][j];
				if (peso == 0 || peso == Double.POSITIVE_INFINITY) {
					continue;
				}

				Aresta aresta = new Aresta(i, j, matriz[i][j]);

				filaDePrioridade.adicionar(aresta);

				if (componentes[i] == null) {
					componentes[i] = new HashSet<Integer>();
					componentes[i].add(i);
				}

				if (componentes[j] == null) {
					componentes[j] = new HashSet<Integer>();
					componentes[j].add(j);
				}
			}
		}

		System.out.println(filaDePrioridade);
	}

	public List<Aresta> executar() {
		this.solucao = new ArrayList<Aresta>();

		while (solucao.size() < matriz.length - 1) {

			Aresta arestaMenorPeso = filaDePrioridade
					.removeArestaComPesoMinimo();
			
			System.out.println("FILA: " + filaDePrioridade);
			
			if (arestaLigaDuasArvores(arestaMenorPeso)) {
				solucao.add(arestaMenorPeso);
				System.out.println("S: " + solucao);

				componentes[arestaMenorPeso.getOrigem()].addAll(componentes[arestaMenorPeso.getDestino()]);
				componentes[arestaMenorPeso.getDestino()] = null;
			}
		}

		return solucao;
	}

	private boolean arestaLigaDuasArvores(Aresta arestaMenorPeso) {
		return componentes[arestaMenorPeso.getOrigem()] != null
				&& componentes[arestaMenorPeso.getDestino()] != null
				&& componentes[arestaMenorPeso.getOrigem()] != (componentes[arestaMenorPeso.getDestino()]);
	}

	public Double custo() {
		Double custoTotal = 0.0;
		for (int i = 0; i < solucao.size(); i++) {
			custoTotal += solucao.get(i).getPeso();
		}

		return custoTotal;
	}

}
