import exception.DadosObrigatoriosException;
import java.util.ArrayList;
import model.Animal;
import model.Cargo;
import model.Cliente;
import model.Clinica;
import model.Funcionario;
import model.Veterinario;

public class Main {
    public static void main(String[] args) {
        Clinica clinica = new Clinica();

        //CRUD veterinário
        try{
            Veterinario veterinario1 = new Veterinario("Raquel Garcia", "111.111.111-11", "parco della veritá", "84 98860-6745", 100000, "1010101");
            Veterinario veterinario2 = new Veterinario(null, "000.000.000-00", "parco della veritá", "84 98860-6745", 100000, "1010102");

            //create veterinário
            clinica.adicionarVeterinário(veterinario1);
            clinica.adicionarVeterinário(veterinario2);

            System.out.println();

            //remover veterinário
            clinica.removerVeterinário(veterinario2);

            System.out.println();

            // read
            clinica.lerVeterinário("1010101");

            System.out.println();

            // update veterinário
            clinica.atualizarVeterinário(null, null, null, 300000, "1010101");

            System.out.println();

            // read
            clinica.lerVeterinário("1010101");

            System.out.println();
        }catch(DadosObrigatoriosException e){
            System.out.println(e);
        }

        //CRUD funcionário
        Funcionario funcionario1 = new Funcionario("Raquel Garcia", "111.111.111-11", "parco della veritá", "84 98860-6745", 100000, "2020202", Cargo.AUXILIAR_TOSADOR);
        Funcionario funcionario2 = new Funcionario("Raquel Garcia", "000.000.000-00", "parco della veritá", "84 98860-6745", 100000, "2020203", Cargo.TOSADOR);

        //create funcionario
        clinica.adicionarFuncionario(funcionario1);
        clinica.adicionarFuncionario(funcionario2);

        System.out.println();

        //remover funcionario
        clinica.removerFuncionario(funcionario2);

        System.out.println();

        // read
        clinica.lerFuncionario("2020202");

        System.out.println();

        // update
        clinica.atualizarFuncionario(null, null, null, 300000, "2020202", Cargo.TOSADOR);

        System.out.println();

        // read
        clinica.lerFuncionario("2020202");

        System.out.println();

        Animal animal1 = new Animal("Rex", model.Especie.CACHORRO, "Labrador", new java.util.Date(), 30.0f, "Nenhuma observação");

        ArrayList<Animal> animaisDoCliente1 = new ArrayList<>();
        animaisDoCliente1.add(animal1);

        Cliente clienteA = new Cliente("Pedro Varela", "123.456.789-00", "Rua A, 123", "84 99999-9999", animaisDoCliente1);
        clinica.adicionarCliente(clienteA);

        // listar clientes
        clinica.listarClientes();

        Cliente clienteB = clinica.lerCliente("123.456.789-00");

        Animal animal2 = new Animal("Miau", model.Especie.GATO, "Siamês", new java.util.Date(), 10.0f, "Nenhuma observação");
        Animal animal3 = new Animal("Bolt", model.Especie.CACHORRO, "Vira-lata", new java.util.Date(), 20.0f, "Nenhuma observação");

        clienteB.adicionarAnimal(animal2);

        clienteB.adicionarAnimal(animal3);
        
        clienteB.atualizarAnimal(1, "Rexauro", model.Especie.CACHORRO, "Caramelo", new java.util.Date());

        clinica.atualizarCliente(clienteB.getNome(), clienteB.getEndereco(), clienteB.getTelefone(), clienteB.getAnimais(), clienteB.getCpf());
        clinica.listarClientes();
    }
}