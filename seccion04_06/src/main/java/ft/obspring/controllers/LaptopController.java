package ft.obspring.controllers;

import ft.obspring.entities.Laptop;
import ft.obspring.repositories.LaptopRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @PostMapping("/api/laptops")
    public Laptop save(@RequestBody Laptop laptop){
        return laptopRepo.save(laptop);
    }
}
