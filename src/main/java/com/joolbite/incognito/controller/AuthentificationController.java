package com.joolbite.incognito.controller;

        import java.util.Optional;
        import java.util.logging.Level;
        import java.util.logging.Logger;

        import com.joolbite.incognito.model.User;
        import com.joolbite.incognito.repo.IUserRepository;
        import com.joolbite.incognito.service.authentification.AuthentificationService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class AuthentificationController {

    @Autowired
    private AuthentificationService authService;

    @GetMapping("")
    public User findUser(@PathVariable User user) {
        User user1;
        user1 = authService.rechercherUser(user);
        return user1;
    }

    // TODO
    @GetMapping("/jory")
    public User findJory() {
        User jory = new User();
        jory.setPassword("joryMdp");
        jory.setMail("jory.labat@gmail.com");
        jory = authService.rechercherUser(jory);
        return jory;
    }

}