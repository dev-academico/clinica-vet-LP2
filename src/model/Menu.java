package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {

    public static void iniciarMenu(Clinica clinica) {
        while (true) {
            System.out.println("[Menu Principal]");
            System.out.println("[1] Gerenciar clientes");
            System.out.println("[2] Gerenciar animais do cliente");
            System.out.println("[3] Gerenciar veterinarios");
            System.out.println("[4] Gerenciar consultas");
            System.out.println("[5] Gerenciar produtos");
            System.out.println("[6] Sair");

            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> {
                    MenuClientes(clinica);
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> {
                }
                case 5 -> {
                }
                case 6 -> {
                    System.out.println("Saindo do sistema...");
                    return;
                }
                default ->
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void MenuClientes(Clinica clinica) {
        while (true) {
            System.out.println("[Menu Cliente]");
            System.out.println("[1 - C] Adicionar cliente");
            System.out.println("[2 - R] Listar clientes");
            System.out.println("[3 - U] Atualizar clientes");
            System.out.println("[4 - D] Deletar clientes");
            System.out.println("[5] Voltar para o menu principal");

            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1 -> {
                    System.out.println("Adicionando cliente...");
                    while (true) {
                        try {
                            System.out.print("Nome do cliente: ");
                            String nome = scanner.nextLine();

                            System.out.print("CPF do cliente: ");
                            String cpf = scanner.nextLine();

                            System.out.print("Endereço do cliente: ");
                            String endereco = scanner.nextLine();

                            System.out.print("Telefone do cliente: ");
                            String telefone = scanner.nextLine();

                            System.out.println("Nome do animal:");
                            String nomeAnimal = scanner.nextLine();

                            System.out.println("Escolha uma especie:");
                            System.out.println("[1] Cachorro");
                            System.out.println("[2] Gato");
                            System.out.println("[3] Cobra");
                            System.out.println("[4] Papagaio");
                            System.out.println("[5] Tatu");
                            int especieEscolhida = Integer.parseInt(scanner.nextLine());
                            Especie especieAnimal = switch (especieEscolhida) {
                                case 1 ->
                                    Especie.CACHORRO;
                                case 2 ->
                                    Especie.GATO;
                                case 3 ->
                                    Especie.COBRA;
                                case 4 ->
                                    Especie.PAPAGAIO;
                                case 5 ->
                                    Especie.TATU;
                                default ->
                                    throw new IllegalArgumentException("Espécie inválida");
                            };

                            System.out.println("Raça do animal:");
                            String racaAnimal = scanner.nextLine();

                            ArrayList<Animal> animais = new ArrayList<>();

                            animais.add(new Animal(nomeAnimal, especieAnimal, racaAnimal, new Date(), cpf));

                            clinica.adicionarCliente(new Cliente(nome, cpf, endereco, telefone, animais));
                            break; // Sai do loop se a adição for bem-sucedida
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Por favor, tente novamente.");
                        }
                    }

                }
                case 2 -> {
                    System.out.println("Listando clientes...");
                    clinica.listarClientes();
                }
                case 3 -> {
                    System.out.println("Atualizando cliente...");
                    while (true) {
                        try {
                            ArrayList<Cliente> clientes = clinica.getClientesDaClinica();
                            for (int i = 0; i < clientes.size(); i++) {
                                System.out.println("[" + (i + 1) + "] [" + clientes.get(i).getNome() + "]");
                                clientes.get(i).exibirDados();
                            }
                            System.out.println("Escolha o cliente ou digite '0' para cancelar:");
                            int indice = Integer.parseInt(scanner.nextLine());

                            if (indice == 0) {
                                System.out.println("Operação cancelada. Voltando ao menu de clientes...");
                                break;
                            }

                            Cliente cliente = clientes.get(indice - 1);

                            System.out.println("Atualizando cliente...");
                            System.out.print("Nome do cliente: ");
                            String nome = scanner.nextLine();

                            System.out.print("Endereço do cliente: ");
                            String endereco = scanner.nextLine();

                            System.out.print("Telefone do cliente: ");
                            String telefone = scanner.nextLine();

                            clinica.atualizarCliente(cliente, nome, endereco, telefone);
                            break;

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Por favor, tente novamente.");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Deletando cliente...");
                    while (true) {
                        try {
                            ArrayList<Cliente> clientes = clinica.getClientesDaClinica();
                            for (int i = 0; i < clientes.size(); i++) {
                                System.out.println("[" + (i + 1) + "] [" + clientes.get(i).getNome() + "]");
                                clientes.get(i).exibirDados();
                            }
                            System.out.println("Escolha o cliente ou digite '0' para cancelar:");
                            int indice = Integer.parseInt(scanner.nextLine());

                            if (indice == 0) {
                                System.out.println("Operação cancelada. Voltando ao menu de clientes...");
                                break;
                            }

                            Cliente cliente = clientes.get(indice - 1);
                            clinica.removerCliente(cliente.getCpf());
                            System.out.println("Cliente deletado com sucesso.");
                            break;

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Por favor, tente novamente.");
                        }
                    }

                }
                case 5 -> {
                    System.out.println("Voltando para o menu principal...");
                    return;
                }
                default ->
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
