package com.entidade.gestaocontas;

import java.util.Locale;

import com.entidade.data.Data;

public class ContaCorrente implements Conta {
	private static double limiteEspecial = 500;
	private String numero, agencia, titular;
	private GerenciadorDeSaldo gerenciador;
	private Data dataDeAbertura;
	
	
	public ContaCorrente (String numero, String agencia, String titular, double saldo, Locale localidade) {
		this.numero         = numero;
		this.agencia        = agencia;
		this.titular        = titular;
		this.gerenciador    = new GerenciadorDeSaldo(this, saldo, localidade);
		this.dataDeAbertura = new Data();
	}
	
	
	public double getSaldo() {
		return gerenciador.getSaldo();
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void saca(double valor) {
		if (valor <= limiteEspecial + getSaldo()) {
			gerenciador.saca(valor);
		} else {
			throw new IllegalArgumentException("Sem Crédito Especial.");
		}		
	}
	
	public void deposita(double valor) {
		gerenciador.deposita(valor);
	}
	
	public void transferePara(Conta destino, double valor) {
		gerenciador.transferePara(destino, valor);
	}
	
	public static void setLimiteEspecial(double limiteEspecial) {
		ContaCorrente.limiteEspecial = limiteEspecial;
	}
	
	@Override
	public String toString() {
		return "Numero: " + this.numero + "\nAgencia: " + this.agencia + "\nTitular: " + this.titular + "\n" +
				"Data De Abertura: " + this.dataDeAbertura + "\nSaldo: " + this.gerenciador + 
				"\nLimite Especial: " + limiteEspecial;
	}
	
	@Override
	public int hashCode() throws NumberFormatException {
		return Integer.parseInt(numero.replace("-", ""));
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( !(obj instanceof ContaPoupanca) ) return false;
		if ( this == obj )					   return true;
		
		ContaCorrente cc = (ContaCorrente) obj;
		
		return (agencia.equalsIgnoreCase(cc.agencia) && titular.equalsIgnoreCase(cc.titular) &&
				numero == cc.numero && gerenciador.equals(cc.gerenciador) && dataDeAbertura.equals(cc.dataDeAbertura));	
		
	}

}
