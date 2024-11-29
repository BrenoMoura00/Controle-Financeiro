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
            System.out.println("2 - Alterar Entrada");
            System.out.println("3 - Deletar Entrada");
            System.out.println("4 - Cadastrar Saída");
            System.out.println("5 - Alterar Saída");
            System.out.println("6 - Deletar Saída");
            System.out.println("7 - Ver Relatório");
            System.out.println("8 - Sair");
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
                        System.out.println(categoria.ordinal() + " - " + categoria.getDescricao());
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
                    System.out.print("Digite o ID da entrada a ser alterada: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Entradas entrada = repositorioEntrada.listar().stream()
                            .filter(e -> e.getId() == id)
                            .findFirst()
                            .orElse(null);

                    if (entrada == null) {
                        System.out.println("Entrada não encontrada!");
                    } else {
                        System.out.print("Digite o novo valor: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Digite a nova descrição: ");
                        String descricao = scanner.nextLine();

                        System.out.println("Selecione a nova categoria:");
                        for (Categoria categoria : Categoria.values()) {
                            System.out.println(categoria.ordinal() + " - " + categoria.getDescricao());
                        }
                        int categoriaIndex = scanner.nextInt();
                        scanner.nextLine();

                        Categoria categoria = Categoria.values()[categoriaIndex];
                        entrada.setValor(valor);
                        entrada.setDescricao(descricao);
                        entrada.setCategoria(categoria);

                        repositorioEntrada.alterar(entrada);
                        System.out.println("Entrada alterada com sucesso!");
                    }

                }
                case 3 -> {
                    System.out.print("Digite o ID da entrada a ser deletada: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Entradas entrada = repositorioEntrada.listar().stream()
                            .filter(e -> e.getId() == id)
                            .findFirst()
                            .orElse(null);

                    if (entrada == null) {
                        System.out.println("Entrada não encontrada!");
                    } else {
                        repositorioEntrada.deletar(id);
                        System.out.println("Entrada deletada com sucesso!");
                    }
                                    }
                case 4 -> {
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
                case 5 -> {
                    System.out.print("Digite o ID da saída a ser alterada: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Saidas saida = repositorioSaida.listar().stream()
                            .filter(s -> s.getId() == id)
                            .findFirst()
                            .orElse(null);

                    if (saida == null) {
                        System.out.println("Saída não encontrada!");
                    } else {
                        System.out.print("Digite o novo valor: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Digite a nova descrição: ");
                        String descricao = scanner.nextLine();

                        System.out.println("Selecione a nova categoria:");
                        for (Categoria categoria : Categoria.values()) {
                            System.out.println(categoria.ordinal() + " - " + categoria.getDescricao());
                        }
                        int categoriaIndex = scanner.nextInt();
                        scanner.nextLine();

                        Categoria categoria = Categoria.values()[categoriaIndex];
                        saida.setValor(valor);
                        saida.setDescricao(descricao);
                        saida.setCategoria(categoria);

                        repositorioSaida.alterar(saida);
                        System.out.println("Saída alterada com sucesso!");
                    }

                }
                case 6 -> {
                    System.out.print("Digite o ID da saída a ser deletada: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Saidas saida = repositorioSaida.listar().stream()
                            .filter(s -> s.getId() == id)
                            .findFirst()
                            .orElse(null);

                    if (saida == null) {
                        System.out.println("Saída não encontrada!");
                    } else {
                        repositorioSaida.deletar(id);
                        System.out.println("Saída deletada com sucesso!");
                    }

                }
                case 7 -> {
                    System.out.println("Relatório:");
                    System.out.println("--------------------");
                    System.out.println("Total de Entradas: " + servicoRelatorio.calcularTotalEntradas());
                    System.out.println("Total de Saídas: " + servicoRelatorio.calcularTotalSaidas());
                    System.out.println("Saldo Total: " + servicoRelatorio.calcularSaldoTotal());
                    System.out.println("--------------------");
                    System.out.println("Descrições das Entradas : " + servicoRelatorio.listarDescricoesEntradas());
                    System.out.println("Descrições dos Gastos : " + servicoRelatorio.listarDescricoesGastos());
                }
                case 8 -> {
                    System.out.println("Encerrando o programa...");
                    executando = false;

                }

                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
