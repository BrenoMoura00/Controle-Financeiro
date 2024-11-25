package Entidades;

import Enums.Categoria;

import java.time.LocalDate;

public class Saidas extends TransacaoFinanceira {

    public Saidas(int id, double valor, LocalDate data, String descricao, Categoria categoria) {
        super(id, valor, data, descricao, categoria);
    }

    public Saidas() {
    }
}
