package model;

import exception.DadosObrigatoriosException;

public class Pessoa {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Pessoa(String nome, String cpf, String endereco, String telefone) throws DadosObrigatoriosException {
        //validação
        if (nome == null || nome.trim().isEmpty() ||
                cpf == null || cpf.trim().isEmpty() ||
                endereco == null || endereco.trim().isEmpty() ||
                telefone == null || telefone.trim().isEmpty()) {

            //lança a exceção se algum dado obrigatório estiver faltando
            throw new DadosObrigatoriosException("Todos os campos (nome, cpf, endereco, telefone) são obrigatórios.");
        }

        //se a validação passar, o código continua
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    //se for null, continua o mesmo, não precisa lançar exceção
    public void atualizarDados(String nome, String cpf, String endereco, String telefone) {
        if(nome!=null){
            this.nome = nome;
        }
        if(endereco!=null){
            this.endereco = endereco;
        }
        if(telefone!=null){
            this.telefone = telefone;
        }
        if(cpf == null){
            throw new DadosObrigatoriosException("Uma pessoa deve ter obrigatoriamente um CPF");
        }
        this.cpf = cpf;
    }

    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Endereco: " + this.endereco);
        System.out.println("Telefone: " + this.telefone);
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }
}