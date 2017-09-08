package com.entidade.gestaocontas;

public interface Conta {
	public double getSaldo();
	public void saca(double valor);
	public void deposita(double valor);
	public void transferePara(Conta destino, double valor);
}
