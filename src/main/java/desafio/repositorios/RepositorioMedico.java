package repositorios;
 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
 
import entidades.Medico;
 
public interface RepositorioMedico extends JpaRepository<Medico, Long> {

    Medico findByNome(String nome);

    Medico findById(Long id);

    List<Medico> findAll();
    
}