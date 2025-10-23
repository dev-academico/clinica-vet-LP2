import java.util.Map;
import java.util.Scanner;

public class Servico extends ItemComercial{

    private String desc;
    private Float preco;
    private Map<Integer, Funcionario> responsaveisServ;

    Servico(Integer id, String nome, Funcionario fnr, String desc, Float p){
        super(id, nome, desc, fnr);
        this.desc=desc;
        this.preco=p;
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


    public void incluiFuncionario(Funcionario F){
        Scanner s=new Scanner(System.in);
        System.out.println("Informe o código do serviço");
        int id=s.nextInt();

        this.responsaveisServ.put(id, F);

        //controle para detectar se o id foi válido

        System.out.println("Funcionário do responsável pelo serviço: "+id+" é" +
                F.getNome());
    }


    /*
    + polimorfismo -> agendar()
    + realizarServico()

     */
}