package com.entidade.gestaocontas;

import java.util.Locale;

import com.entidade.data.Data;

public class ContaPoupanca implements Conta, ContaQueRende {
	private String numero, agencia, titular;
	private GerenciadorDeSaldo gerenciador;
	private Data dataDeAbertura, dataDoUltimoRendimento;

	
	public ContaPoupanca (String numero, String agencia, String titular, double saldo, Locale localidade) {
		this.numero   		= numero;
		this.agencia  		= agencia;
		this.titular  		= titular;
		this.gerenciador    = new GerenciadorDeSaldo(this, saldo, localidade);
		this.dataDeAbertura = dataDoUltimoRendimento = new Data();
	}
	
	public double getSaldo() {
		return gerenciador.getSaldo();
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void saca(double valor) {
		if (valor <= getSaldo()) {
			gerenciador.saca(valor);
		} else {
			throw new IllegalArgumentException("Saldo Insuficiente.");
		}
	}
	
	public void deposita(double valor) {
		gerenciador.deposita(valor);
	}
	
	public void transferePara(Conta destino, double valor) {
		gerenciador.transferePara(destino, valor);
	}
	
	public void rende(int tempDeRendimento) {
		Data dataAtual = new Data();
		if (dataDoUltimoRendimento.diferencaDeMinutos(dataAtual) >= tempDeRendimento) {
			gerenciador.geraRendimento();
			dataDoUltimoRendimento = dataAtual;
		}	
	}
	
	@Override
	public String toString() {
		return "Numero: " + this.numero + "\nAgencia: " + this.agencia + "\nTitular: " + this.titular + "\n" +
				"Data De Abertura: " + this.dataDeAbertura + "\nSaldo: " + this.gerenciador;
	}
	
	@Override
	public int hashCode() throws NumberFormatException {
		return Integer.parseInt(numero.replace("-", ""));
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( !(obj instanceof ContaPoupanca) ) return false;
		if ( this == obj )					   return true;
		
		ContaPoupanca cp = (ContaPoupanca) obj;
		
		return (agencia.equalsIgnoreCase(cp.agencia) && titular.equalsIgnoreCase(cp.titular) &&
				numero == cp.numero && gerenciador.equals(cp.gerenciador) && dataDeAbertura.equals(cp.dataDeAbertura));	
	}

}
