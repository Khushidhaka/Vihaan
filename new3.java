// FoodWasteRequestController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodWasteRequestController {

    private final FoodWasteRequestRepository repository;

    @Autowired
    public FoodWasteRequestController(FoodWasteRequestRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/request")
    public void createRequest(@RequestBody FoodWasteRequest request) {
        repository.save(request);
    }
}
