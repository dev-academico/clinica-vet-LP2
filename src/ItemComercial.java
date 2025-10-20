import java.util.Map;
import java.util.Scanner;

abstract class ItemComercial {
    static private int contItem=0;

    private Integer id;
    private String nome;//talvez seja melhor final
    private String desc;
    private Map<Integer, Funcionario> responsaveisServ;

    ItemComercial(Integer id, String nome, String desc, Funcionario fnr){
        this.id=id;
        this.nome=nome;
        this.desc=desc;
        contItem++;
        this.responsaveisServ.put(this.id, fnr); //cada id é mapeado com o funcionário
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
        Map<Integer, Funcionario> itemC; // !!! Necessário um getter
        Scanner s=new Scanner(System.in);
        System.out.println("Informe o código do serviço");
        id=s.nextInt();
        /*
        A IMPLEMENTAR: ACESSO AO NOME DO FUNCIONARIO

        itemC.put(id, F.nome);
                System.out.println("Funcionário do responsável pelo serviço: "+ItemComercial.nome+" é" +
                F.nome);
        //implementar: controle para identificar se é produto ou não


         */
    }
    public boolean consumoItem(Cliente cl){
        /*
        CRIA UM RELATÓRIO A RESPEITO DO CONSUMO DO CLIENTE

        - parâmetros do 'cl': preço, data_hora, id do serviço/produto, nome do cliente, forma de pagamento

         */


        boolean cons=false;



        return cons;
    }
}
