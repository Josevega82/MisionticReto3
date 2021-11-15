package co.ciclo3.patinetas.patinetas.repository.crud;
import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Long>{
    
}
