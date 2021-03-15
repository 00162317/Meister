package com.woodM.Project.Stripe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.woodM.Project.Stripe.ChargeRequest.Currency;

@Controller
public class CheckoutController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        System.out.println("HEY");
        return "checkout";
    }
    
    @Autowired
    StripeService paymentsService;

    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model) throws StripeException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(Currency.EUR);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        System.out.println("ID"+charge.getId());
        model.addAttribute("status", charge.getStatus());
        System.out.println("STATUS"+charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        System.out.println("ID"+charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        System.out.println("BALANCE"+charge.getBalanceTransaction());
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        System.out.println("HEEEEY "+ ex.getMessage());
        return "result";
    }
}