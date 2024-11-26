import Entidades.Entradas;
import Entidades.Saidas;
import Enums.Categoria;
import Repositorios.impl.RepositorioEntradas;
import Repositorios.impl.RepositorioSaidas;
import Servicos.impl.ServicoRelatorio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        RepositorioEntradas repositorioEntrada = new RepositorioEntradas();
        RepositorioSaidas repositorioSaida = new RepositorioSaidas();

        ServicoRelatorio serviceRelatorio = new ServicoRelatorio(repositorioEntrada, repositorioSaida);

        repositorioEntrada.salvar(new Entradas(1,200, LocalDate.now(),"freelance", Categoria.SALARIO));
        repositorioEntrada.salvar(new Entradas(2,300, LocalDate.now(),"freelance", Categoria.SALARIO));
        repositorioSaida.salvar(new Saidas(1, 500, LocalDate.now(), "lazer", Categoria.LAZER));
        repositorioSaida.salvar(new Saidas(2, 100, LocalDate.now(), "Mercado", Categoria.ALIMENTACAO));


        System.out.println("Total de Entradas: " + serviceRelatorio.calcularTotalEntradas());
        System.out.println("Total de Saídas: " + serviceRelatorio.calcularTotalSaidas());
        System.out.println("Saldo Total: " + serviceRelatorio.calcularSaldoTotal());
        System.out.println("Descrições dos Gastos: " + serviceRelatorio.listarDescricoesGastos());
    }
}