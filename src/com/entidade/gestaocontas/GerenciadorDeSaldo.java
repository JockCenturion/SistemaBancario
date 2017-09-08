package com.entidade.gestaocontas;

import java.text.NumberFormat;
import java.util.Locale;

public class GerenciadorDeSaldo {
	private double saldo;
	private Conta conta;
	private NumberFormat formatadorDeNumeros;
	
	
	public GerenciadorDeSaldo(Conta conta, double saldo, Locale localidade) {
		this.saldo = saldo;
		this.conta = conta;
		this.formatadorDeNumeros = NumberFormat.getInstance(localidade);
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void saca(double valor) {
		if (valor <= 0) { 
			throw new IllegalArgumentException("Valor Inválido.");
		} 
		
		saldo -= valor;
	}
	
	public void deposita(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor Inválido.");
		} 
		
		saldo += valor;
	}
	
	public void transferePara(Conta destino, double valor) {
		if (destino == null || conta == destino) {
			throw new IllegalArgumentException("Conta ou Operacao Inválida.");
		} 
	
		if (saldo - valor > 0) {
			this.saca(valor);
			destino.deposita(valor);
			this.saldo *= 0.97;
		} else {
			throw new IllegalArgumentException("Saldo Negativo ou não é possivel aplicar TAXA");
		}
	}
	
	public void geraRendimento() { //flexibilizar utilizando parametro
		this.saldo *= 1.005;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( !(obj instanceof GerenciadorDeSaldo) ) return false;
		if ( this == obj )							return true;
		
		return saldo == ((GerenciadorDeSaldo) obj).saldo;
	}
	
	@Override
	public String toString() {
		return formatadorDeNumeros.format(this.saldo);
	}
}
