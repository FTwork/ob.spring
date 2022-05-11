
package ft.obspring.repositories;

import ft.obspring.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Franco Tallei
 */

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{
    
}
