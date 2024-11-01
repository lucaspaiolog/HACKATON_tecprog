package br.edu.fatecpg.banco.model;
public class ContaPoupança extends Conta {
   public ContaPoupança(double numerodaconta, String titular, double saldo) {
       super(numerodaconta, titular, saldo);
   }
   @Override
   public boolean sacar(double valor) {
       System.out.println("Saque não permitido em conta poupança!");
       return false;
   }
}
