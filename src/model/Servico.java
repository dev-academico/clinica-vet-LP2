package model;

import exception.DescontoInvalidoException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class Servico extends ItemComercial{

    private Float preco;
    private Map<Integer, Funcionario> responsaveisServ;
    //private ArrayList<Cliente> consumo_Srv; //clientes que consumiram serviço

    Servico(Integer id, String nome, Funcionario fnr, String desc, Float p){
        super(id, nome, desc, fnr);
        this.preco=p;
    }

    @Override
    public boolean aplicarDesconto(Double v){
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

    public void incluiFuncionario(Funcionario F){
        Scanner s=new Scanner(System.in);
        System.out.println("Informe o código do serviço");
        int id=s.nextInt();

        this.responsaveisServ.put(id, F);

        //controle para detectar se o id foi válido

        System.out.println("Funcionário do responsável pelo serviço: "+id+" é" +
                F.getNome());
    }

    //ovr
    public boolean agendar(Cliente cl, LocalDateTime data, itemComercial item){}

    public void realizarServico(Servico svc, Cliente cl, LocalDateTime data, itemComercial item){
        if(!svc.agendar(cl, data, item) || svc==null){
            System.err.println("Serviço indisponível.\n");
            return;
        }

        System.out.println("\n\nServiço a ser realizado: "+svc.getNome());
        System.out.println("\n\nProfissional: "+responsaveisServ.get(Funcionario));
        System.out.println("\n\nCliente em atendimento: "+cl.getNome());
    }

    /*
    public void registroConsumo(Cliente cl, LocalDateTime data, String pagForma){
        String nome=cl.getNome();
    }
     */
}