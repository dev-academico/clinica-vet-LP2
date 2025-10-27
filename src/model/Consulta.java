package model;

import exception.EstadoInvalidoException;
import java.time.LocalDate;
import java.time.LocalTime;
public class Consulta extends Servico {
    
    private Integer id;
    private LocalDate data;
    private LocalTime hora;
    private String motivo;
    private String status;
    private Veterinario veterinario;
    private Cliente cliente;
    private Animal animal;

    public Consulta(Integer id, String nome, Funcionario funcionario, String descricao, Float preco,
                    LocalDate data, LocalTime hora, String motivo,
                    Veterinario veterinario, Cliente cliente, Animal animal) {
        
        super(id, nome, funcionario, descricao, preco);
        
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.motivo = motivo;
        this.status = "AGENDADA";
        this.veterinario = veterinario;
        this.cliente = cliente;
        this.animal = animal;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getStatus() {
        return status;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void iniciarConsulta() {
        if (!this.status.equals("AGENDADA")) {
            throw new EstadoInvalidoException("Não é possível iniciar consulta com status: " + this.status); 
        }

        this.status = "EM ANDAMENTO";
        System.out.println("Consulta iniciada");
    }

    public void finalizarConsulta() {
        if (!this.status.equals("EM ANDAMENTO")) {
            throw new EstadoInvalidoException("Não é possível finalizar consulta com status: " + this.status); 
        }

        this.status = "FINALIZADA";
        System.out.println("Consulta finalizada");
    }

    public void cancelarConsulta() {
        if (!this.status.equals("AGENDADA")) {
            throw new EstadoInvalidoException("Não é possível cancelar consulta com status: " + this.status); 
        }
        this.status = "CANCELADA";
        System.out.println("Consulta cancelada");
    }
}
