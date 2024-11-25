package Entidades;

import Enums.Categoria;

import java.time.LocalDate;

public class Entradas extends TransacaoFinanceira{

    public Entradas(int id, double valor, LocalDate data, String descricao, Categoria categoria) {
        super(id, valor, data, descricao, categoria);
    }

    public Entradas() {
    }
}
