package Entidades;

import Enums.Categoria;

import java.time.LocalDate;

public abstract class TransacaoFinanceira {
    private int id;
    private double valor;
    private LocalDate data;
    private String descricao;
    private Categoria categoria;

    public TransacaoFinanceira(int id, double valor, LocalDate data, String descricao, Categoria categoria ) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;

    }

    public TransacaoFinanceira() {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transação{" +
                "id: " + id +
                ", valor: " + valor +
                ", data: " + data +
                ", descricao: " + descricao  +
                ", categorias: " + categoria +
                '}';
    }
}
