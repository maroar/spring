package entidades;

import java.util.List; 

public class Dispensasao {

    private final long id;
    private final Prescricao prescricao;
    private List<Medicamento> medicamentos;
    private final String data;

    public Dispensasao(
        long id,
        Prescricao prescricao,
        List<Medicamento> medicamentos,
        String data) 
    {
        this.id = id;
        this.prescricao = prescricao;
        this.medicamentos = medicamentos;
        this.data = data;
    }

    public Dispensasao(
        long id,
        Prescricao prescricao,
        String data) 
    {
        this.id = id;
        this.prescricao = prescricao;
        this.data = data;
    }


    public long getId() {
        return id;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    } 

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public String getData() {
        return data;
    }
}

