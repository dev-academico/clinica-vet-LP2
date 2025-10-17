import java.util.HashMap;
import java.util.function.Function;

abstract class ItemComercial {
    static private int contItem=0;

    final private Integer id;
    final private String nome;
    private String desc;
    private HashMap<Integer, Funcionario> responsaveisServ;

    ItemComercial(Integer id, String nome, String desc, Funcionario fnr){
        this.id=id;
        this.nome=nome;
        this.desc=desc;
        this.contItem+=1;
        this.responsaveisServ=responsaveisServ<id, fnr>;
    }

    //uso de polim. aq ↓
    public boolean aplicarDesconto(Double v) throws DescontoInvalidoE{
        boolean apply=false;

           try{
               DescontoInvalidoE.validaPercentual(v);
               //impl logica do produto/serv. a ser descontado nas classes
               apply=true;
               return apply;
           }catch(DescontoInvalidoE e){
               System.out.println(e.getMessage());
               return apply;
           }
    }

    //Identifica um serviço e um responsável
    public void incluiFuncionario(Funcionario F){
        HashMap itemC= new HashMap<this.id,F.nome>(); //Necessário um getter
        System.out.println("Funcionário do responsável pelo serviço: "+ItemComercial.nome+" é" +
                 F.nome);
        //implementar: controle para identificar se é produto ou não
    }
    public boolean consumoItem(){
      //mostra se um cliente consumiu um prod. ou serviço
        boolean cons=false;

        return cons;
    }
}

//mover para uma pasta dedicada

