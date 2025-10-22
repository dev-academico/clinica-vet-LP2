package model;

import exception.DescontoInvalidoException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Hello, acabei fazendo boas práticas na suas classes - Nomeclatura e tals Ass. Pedro

public class ItemComercial {
    static private int contItens = 0;

    final private Integer id;
    final private String nome;
    private String descricao;
    private HashMap<Integer, Funcionario> responsaveisServico;

    ItemComercial( String nome, String descricao, Funcionario funcionario){ // Inicia com 1 funcionário
        HashMap<Integer, Funcionario> responsavelServico = new HashMap<Integer, Funcionario>();
        responsavelServico.put(contItens++,funcionario);

        this.id=contItens++; // Id incremental - Acho mais fácil assim - Ass.Pedro

        this.nome=nome;
        this.descricao=descricao;
        this.responsaveisServico=responsavelServico;
    }

    public boolean aplicarDesconto(Double v) throws DescontoInvalidoException {
        try{
            DescontoInvalidoException.validaPercentual(v);
            /*
            IMPLEMENTAR : logica do produto/serv. a ser descontado nas classes
             */
            return true;
        } catch ( DescontoInvalidoException e ){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void incluiFuncionario(Funcionario funcionario){
        Map<Integer, Veterinario> novoFuncionario;
        System.out.println("Funcionário do responsável pelo serviço: " + this.nome + " é" + funcionario.getNome());

        Scanner scanner =new Scanner(System.in);
        System.out.println("Informe o código do serviço: ");
        int idTyped = scanner.nextInt();
        /*
        A IMPLEMENTAR: ACESSO AO NOME DO FUNCIONARIO

        novoFuncionario.put(idTyped, funcionario.getNome());
        System.out.println("Funcionário do responsável pelo serviço: "+ this.nome +" é " + funcionario.getNome());

        implementar: controle para identificar se é produto ou não

        Obs.: Não seria depois responsaveisServico.put(novoFuncionario)? - Ass. Pedro
         */
    }

    public boolean consumoItem(){

        /*
        CRIA UM RELATÓRIO A RESPEITO DO CONSUMO DO CLIENTE

        parâmetros do 'cl': preço, data_hora, id do serviço/produto, nome do cliente, forma de pagamento
         */

        return true;
    }
}