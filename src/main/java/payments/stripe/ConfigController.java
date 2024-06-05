package payments.stripe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class ConfigController {

    @Value("${stripe_publishable_key}")
    private String publishableKey;

    @GetMapping("/config/stripe-key")
    public String getPublishableKey() {
        return this.publishableKey;
    }
}

