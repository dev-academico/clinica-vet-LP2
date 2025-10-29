package model;

abstract class ItemComercial {

    static private int contItem = 0;

    private int id;
    private String nome;
    private String descricao;
    private float preco;

    ItemComercial(int id, String nome, String desc, float preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = desc;
        this.preco = preco;
        contItem++;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getPrecoFormatado() {
        return String.format("%.2f", this.preco);
    }

    public float getPreco() {
        return this.preco;
    }

    public abstract boolean aplicarDesconto(Double v);

    public abstract void imprimirDados();
}
