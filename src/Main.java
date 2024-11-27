import Entidades.Entradas;
import Entidades.Saidas;
import Enums.Categoria;
import Repositorios.impl.RepositorioEntradas;
import Repositorios.impl.RepositorioSaidas;
import Servicos.impl.ServicoRelatorio;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RepositorioEntradas repositorioEntrada = new RepositorioEntradas();
        RepositorioSaidas repositorioSaida = new RepositorioSaidas();

        ServicoRelatorio servicoRelatorio = new ServicoRelatorio(repositorioEntrada, repositorioSaida);

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Entrada");
            System.out.println("2 - Cadastrar Saída");
            System.out.println("3 - Ver Relatório");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o valor da entrada: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a descrição da entrada: ");
                    String descricao = scanner.nextLine();

                    System.out.println("Selecione a categoria da entrada:");
                    for (Categoria categoria : Categoria.values()) {
                        System.out.println(categoria.ordinal() + " " + categoria.name() + " - " + categoria.getDescricao());
                    }
                    int categoriaIndex = scanner.nextInt();
                    scanner.nextLine();

                    Categoria categoria = Categoria.values()[categoriaIndex];
                    repositorioEntrada.salvar(new Entradas(
                            repositorioEntrada.listar().size() + 1,
                            valor,
                            LocalDate.now(),
                            descricao,
                            categoria
                    ));
                    System.out.println("Entrada cadastrada com sucesso!");
                }
                case 2 -> {
                    System.out.print("Digite o valor da saída: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a descrição da saída: ");
                    String descricao = scanner.nextLine();

                    System.out.println("Selecione a categoria da saída:");
                    for (Categoria categoria : Categoria.values()) {
                        System.out.println(categoria.ordinal() + " - " + categoria.getDescricao());
                    }
                    int categoriaIndex = scanner.nextInt();
                    scanner.nextLine();

                    Categoria categoria = Categoria.values()[categoriaIndex];
                    repositorioSaida.salvar(new Saidas(
                            repositorioSaida.listar().size() + 1,
                            valor,
                            LocalDate.now(),
                            descricao,
                            categoria
                    ));
                    System.out.println("Saída cadastrada com sucesso!");
                }
                case 3 -> {
                    System.out.println("Relatório:");
                    System.out.println("Total de Entradas: " + servicoRelatorio.calcularTotalEntradas());
                    System.out.println("Total de Saídas: " + servicoRelatorio.calcularTotalSaidas());
                    System.out.println("Saldo Total: " + servicoRelatorio.calcularSaldoTotal());
                    System.out.println("Descrições dos Gastos: " + servicoRelatorio.listarDescricoesGastos());
                }
                case 4 -> {
                    System.out.println("Encerrando o programa...");
                    executando = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
