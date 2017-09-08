package com.entidade.gestaocontas;

import java.util.Collection;

public class GeradorDeRendimentos {
	private Collection<Conta> contas;

	public GeradorDeRendimentos(Collection<Conta> contas) {
		this.contas = contas;
	}
	
	public void geraRendimentos(int tempDeRendimento) {
		for (Conta conta : contas) {
			if ( conta instanceof ContaQueRende ) {
				( (ContaQueRende) conta ).rende(tempDeRendimento);
			}
		}
	}
}
