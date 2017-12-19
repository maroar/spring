package entidades;

import java.util.Set; 
import java.util.HashSet;
import javax.persistence.*;

@Entity
@Table(name = Prescricao.tableName)
public class Prescricao {

    public static final String tableName = "prescricoes";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prescricao_id") 
    private long id;

    @ManyToOne
    @JoinColumn (name="medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn (name="paciente_id")
    private Paciente paciente;

    private String data;

    @ManyToMany
    @JoinTable(name = "prescricoes_medicamentos", 
        joinColumns = @JoinColumn(name = "prescricao_id", referencedColumnName = "prescricao_id"), 
        inverseJoinColumns = @JoinColumn(name = "medicamento_id", referencedColumnName = "medicamento_id"))
    private Set<Medicamento> medicamentos = new HashSet<Medicamento>();

    public long getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    } 

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    } 

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Set<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Set<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

}

