package Enums;

public enum Categoria {
    ALIMENTACAO("Gastos com alimentação, bebidas e restaurantes"),
    TRANSPORTE("Gastos com transporte público, combustível, e manutenção de veículos"),
    MORADIA("Gastos com aluguel, condomínio, água, luz e gás"),
    SAUDE("Gastos com consultas, medicamentos e exames"),
    EDUCACAO("Gastos com cursos, mensalidades, materiais escolares e livros"),
    LAZER("Gastos com atividades de lazer, viagens e entretenimento"),
    VESTUARIO("Gastos com roupas, calçados e acessórios"),
    SERVICOS("Gastos com serviços gerais como limpeza, manutenção e assinatura de serviços digitais"),
    SALARIO("Recebimentos relacionados a salário e trabalho"),
    INVESTIMENTOS("Entradas de dinheiro vindas de aplicações financeiras ou venda de ativos"),
    OUTROS("Gastos ou entradas que não se encaixam em outras categorias");

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
