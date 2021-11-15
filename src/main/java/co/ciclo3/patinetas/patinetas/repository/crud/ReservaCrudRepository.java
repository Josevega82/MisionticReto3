package co.ciclo3.patinetas.patinetas.repository.crud;
import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.model.Reserva;
import org.springframework.data.repository.CrudRepository;

public interface ReservaCrudRepository extends CrudRepository<Reserva,Long>{
    
}
