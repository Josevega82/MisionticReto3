package co.ciclo3.patinetas.patinetas.repository.crud;
import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface MensajeCrudRepository extends CrudRepository<Mensaje,Long>{
    
}
