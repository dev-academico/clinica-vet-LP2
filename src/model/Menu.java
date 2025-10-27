package model;
import java.lang.reflect.Array;
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

            // Lógica para ler a escolha do usuário e chamar os métodos apropriados
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
                default -> System.out.println("Opção inválida. Tente novamente.");
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
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1 -> {
                    System.out.println("Adicionando cliente...");
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
                    int especieEscolhida = scanner.nextInt();
                    Especie especieAnimal = switch (especieEscolhida) {
                        case 1 -> Especie.CACHORRO;
                        case 2 -> Especie.GATO;
                        case 3 -> Especie.COBRA;
                        case 4 -> Especie.PAPAGAIO;
                        case 5 -> Especie.TATU;
                        default -> throw new IllegalArgumentException("Espécie inválida");
                    };
                    System.out.println("Raça do animal:");
                    String racaAnimal = scanner.nextLine();

                    ArrayList<Animal> animais = new ArrayList<>();
                    
                    animais.add(new Animal(nomeAnimal, especieAnimal, racaAnimal, new Date(), cpf));

                    clinica.adicionarCliente(new Cliente(nome, cpf, endereco, telefone, animais));
                }
                case 2 -> {
                    clinica.listarClientes();
                }
                case 3 -> {
                    ArrayList<Cliente> clientes = clinica.getClientesDaClinica();
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println("[" + i + "] " + clientes.get(i).getNome());
                        clientes.get(i).exibirDados();
                    }
                    System.out.println("Escolha o cliente:");
                    int indice = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    Cliente cliente = clientes.get(indice);
                    System.out.println("Atualizando cliente...");
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Endereço do cliente: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Telefone do cliente: ");
                    String telefone = scanner.nextLine();

                    clinica.atualizarCliente(cliente, nome, endereco, telefone);
                }
                case 4 -> {
                    System.out.println("Deletando cliente...");
                    System.out.print("Cpf do cliente: ");
                    String cpf = scanner.nextLine();

                    clinica.removerCliente(cpf);
                }
                case 5 -> {
                    System.out.println("Voltando para o menu principal...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
