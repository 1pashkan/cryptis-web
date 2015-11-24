package ru.cryptis.web.subscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/actions")
public class SubscribeActionServlet extends HttpServlet {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @RequestMapping(value = "/subscribe")
    @ResponseBody
    public ResponseEntity subscribe(@RequestParam String email) {
        if (subscriptionRepository.exists(email)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        } else {
            subscriptionRepository.save(new Subscription(email));
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    // PROTECT WITH WEB SERVER!
    @RequestMapping(value = "/subscriptions")
    @ResponseBody
    public List<Subscription> getSubscriptions() {
        return subscriptionRepository.findAll();
    }
}
