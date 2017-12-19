package repositorios;
 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
 
import entidades.Prescricao;
 
public interface RepositorioPrescricao extends JpaRepository<Prescricao, Long> {

    List<Prescricao> findByData(String data);

    Prescricao findById(Long id);

    List<Prescricao> findAll();
    
}