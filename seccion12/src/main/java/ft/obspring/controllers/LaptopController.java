package ft.obspring.controllers;

import ft.obspring.entities.Laptop;
import ft.obspring.repositories.LaptopRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franco Tallei
 */
@RestController
public class LaptopController {

    private LaptopRepository laptopRepo;

    public LaptopController(LaptopRepository laptopRepo) {
        this.laptopRepo = laptopRepo;
    }

    /**
     * http://localhost:8081/api/laptops
     *
     * @return lista de libros en base de datos
     */
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepo.findAll();
    }
    
    /**
     * http://localhost:8081/api/laptops/id
     * @param id
     * @return libro que corresponde al id
     */
    @GetMapping("/api/laptops/{id}")
    public Laptop findOneById(@PathVariable Long id) {
        Optional<Laptop> var = laptopRepo.findById(id);
//Opcion 1
//Expresion funcional
        return var.orElse(null);
        
//Opcion 2
        //if (var.isPresent()) {
        //    return var.get();
        //}else{
        //    return null;
        //}
    }
    
    /**
     * No genera conflicto por diferentes acciones http
     * http://localhost:8081/api/laptops
     * @param laptop
     * @return 
     */
    @PostMapping("/api/laptops")
    public Laptop save(@RequestBody Laptop laptop){
        return laptopRepo.save(laptop);
    }
    
    /**
     * Modificar laptops
     * http://localhost:8081/api/laptops
     * @param laptop
     * @return 
     */
    @PutMapping("/api/laptops")
    public Laptop update(@RequestBody Laptop laptop){
        return laptopRepo.save(laptop);
    }
    
    /**
     * Eliminar una laptop
     * http://localhost:8081/api/laptops/{id}
     * @param id
     * @return 
     */
    @DeleteMapping("api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        laptopRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    /**
     * Eliminar todas las laptops
     * http://localhost:8081/api/laptops
     * @return 
     */
    @DeleteMapping("api/laptops/")
    public ResponseEntity<Laptop> deleteAll(){
        System.out.println("Ejecutando metodo de borrar toda la base de datos");
        laptopRepo.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
