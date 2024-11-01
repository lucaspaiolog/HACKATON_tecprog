package br.edu.fatecpg.banco.model;
public class ContaCorrente extends Conta {
   private double limiteChequeEspecial = 500.0;
   public ContaCorrente(double numerodaconta, String titular, double saldo) {
       super(numerodaconta, titular, saldo);
   }
   @Override
   public boolean sacar(double valor) {
       if (valor <= getSaldo() + limiteChequeEspecial) {
           setSaldo(getSaldo() - valor);
           System.out.println("Saque realizado com cheque especial!");
           return true;
       } else {
           System.out.println("Saldo e limite insuficientes para saque!");
           return false;
       }
   }
}
