package entidades;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = Medicamento.tableName)
public class Medicamento {

    public static final String tableName = "medicamentos";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    private String nome;

    public Medicamento() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    } 

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

