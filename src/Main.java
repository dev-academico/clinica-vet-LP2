import model.Clinica;
import model.Veterinario;

public class Main {
    public static void main(String[] args) {

        Clinica clinica = new Clinica();
        Veterinario veterinario1 = new Veterinario("Raquel Garcia", "111.111.111-11", "parco della veritá", "84 98860-6745", 100000, "1010101");
        Veterinario veterinario2 = new Veterinario("Raquel Garcia", "000.000.000-00", "parco della veritá", "84 98860-6745", 100000, "1010102");

        //create veterinário
        clinica.adicionarVeterinário(veterinario1);
        clinica.adicionarVeterinário(veterinario2);

        //remover veterinário
        clinica.removerVeterinário(veterinario2);

        // read
        clinica.lerVeterinário("1010101");

        // update veterinário
        clinica.atualizarVeterinário(null, "111.111.111-11", null, null, 300000, "1010101");

        // read
        clinica.lerVeterinário("1010101");


    }
}