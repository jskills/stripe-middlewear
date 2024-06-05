package payments.stripe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.stripe.model.Charge;
import com.stripe.exception.StripeException;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin
@RestController
public class PaymentController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/charge")
    public ResponseEntity<?> chargeCard(@RequestParam String token, @RequestParam double amount) {
        try {
            // Create the charge and immediately use it within the same try block
            Charge charge = stripeService.chargeCreditCard(token, amount);
            Map<String, Object> response = new HashMap<>();
            response.put("status", charge.getStatus());
            response.put("id", charge.getId());
            response.put("description", charge.getDescription());
            response.put("amount", charge.getAmount());  // Ensure this is calculated correctly as cents vs dollars if needed
            return ResponseEntity.ok(response);
        } catch (StripeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to charge: " + e.getMessage());
        }
    }
}

