public class Produto extends ItemComercial{

    private String desc;
    private Float preco;
    private Integer estoque;


    Produto(Integer id, String nome, Funcionario fnr, String desc, Float p, Integer etq){
        super(id, nome, desc, fnr);
        //this.desc=desc;
        this.preco=p;
        this.estoque=etq;
    }

    public void vender(){
        if(estoque<0){
            //impl.
        }
    }

    /*
    a impl
    + vender()
    + atualizarEstoque()

     */
}
