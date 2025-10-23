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

    @Override
    public boolean aplicarDesconto(Double v) throws DescontoInvalidoE{
        boolean apply=false;

             try{
                DescontoInvalidoE.validaPercentual(v);
                float v_f=v.floatValue(); //conversão
                Float preco_novo=v_f*preco;

                System.out.print("Desconto aplicado: "+v_f*100+"% |\nPreço a pagar (não inclui taxas): "+preco_novo);
                System.out.println("\n");
                apply=true;
                return apply;
            }catch(DescontoInvalidoE e){
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

    /*
    public void vender(){
        if(estoque<0 ){
            //impl.
        }
    }

    ###########



    a impl
    + vender()
    + atualizarEstoque()

     */
}
