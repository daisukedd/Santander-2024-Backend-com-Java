import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar e ler o número da agência
        System.out.println("Por favor, digite o número da Agência:");
        String agencia = scanner.nextLine();

        // Solicitar e ler o número da conta
        System.out.println("Por favor, digite o número da Conta:");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

        // Solicitar e ler o nome do cliente
        System.out.println("Por favor, digite o nome do Cliente:");
        String nomeCliente = scanner.nextLine();

        // Solicitar e ler o saldo
        System.out.println("Por favor, digite o saldo inicial:");
        double saldo = scanner.nextDouble();

        // Exibir mensagem de confirmação
        System.out.println();
        String mensagem = "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, "
                        + "sua agência é " + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.";
        System.out.println(mensagem);

        // Exibir informações em forma de tabela
        System.out.println();
        System.out.println("+-------------------+----------------------+");
        System.out.println("| Campo             | Valor                |");
        System.out.println("+-------------------+----------------------+");
        System.out.printf("| %-17s | %-20s |\n", "Nome Cliente", nomeCliente);
        System.out.printf("| %-17s | %-20s |\n", "Agência", agencia);
        System.out.printf("| %-17s | %-20d |\n", "Número da Conta", numero);
        System.out.printf("| %-17s | %-20.2f |\n", "Saldo", saldo);
        System.out.println("+-------------------+----------------------+");

        scanner.close();
    }
}
