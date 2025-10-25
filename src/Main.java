import java.util.ArrayList;
import model.Animal;
import model.Cargo;
import model.Cliente;
import model.Clinica;
import model.Funcionario;

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

        Animal animal_1 = new Animal("Rex", model.Especie.CACHORRO, "Labrador", new java.util.Date(), 30.0f,
                "Nenhuma observação", "123.456.789-00");
        Animal animal_2 = new Animal("Miau", model.Especie.GATO, "Siamês", new java.util.Date(), 10.0f,
                "Nenhuma observação", "123.456.789-00");
        Animal animal_3 = new Animal("Bolt", model.Especie.CACHORRO, "Vira-lata", new java.util.Date(), 20.0f,
                "Nenhuma observação", "123.456.789-00");

        ArrayList<Animal> animaisInicias_A = new ArrayList<>();
        animaisInicias_A.add(animal_1);
        ArrayList<Animal> animaisInicias_B = new ArrayList<>();
        animaisInicias_B.add(animal_2);
        animaisInicias_B.add(animal_3);

        Cliente cliente_A = new Cliente("Pedro Varela", "123.456.789-00", "Rua A, 123", "84 99999-9999",
                animaisInicias_A);
        Cliente cliente_B = new Cliente("Ana Silva", "987.654.321-00", "Rua B, 456", "84 98888-8888", animaisInicias_B);

        clinica.adicionarCliente(cliente_A);
        clinica.adicionarCliente(cliente_B);

    }
}