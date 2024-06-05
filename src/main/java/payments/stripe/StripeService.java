package payments.stripe;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${stripe.api.key}")
    private String apiKey;

    public Charge chargeCreditCard(String token, double amount) throws StripeException {
        Stripe.apiKey = apiKey;

        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", (int) (amount * 100));
        chargeParams.put("currency", "USD");
        chargeParams.put("source", token); // obtained with Stripe.js
        chargeParams.put("description", "Charge for products or services");

        return Charge.create(chargeParams);
    }
}

