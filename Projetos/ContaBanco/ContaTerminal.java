import java.util.Scanner;

class Conta {
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public Conta(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, "
                + "sua agência é " + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.";
    }
}

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, digite o número da Agência:");
        String agencia = scanner.nextLine();

        System.out.println("Por favor, digite o número da Conta:");
        int numero = lerInteiroPositivo(scanner);

        System.out.println("Por favor, digite o nome do Cliente:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Por favor, digite o saldo inicial:");
        double saldo = lerDoublePositivo(scanner);

        Conta conta = new Conta(numero, agencia, nomeCliente, saldo);

        // Exibir mensagem de confirmação
        System.out.println();
        System.out.println(conta);

        // Operações bancárias (exemplo de uso)
        System.out.println("Deseja fazer um depósito? (sim/não)");
        if (scanner.nextLine().equalsIgnoreCase("sim")) {
            System.out.println("Digite o valor do depósito:");
            double valorDeposito = lerDoublePositivo(scanner);
            conta.depositar(valorDeposito);
        }

        System.out.println("Deseja fazer um saque? (sim/não)");
        if (scanner.nextLine().equalsIgnoreCase("sim")) {
            System.out.println("Digite o valor do saque:");
            double valorSaque = lerDoublePositivo(scanner);
            conta.sacar(valorSaque);
        }

        // Exibir informações atualizadas em forma de tabela
        System.out.println();
        System.out.println("+-------------------+----------------------+");
        System.out.println("| Campo             | Valor                |");
        System.out.println("+-------------------+----------------------+");
        System.out.printf("| %-17s | %-20s |\n", "Nome Cliente", conta.getNomeCliente());
        System.out.printf("| %-17s | %-20s |\n", "Agência", conta.getAgencia());
        System.out.printf("| %-17s | %-20d |\n", "Número da Conta", conta.getNumero());
        System.out.printf("| %-17s | %-20.2f |\n", "Saldo", conta.getSaldo());
        System.out.println("+-------------------+----------------------+");

        scanner.close();
    }

    private static int lerInteiroPositivo(Scanner scanner) {
        while (true) {
            try {
                int numero = Integer.parseInt(scanner.nextLine());
                if (numero > 0) {
                    return numero;
                } else {
                    System.out.println("Número da conta deve ser maior que zero. Por favor, digite novamente:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro válido:");
            }
        }
    }

    private static double lerDoublePositivo(Scanner scanner) {
        while (true) {
            try {
                double valor = Double.parseDouble(scanner.nextLine());
                if (valor >= 0) {
                    return valor;
                } else {
                    System.out.println("Saldo inicial não pode ser negativo. Por favor, digite novamente:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido:");
            }
        }
    }
}
