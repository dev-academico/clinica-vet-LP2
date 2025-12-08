package model;

import Interfaces.IValidavel;
import exception.DadosObrigatoriosException;
import exception.DescontoInvalidoException;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public class Produto extends ItemComercial implements IValidavel {

    @Override
    public boolean validarCreate() {

        if(getNome() == null || getNome().trim().isEmpty()) {
            return false;
        }
        if(getDescricao() == null || getDescricao().trim().isEmpty()) {
            return false;
        }
        if(getPreco() <= 0) {
            return false;
        }
        if(estoque < 0) {
            return false;
        }

        return true;
    }

    private ArrayList<Cliente> listaDeClientes;
    private int estoque;

    public Produto(int id, String nome, String desc, float preco, int estoque) {
        super(id, nome, desc, preco);
        this.estoque = estoque;
        this.listaDeClientes = new ArrayList<>();

        if(!validarCreate()) {
            throw new DadosObrigatoriosException("Dados Obrigatorios! Todos os campos (nome, descrição, preço, e estoque) são obrigatórios");
        }
    }

    @Override
    public boolean aplicarDesconto(Double v) {
        try {
            DescontoInvalidoException.validaPercentual(v);
            float v_f = v.floatValue();
            float preco_novo = v_f * this.getPreco();

            System.out.print("Desconto aplicado: " + v_f * 100 + "% |\nPreço a pagar (não inclui taxas): " + preco_novo);
            System.out.println("\n");

            return true;
        } catch (DescontoInvalidoException e) {
            System.out.println(e.getMessage());

            return false;
        }
    }

    public void atualizarDados(String nome, String desc, float preco, int etq) {
        if (preco <= 0 || etq <= 0) {
            System.err.println("Informe preço, estoque e identificador válidos\n.");
        }
        setPreco(preco);

        if (nome == null || nome.trim().isEmpty() || desc.trim().isEmpty() || desc == null) {
            throw new DadosObrigatoriosException("Informe todos os dados necessários\n");
        }
        this.setNome(nome);
        this.setDesc(desc);
        this.setEstoque(etq);
        //System.out.println("\nProduto: "+nome+" | Dados atualizados com sucesso!");
    }

    @Override
    public void imprimirDados() {
        final String BLUE = "\u001B[34m";
        final String RESET = "\u001B[0m";
        System.out.println(BLUE + "[ Nome: " + this.getNome() + " | Preço: " + this.getPreco() + " | Estoque: " + this.getEstoque() + " |  Descrição: " + this.getDescricao() + " ]" + RESET);
    }

    public ArrayList<Cliente> getListaDeClientes() {
        return this.listaDeClientes;
    }

    public boolean vender(Produto produto, Cliente cliente) {
        if (estoque > 0) {
            produto.estoque--;
            this.listaDeClientes.add(cliente);
            cliente.adicionarProduto(produto);
            return true;
        }
        return false;
    }

    public Integer getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}
