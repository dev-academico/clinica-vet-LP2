package model;
import exception.DescontoInvalidoException;
import exception.ProdutoNaoEncontradoException;

import java.util.ArrayList;

public class Produto extends ItemComercial{

    private Float preco;
    private Integer estoque;
    //private ArrayList<Cliente> consumo_Pdt;
    private ArrayList<Produto> lista_prodDisponivel;

    Produto(Integer id, String nome, Funcionario fnr, String desc, Float p, Integer etq){
        super(id, nome, desc, fnr);
        this.preco=p;
        this.estoque=etq;
    }

    public void produtosEmLista(Produto p){
        this.lista_prodDisponivel.add(p);
    }

    @Override
    public boolean aplicarDesconto(Double v) {
        boolean apply=false;

             try{
                DescontoInvalidoException.validaPercentual(v);
                float v_f=v.floatValue(); //conversão
                float preco_novo=v_f*preco;

                System.out.print("Desconto aplicado: "+v_f*100+"% |\nPreço a pagar (não inclui taxas): "+preco_novo);
                System.out.println("\n");
                apply=true;
                return apply;
            }catch(DescontoInvalidoException e){
                System.out.println(e.getMessage());
                return apply;
            }
        }

    public Integer getEstoque(){
        return this.estoque;
    }

    public void setEstoque(Integer val){
        this.estoque=val;
    }

  
    public boolean vender(Produto p){
      try{
        ProdutoNaoEncontradoException.validaProdLista(p);

        //a impl.

        if(estoque<0 ){
            p.estoque--;
            return true;
        }
        }catch(ProdutoNaoEncontradoException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
   
}