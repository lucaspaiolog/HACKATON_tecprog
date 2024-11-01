package br.edu.fatecpg.banco.view;
import javax.swing.*;
import java.awt.*;
import br.edu.fatecpg.banco.model.Conta;
import br.edu.fatecpg.banco.model.ContaCorrente;
import br.edu.fatecpg.banco.model.ContaPoupança;
public class Main extends JFrame {
   private static final long serialVersionUID = 1L;
private Conta contaCorrente = new ContaCorrente(1234, "João", 1000.0);
   private Conta contaPoupanca = new ContaPoupança(5678, "Maria", 2000.0);
   private JTextField valorField = new JTextField(10);
   private JLabel saldoLabel = new JLabel("Selecione uma conta para ver o saldo.");
   private JComboBox<String> contaTipoBox = new JComboBox<>(new String[] { "Conta Corrente", "Conta Poupança" });
   public Main() {
       setTitle("Sistema Bancário");
       setSize(300, 200);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       JButton saqueButton = new JButton("Sacar");
       JButton depositoButton = new JButton("Depositar");
       JButton transferirButton = new JButton("Transferir");
       saqueButton.addActionListener(e -> {
           double valor = Double.parseDouble(valorField.getText());
           getContaSelecionada().sacar(valor);
           atualizarSaldo();
       });
       depositoButton.addActionListener(e -> {
           double valor = Double.parseDouble(valorField.getText());
           getContaSelecionada().depositar(valor);
           atualizarSaldo();
       });
       transferirButton.addActionListener(e -> {
           double valor = Double.parseDouble(valorField.getText());
           Conta contaDestino = getContaSelecionada() == contaCorrente ? contaPoupanca : contaCorrente;
           getContaSelecionada().transferir(contaDestino, valor);
           atualizarSaldo();
       });
       JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
       panel.add(contaTipoBox);
       panel.add(saldoLabel);
       panel.add(valorField);
       panel.add(saqueButton);
       panel.add(depositoButton);
       panel.add(transferirButton);
       add(panel);
       atualizarSaldo();
   }
   private Conta getContaSelecionada() {
       return contaTipoBox.getSelectedItem().equals("Conta Corrente") ? contaCorrente : contaPoupanca;
   }
   private void atualizarSaldo() {
       Conta contaSelecionada = getContaSelecionada();
       saldoLabel.setText("Saldo: R$ " + contaSelecionada.getSaldo());
   }
   public static void main(String[] args) {
       SwingUtilities.invokeLater(() -> new Main().setVisible(true));
   }
}
