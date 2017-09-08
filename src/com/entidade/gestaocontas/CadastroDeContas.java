package com.entidade.gestaocontas;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;


public class CadastroDeContas {
	private Map<Integer, Conta> bancoDeContas;

	
	public CadastroDeContas() {
		this.bancoDeContas = new HashMap<>();
	}
	
	public void adicionaConta(Conta conta) {
		int codigoHash = conta.hashCode();
		
		if ( !(bancoDeContas.containsKey(codigoHash))) {
			this.bancoDeContas.put(codigoHash, conta);
		}
			
	}
	
	public Conta removeConta(String numero)  {
		Conta conta = this.bancoDeContas.remove(converteNumero(numero));
		
		if ( conta == null ) {
			throw new IllegalArgumentException("Conta Inexistente.");
		} else {
			return conta;
		}
	}
	
	public int quantidadeDeContas() {
		return this.bancoDeContas.size();
	}
	
	public void apagaTodasAsContas() {
		this.bancoDeContas.clear();
	}
	
	public Conta buscaConta(String numero)  {
		Conta conta = this.bancoDeContas.get(converteNumero(numero));
		
		if ( conta == null ) {
			throw new IllegalArgumentException("Conta Inexistente.");
		} else {
			return conta;
		}
	}
	
	public Collection<Conta> listaContas() {
		return this.bancoDeContas.values();	
	}

	private int converteNumero(String string) throws NumberFormatException {
		return Integer.parseInt(string.replace("-", ""));
	}
	

}
