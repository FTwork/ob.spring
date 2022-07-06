
package ft.obspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Franco Tallei
 */

@RestController
public class HelloController {
    
    @GetMapping("/hola")
    public String greeting(){
        return "Hola mundo como va putines";
    } 
}
