package co.ciclo3.patinetas.patinetas.repository;

import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.repository.crud.CategoriaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaRepository {
    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;
    
    public List<Categoria> getAll(){
        return (List<Categoria>) categoriaCrudRepository.findAll();
    }
    public Optional<Categoria> getCategoria(long id){
        return categoriaCrudRepository.findById(id);
    }
    public Categoria save(Categoria c) {
        return categoriaCrudRepository.save(c);
    }
    public void delete(Categoria c) {
        categoriaCrudRepository.delete(c);
    }
}
