import model.Cargo;
import model.Clinica;
import model.Funcionario;
import model.Veterinario;

public class Main {
    public static void main(String[] args) {
        Clinica clinica = new Clinica();

        //CRUD veterinário
        Veterinario veterinario1 = new Veterinario("Raquel Garcia", "111.111.111-11", "parco della veritá", "84 98860-6745", 100000, "1010101");
        Veterinario veterinario2 = new Veterinario("Raquel Garcia", "000.000.000-00", "parco della veritá", "84 98860-6745", 100000, "1010102");

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
        clinica.atualizarVeterinário(null, "111.111.111-11", null, null, 300000, "1010101");

        System.out.println();

        // read
        clinica.lerVeterinário("1010101");

        System.out.println();

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
        clinica.atualizarFuncionario(null, "111.111.111-11", null, null, 300000, "2020202", Cargo.TOSADOR);

        System.out.println();

        // read
        clinica.lerFuncionario("2020202");

        System.out.println();
    }
}