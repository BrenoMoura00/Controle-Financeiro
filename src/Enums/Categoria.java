package Enums;

public enum Categoria {
    ALIMENTACAO("Gastos com alimentação e bebidas"),
    TRANSPORTE("Gastos com transporte público, combustível, etc."),
    LAZER("Gastos com atividades de lazer e entretenimento"),
    SALARIO("Entradas de dinheiro relacionadas a salário"),
    INVESTIMENTOS("Entradas de dinheiro de investimentos"),
    SAUDE("Gastos com saúde, medicamentos, consultas"),
    EDUCACAO("Gastos com educação, cursos, livros");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return name() + " - " + descricao;
    }
}
