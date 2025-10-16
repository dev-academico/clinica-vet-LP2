import java.io.InvalidClassException;

abstract class ItemComercial {
    static private int contItem=0;

     final private Integer id;
     final private String nome;
     private String desc;

    ItemComercial(Integer id, String nome, String desc){
        this.id=id;
        this.nome=nome;
        this.desc=desc;
        this.contItem+=1;
    }

    //uso de polim. aq ↓
    public static boolean aplicarDesconto(){
        boolean apply=false;

        return apply;
    }

}

//mover para uma pasta dedicada
class DescontoInvalidoE extends Exception{
    public DescontoInvalidoE(String msg){
        super(msg);
    }
    public static void validaPercentual(double p) throws DescontoInvalidoE{
        if(p<0){
            throw new DescontoInvalidoE("O percentual negativo é inválido\n.");
        }
        if(p>0.95){
            throw new DescontoInvalidoE("Valor de desconto está acima do limite máximo\n.");
        }
    }
}

