package br.edu.fatecpg.banco.model;
public class Conta {
   private double numerodaconta;
   private String titular;
   private double saldo;
   
   public Conta(double numerodaconta, String titular, double saldo) {
       this.numerodaconta = numerodaconta;
       this.titular = titular;
       this.saldo = saldo;
   }
   public double getNumerodaconta() {
       return numerodaconta;
   }
   public void setNumerodaconta(double numerodaconta) {
       this.numerodaconta = numerodaconta;
   }
   public String getTitular() {
       return titular;
   }
   public void setTitular(String titular) {
       this.titular = titular;
   }
   public double getSaldo() {
       return saldo;
   }
   public void setSaldo(double saldo) {
       this.saldo = saldo;
   }
   public boolean sacar(double valor) {
       if (valor <= saldo) {
           saldo -= valor;
           System.out.println("Saque realizado com sucesso!");
           return true;
       } else {
           System.out.println("Saldo insuficiente para saque!");
           return false;
       }
   }
   public void depositar(double valor) {
       saldo += valor;
       System.out.println("Depósito realizado com sucesso!");
   }
   public boolean transferir(Conta destino, double valor) {
       if (this.sacar(valor)) {
           destino.depositar(valor);
           System.out.println("Transferência realizada com sucesso!");
           return true;
       } else {
           System.out.println("Transferência não realizada. Saldo insuficiente!");
           return false;
       }
   }
}
