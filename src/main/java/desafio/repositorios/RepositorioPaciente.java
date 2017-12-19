package repositorios;
 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
 
import entidades.Paciente;
 
public interface RepositorioPaciente extends JpaRepository<Paciente, Long> {

    Paciente findByNome(String nome);

    Paciente findById(Long id);

}
