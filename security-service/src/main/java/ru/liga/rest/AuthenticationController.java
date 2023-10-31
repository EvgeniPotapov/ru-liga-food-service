package ru.liga.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@AllArgsConstructor
public class AuthenticationController {

    @GetMapping("/unsecured")
    public String unsecuredData(){
        return "UnSecured data";
    }

    @GetMapping("/secured")
    public String securedData(){
        return "Secured data";
    }

    @GetMapping("info")
    public String userData(Principal principal){
        return principal.getName();
    }

}
