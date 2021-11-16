package co.ciclo3.patinetas.patinetas.service;

import co.ciclo3.patinetas.patinetas.model.Categoria;
import co.ciclo3.patinetas.patinetas.repository.CategoriaRepository;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCategoria {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> getAll(){
        
        return categoriaRepository.getAll();
    }
    public Optional<Categoria> getCategoria(long id){
        return categoriaRepository.getCategoria(id);
    }
    
    public Categoria save(Categoria c) {
        if (c.getId()==null){
            return categoriaRepository.save(c);
        }else{
            Optional<Categoria> pAux = categoriaRepository.getCategoria(c.getId());
            if(pAux.isEmpty()){
                return categoriaRepository.save(c);
            }else{
                return c;
            }
        }
        
    }
    public Categoria update(Categoria c){
        if(c.getId() != null){
            Optional<Categoria> g = categoriaRepository.getCategoria(c.getId());
            if (!g.isEmpty()) {
             if (c.getName() != null) {
                 g.get().setName(c.getName());
             }
             if (c.getDescription() != null) {
                 g.get().setDescription(c.getDescription());
             }
             return categoriaRepository.save(g.get());
            }
                    
        }
        return c;
    }
    public boolean deleteCategoria(long id){
        Optional<Categoria> c = getCategoria(id);
        if (!c.isEmpty()){
            categoriaRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
