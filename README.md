import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodWasteRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String restaurantName;
    private String foodType;
    private int quantity;
    // getters and setters
}
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodWasteRequestRepository extends JpaRepository<FoodWasteRequest, Long> {
}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodWasteRequestController {
    @Autowired
    private FoodWasteRequestRepository repository;

    @PostMapping("/request")
    public void createRequest(@RequestBody FoodWasteRequest request) {
        repository.save(request);
    }
}
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodWasteApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodWasteApplication.class, args);
    }
}
