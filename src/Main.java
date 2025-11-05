
import java.util.ArrayList;
import model.Clinica;
import model.Menu;
import model.Animal;
import model.Cliente;
import model.Funcionario;
import model.Cargo;
import model.Especie;

public class Main {

    public static void main(String[] args) {
        Clinica clinica = new Clinica();

        Funcionario funcionario_A = new Funcionario("Raquel Garcia", "111.111.111-11", "parco della veritá",
                "84 98860-6745", 100000, "2020202", Cargo.AUXILIAR_TOSADOR);
        Funcionario funcionario_B = new Funcionario("Angelo Melo", "000.000.000-00", "parco della veritá",
                "84 98860-6745",
                100000, "2020203", Cargo.TOSADOR);

        clinica.adicionarFuncionario(funcionario_A);
        clinica.adicionarFuncionario(funcionario_B);

        ArrayList<Animal> animaisInicias_A = new ArrayList<>();
        ArrayList<Animal> animaisInicias_B = new ArrayList<>();

        Cliente cliente_A = new Cliente("Pedro Varela", "123.456.789-00", "Rua A, 123", "84 99999-9999",
                animaisInicias_A);
        Cliente cliente_B = new Cliente("Ana Silva", "987.654.321-00", "Rua B, 456", "84 98888-8888",
                animaisInicias_B);

        Animal animal_1 = new Animal("Rex", Especie.CACHORRO, "Labrador", new java.util.Date(), cliente_A);
        Animal animal_2 = new Animal("Miau", Especie.GATO, "Siamês", new java.util.Date(), cliente_B);
        Animal animal_3 = new Animal("Bolt", Especie.CACHORRO, "Vira-lata", new java.util.Date(), cliente_B);

        animaisInicias_A.add(animal_1);
        animaisInicias_B.add(animal_2);
        animaisInicias_B.add(animal_3);

        clinica.adicionarCliente(cliente_A);
        clinica.adicionarCliente(cliente_B);

        Menu.iniciarMenu(clinica);

    }
}
