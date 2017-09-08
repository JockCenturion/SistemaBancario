/*
 * Autor: Jock
 * Data: 06.09.2017
 * Sistema: Mini Sistema Bancário
 * 
 */


package com.entidade.terminal;

import java.util.Locale;
import java.util.Scanner;

import com.entidade.gestaocontas.CadastroDeContas;
import com.entidade.gestaocontas.Conta;
import com.entidade.gestaocontas.ContaCorrente;
import com.entidade.gestaocontas.ContaPoupanca;
import com.entidade.gestaocontas.GeradorDeRendimentos;

public class Terminal {
	static CadastroDeContas cadastroDeContas = new CadastroDeContas();

	public static void main(String[] args) {
		int resp;
		
		do {
			menu();
			geraRendimentos(); 		
			
			resp = getInt("Selecione uma Opcao: ");
			
			switch(resp) {
				case 1: op01(); break;
				case 2: op02(); break;
				case 3: op03(); break;
				case 4: op04(); break;
				case 5: op05(); break;
				case 6: op06(); break;
				case 7: System.out.println("Saindo...\n"); break;
				default: System.out.println("Opçao Inválida.\n"); break;
			}
		} while(resp != 7);
	}
	
	public static void menu() {
		System.out.println("\tMenu\n\n" + 
						   "\t1) Criar Conta\n" +
						   "\t2) Remover Conta\n" +
						   "\t3) Busca Conta\n" +
						   "\t4) Quantidade de Contas\n" +
						   "\t5) Apagar Todas as Contas\n"  +
						   "\t6) Operaçoes de uma Conta\n"  +
						   "\t7) Sair");
	}
	
	public static void geraRendimentos() {
		GeradorDeRendimentos gdr = new GeradorDeRendimentos(cadastroDeContas.listaContas());
		gdr.geraRendimentos(1);
	}
	
	public static void op01() {
		System.out.println("\tTipo da Conta\n\n\t1)Conta Corrente\n\t2)Conta Poupanca\n");
		int resp = getInt("Selecione o tipo da Conta: ");
		
		try {
			String numero  = getString("Numero (xxxxx-x): ");
			String agencia = getString("Agencia (xxxxx-x): ");
			String titular = getString("Titular: ");
			double saldo   = getDouble("Saldo: ");
			
			if (resp == 1) {
				cadastroDeContas.adicionaConta(new ContaCorrente(numero, agencia, titular, saldo, new Locale("pt", "BR")));
			} else if (resp == 2){
				cadastroDeContas.adicionaConta(new ContaPoupanca(numero, agencia, titular, saldo, new Locale("pt", "BR")));
			}
		} catch (NumberFormatException e) {
			System.out.println("Inválido." + e);
		}
	}
	
	public static void op02() {
		try {
			System.out.println(cadastroDeContas.removeConta(getString("Numero da Conta: ")));
		} catch (NumberFormatException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	public static void op03() {
		try {
			System.out.println(cadastroDeContas.buscaConta(getString("Numero da Minha Conta: ")));
		} catch (NumberFormatException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	
	public static void op04() {
		int quantidadeContas = cadastroDeContas.quantidadeDeContas();
		System.out.println("O sistema Possui " + ( quantidadeContas == 0 ? "Nenhuma" : quantidadeContas) 
						   + " conta(s)");
	}
	
	public static void op05() {
		System.out.println("Todas as contas apagadas do sistema\n");
		cadastroDeContas.apagaTodasAsContas();
	}
	
	public static void op06() {
		System.out.println("\tMenu De Operaçoes\n\n" + 
				   "\t1) Sacar\n" +
				   "\t2) Depositar\n" + 
				   "\t3) Transferir\n" +
				   "\t4) Visualizar Saldo");
		
		try {
			int resp = getInt("Selecione uma Opcao: ");
			Conta conta = cadastroDeContas.buscaConta(getString("Numero da Minha Conta: "));
	
			if (resp == 1) {
				double valor = getDouble("Valor a Sacar");
				conta.saca(valor);
			} else if (resp == 2) {
				double valor = getDouble("Valor a Depositar");
				conta.deposita(valor);
			} else if (resp == 3){
				double valor = getDouble("Valor a Transferir");
				Conta destino = cadastroDeContas.buscaConta(getString("Numero da Conta Destino: "));
				conta.transferePara(destino, valor);
			} else {
				System.out.println("Seu saldo é: R$" + conta.getSaldo());
			}
		} catch (NumberFormatException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
			
	}

	/*Criar uma classe para reaproveitar metodos (Flexibilizar - Responsabilidade que não é dela )*/
	private static String getString(String string) {
		Scanner input = new Scanner(System.in);
		System.out.println(string);
		
		while (input.hasNext()) {
			return input.nextLine();
		}
	
		System.out.println("Erro na Leitura de Dados.)");
		return null;
		
	}
	
	private static double getDouble(String string) {
		Scanner input = new Scanner(System.in);
		System.out.println(string);
		
		if (input.hasNextDouble()) {
			return input.nextDouble();
		}
		
		System.out.println("Erro na Leitura de Dados.");
		return 0;
	}
	
	private static int getInt(String string) {
		Scanner input = new Scanner(System.in);
		System.out.println(string);
		
		if (input.hasNextInt()) {
			return input.nextInt();
		}
		
		System.out.println("Erro na Leitura de Dados.");
		return 0;
	}
}
