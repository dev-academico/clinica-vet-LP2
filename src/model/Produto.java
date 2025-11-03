package model;

import exception.DadosObrigatoriosException;
import exception.DescontoInvalidoException;

public class Produto extends ItemComercial {

    private int estoque;

    Produto(int id, String nome, String desc, float preco, int estoque) {
        super(id, nome, desc, preco);
        this.estoque = estoque;
    }

    @Override
    public boolean aplicarDesconto(Double v) {
        try {
            DescontoInvalidoException.validaPercentual(v);
            float v_f = v.floatValue();
            float preco_novo = v_f * this.getPreco();

            System.out.print("Desconto aplicado: " + v_f * 100 + "% |\nPreço a pagar (não inclui taxas): " + preco_novo);
            System.out.println("\n");

            return true;
        } catch (DescontoInvalidoException e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

    public void atualizarDados(int id, String nome, String desc, float preco, int etq){
        if(id<=0 || preco<=0 || etq<=0) System.err.println("Informe preço, estoque e identificador válidos\n.");
        setPreco(preco);

        if(nome==null || desc==null) throw new DadosObrigatoriosException("Informe todos os dados necessários\n");
        this.setNome(nome);
        this.setDesc(desc);
        this.setEstoque(etq);
        this.setID(id);
        System.out.println("\nProduto: "+nome+" | Dados atualizados com sucesso!");
    }

    @Override
    public void imprimirDados() {
        System.out.println("[ Nome: " + this.getNome() + " | Preço: " + this.getPreco() + " | Estoque: " + this.getEstoque() + " |  Descrição: " + this.getDescricao() + " ]");
    }

    public boolean vender(Produto produto, Cliente cliente) {
        if (estoque > 0) {
            produto.estoque--;
            cliente.adicionarProduto(produto);
            return true;
        }
        return false;
    }

    public Integer getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


 
}
