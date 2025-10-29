package model;
import exception.DescontoInvalidoException;
import exception.ProdutoNaoEncontradoException;

public class Produto extends ItemComercial{

    private int estoque;

    Produto(int id, String nome, String desc, float preco, int estoque){
        super(id, nome, desc, preco);
        this.estoque=estoque;
    }

    @Override
    public boolean aplicarDesconto(Double v) {
        try {
            DescontoInvalidoException.validaPercentual(v);
            float v_f=v.floatValue();
            float preco_novo=v_f*this.getPreco();

            System.out.print("Desconto aplicado: "+v_f*100+"% |\nPreço a pagar (não inclui taxas): "+preco_novo);
            System.out.println("\n");

            return true;
        } catch(DescontoInvalidoException e){
            System.out.println(e.getMessage());

            return false;
        }
    }

    @Override
    public void imprimirDados(){
        System.out.println("[ Nome: " + this.getNome() + " | " + this.getPreco() + " ]");
    }

    public boolean vender(Produto produto, Cliente cliente){
        if(estoque > 0 ) {
            produto.estoque--;
            cliente.adicionarProduto(produto);
            return true;
        }
        return false;
    }

    public Integer getEstoque(){
        return this.estoque;
    }

    public void setEstoque(int estoque){
        this.estoque = estoque;
    }

}