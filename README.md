# SistemaBancario

Sistema de controle bancário.

Desenvolva um sistema desktop em Java que o funcionamento de um banco bem simples.

Tudo o que ele precisa fazer é representar diferentes tipos de contas bancárias e suas especificidades.

Todas as contas devem ter como atributos o número, agência, titular, data de abertura e saldo.

Em todas elas deve ser possível realizar saques, depósitos e transferências. 

Para saques e transferências o sistema deve impedir que seja retirado um valor da conta maior que o saldo disponível, a não ser em casos específicos que veremos a seguir.

Em depósitos deve-se garantir que o que está sendo depositado realmente é um número real. O mesmo vale para transferências e pedidos de saque, obviamente.

  Detalhes específicos:
  
    •Em uma conta corrente é possível que haja um limite especial para o usuário saca além da quantidade de saldo disponível.
    
    •Quando acontecer uma transferência de uma conta corrente para uma outra conta corrente ou poupança, deve ser descontado 
     do saldo restante um valor equivalente a 3% do valor transferido.
      
    •Em uma conta poupança deve haver uma taxa de rendimento de 0,5% e uma ação que possa ser invocada para aplicar 
     esse rendimento sobre o saldo em determinados períodos de tempo.
    
Todos os tipos de dados ficam a seu critério e sua escolha será também um ponto a ser avaliado.
Você não precisa se preocupar em criar interface gráfica e nem persistir os dados bancos de dados ou qualquer outra estratégia. Pode ser só o código com uma função main mesmo. Porém é obrigatório que o código rode e todos os métodos possam ser invocados de alguma maneira.

Se você quiser implementar a interface, persistência ou qualquer outro requisito não funcional que ache interessante, fique à vontade. Assim como para usar quaisquer frameworks e tecnologias que achar válidos.

Detalhe a mais: Leve em consideração que é possível que surjam novas modalidades de contas no futuro, que terão algo em comum com as modalidades já existentes e possivelmente algo específico. Tente deixar o código de pronto para receber essa evolução sem sofrer grandes traumas.

Ao final do trabalho, hospede o seu código em algum repositório aberto como github ou bitbucket e responda esse email com o endereço do código e instruções para execução.
Bom trabalho!
