package co.ciclo3.patinetas.patinetas.service;

import co.ciclo3.patinetas.patinetas.model.Patineta;
import co.ciclo3.patinetas.patinetas.repository.PatinetaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePatineta {
    @Autowired
    private PatinetaRepository patinetaRepository;
    public List<Patineta> getAll(){
        return patinetaRepository.getAll();
    }
    public Optional<Patineta> getPatineta(long id){
        return patinetaRepository.getPatineta(id);
    }
    
    public Patineta save(Patineta p) {
        if (p.getId()==null){
            return patinetaRepository.save(p);
        }else{
            Optional<Patineta> pAux = patinetaRepository.getPatineta(p.getId());
            if(pAux.isEmpty()){
                return patinetaRepository.save(p);
            }else{
                return p;
            }
        }
        
    }
    public Patineta update(Patineta p){
        if(p.getId() != null){
            Optional<Patineta> g = patinetaRepository.getPatineta(p.getId());
            if (!g.isEmpty()) {
             if (p.getName() != null) {
                 g.get().setName(p.getName());
             }
             if (p.getBrand()!= null) {
                 g.get().setBrand(p.getBrand());
             }
             if (p.getDescription() != null) {
                 g.get().setDescription(p.getDescription());
             }
             if (p.getYear() != null) {
                 g.get().setYear(p.getYear());
             }
             if (p.getCategory() != null) {
                 g.get().setCategory(p.getCategory());
             }
             return patinetaRepository.save(g.get());
            }
                    
        }
        return p;
    }
    

    
    public boolean deleteCategoria(long id){
        Optional<Patineta> p = getPatineta(id);
        if (!p.isEmpty()){
            patinetaRepository.delete(p.get());
            return true;
        }
        return false;
    }
}
