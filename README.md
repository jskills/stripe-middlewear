# stripe-middlewear
A simple Java Sprint Boot REST service to connect to Stripe APIs

To test locally:

- Ensure you have Java version 17 or higher installed

- You will need to set the values of both "stripe_publishable_key" and "stripe_api_key" as environment variables.  You get both of these from the Stripe console once you have set up an account with them.

- add your own logs/ directory for local logging.

- Run './gradlew bootRun' to start the REST service

- If you hit "http://localhost:8080" you'll bring up the index.html page that allows for (very) basic testing of credit card charging.

- The page loads the stripe_publishable_key from the environment variable and embeds it into front-end calls to the REST service.  The REST service itself will utilize the "stripe_api_key" to send calls to Stripe's APIs.

- The page uses the Stripe JavaScript library which is handy for a variety of things.  [https://js.stripe.com/v3/](https://js.stripe.com/v3/)

- Any calls to test credit cards / make charges etc. are predicated by a call to get a secure token from Stripe first (using the above JavaScript library).  This is automatically done when the page loads prior to any calls being made to the REST service.

- This was a extremely basic attempt to set up end to end testing.  Be sure to have your Stripe account set to "testing" mode as this will send through actual charges if you have not done that and are using production API keys.




