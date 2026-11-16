
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        String[] livros = {
                "Java: Como Programar",
                "Logica de Programacao",
                "Estrutura de Dados"
        };

        String[] emprestimos = new String[3];

        int quantidadeEmprestimos = 0;
        int opcao;
        int escolha;
        int diasAtraso;

        int prazoDevolucao = 14;
        double multaPorDia = 2.00;
        double valorMulta;

        String nomeMembro;

        System.out.println("======================================");
        System.out.println("   SISTEMA DE GESTAO DE BIBLIOTECA");
        System.out.println("======================================");

        System.out.print("Digite o nome do membro: ");
        nomeMembro = entrada.nextLine();

        do {

            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1 - Consultar livros");
            System.out.println("2 - Realizar emprestimo");
            System.out.println("3 - Verificar emprestimos e prazos");
            System.out.println("4 - Calcular multa por atraso");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:

                    System.out.println("\n========== LIVROS DO ACERVO ==========");

                    for (int i = 0; i < livros.length; i++) {
                        System.out.println((i + 1) + " - " + livros[i]);
                    }

                    break;

                case 2:

                    if (quantidadeEmprestimos < 3) {

                        System.out.println("\nEscolha um livro:");

                        for (int i = 0; i < livros.length; i++) {
                            System.out.println((i + 1) + " - " + livros[i]);
                        }

                        System.out.print("Digite o numero do livro: ");
                        escolha = entrada.nextInt();

                        if (escolha >= 1 && escolha <= livros.length) {

                            emprestimos[quantidadeEmprestimos] = livros[escolha - 1];

                            quantidadeEmprestimos++;

                            System.out.println("\nEmprestimo registrado com sucesso!");
                            System.out.println("Membro: " + nomeMembro);
                            System.out.println("Livro: " + livros[escolha - 1]);
                            System.out.println("Prazo de devolucao: " + prazoDevolucao + " dias");

                        } else {

                            System.out.println("Livro nao encontrado.");

                        }

                    } else {

                        System.out.println("Limite de 3 emprestimos atingido!");

                    }

                    break;

                case 3:

                    System.out.println("\n========== EMPRESTIMOS ATIVOS ==========");

                    if (quantidadeEmprestimos == 0) {

                        System.out.println("Nenhum emprestimo registrado.");

                    } else {

                        for (int i = 0; i < quantidadeEmprestimos; i++) {

                            System.out.println((i + 1) + " - " + emprestimos[i]);
                            System.out.println("Prazo: " + prazoDevolucao + " dias");

                        }

                    }

                    break;

                case 4:

                    System.out.print("\nInforme os dias de atraso: ");
                    diasAtraso = entrada.nextInt();

                    if (diasAtraso > 0) {

                        valorMulta = diasAtraso * multaPorDia;

                        System.out.println("Dias de atraso: " + diasAtraso);
                        System.out.printf("Multa total: R$ %.2f%n", valorMulta);

                    } else if (diasAtraso == 0) {

                        System.out.println("Devolucao dentro do prazo. Sem multa.");

                    } else {

                        System.out.println("Quantidade de dias invalida.");

                    }

                    break;

                case 5:

                    System.out.println("\nSistema encerrado.");
                    break;

                default:

                    System.out.println("Opcao invalida! Tente novamente.");

            }

        } while (opcao != 5);

        entrada.close();

    }
}
