import model.*;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Clinica clinica = new Clinica();

        ArrayList<Animal> animals = new ArrayList<>();
        Animal animal = new Animal("Maya", Especie.GATO, "Colo de Gato", new Date(), null, null);

        animals.add(animal);

        Cliente cliente = new Cliente("Leon Silva", "980.762.904-44", "Rua dos Mares, 154", "84 91276-1679", animals);
        cliente.exibirDados();
    }
}