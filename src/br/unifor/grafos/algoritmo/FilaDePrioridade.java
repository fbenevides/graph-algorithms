package br.unifor.grafos.algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilaDePrioridade {

	private final List<Aresta> fila;

	public FilaDePrioridade(int tamanho) {
		this.fila = new ArrayList<Aresta>();
	}

	public boolean isEmpty() {
		return fila.isEmpty();
	}

	public Aresta removeArestaComPesoMinimo() {
		return fila.remove(0);
	}

	public void adicionar(Aresta aresta) {
		if (aresta.getPeso() == Double.POSITIVE_INFINITY) {
			return;
		}
		
		if (!temAresta(aresta)) {
			fila.add(aresta);
			
			Collections.sort(fila, new Comparator<Aresta>() {
				@Override
				public int compare(Aresta o1, Aresta o2) {
					return o1.getPeso().compareTo(o2.getPeso());
				}
			});
		}
	}

	@Override
	public String toString() {
		return "FilaDePrioridade [fila=" + fila + "]";
	}
	
	public boolean temAresta(Aresta outraAresta) {
		for (Aresta aresta : fila) {
			if (aresta.getOrigem() == outraAresta.getDestino() 
					&& outraAresta.getOrigem() == aresta.getDestino()) {
				return true;
			}
		}
		
		return false;
	}

}
