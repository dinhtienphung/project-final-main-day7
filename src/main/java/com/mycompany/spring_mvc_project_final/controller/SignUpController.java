package com.mycompany.spring_mvc_project_final.controller;


import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.Cart;
import com.mycompany.spring_mvc_project_final.entities.RoleEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.repository.RoleRepository;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import com.mycompany.spring_mvc_project_final.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.mycompany.spring_mvc_project_final.enums.Role.ROLE_ADMIN;
import static com.mycompany.spring_mvc_project_final.enums.Role.ROLE_USER;

@Controller
public class SignUpController {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    AccountService accountService;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    CartService cartService;
    @Autowired
    MailSender mailSender;

    @GetMapping("/signup")
    public String signUpPage(Model model, @RequestParam(value = "error", required = false) boolean error) {
        if (error) {
            model.addAttribute("message", "Login Fail!!!");
        }
        model.addAttribute("newAccount", new AccountEntity());
        return "signup";

    }

    @PostMapping("signup")
    public  String signUp(@ModelAttribute(name = "newAccount") AccountEntity accountEntity, Model model, @RequestParam String password_two) {
        System.out.println(accountEntity.getFullName());
        if(!accountEntity.getPassword().equals(password_two)) {
            return "signup";
        }
        // Encoder password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        accountEntity.setPassword(encoder.encode(accountEntity.getPassword()));
        RoleEntity role = new RoleEntity();
        role.setRole(ROLE_USER);
        role.setId(2);

        Set<RoleEntity> roles = new HashSet<>();
        roles.add(role);
        accountEntity.setUserRoles(roles);
        accountEntity.setStatus(UserStatus.ACTIVE);
        accountEntity.setRegistration_date(new Date());
        accountService.save(accountEntity);




        Cart cart1 = new Cart();
        cart1.setAccount(accountEntity);
        cartService.save(cart1);

      String email = accountEntity.getEmail();
      sendEmail(email, "kích hoạt mail","ĐĂNG KÍ THÀNH CÔNG");
        return "login";
    }

//    @GetMapping("/activate")
//    public String activate(@RequestParam("id") int id, Model model) {
//        AccountEntity accountEntity = accountService.findById(id);
//        if (accountEntity != null) {
//            accountEntity.setStatus(UserStatus.ACTIVE);
//            accountService.save(accountEntity);
//            // add any necessary attributes to the model
//            return "login";
//        } else {
//            // add any necessary attributes to the model
//            return "signup";
//        }
//    }

        public void sendEmail(String to, String subject, String content) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("phannhattai14071996@gmail.com");
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setText(content);
            System.out.println(mailSender);
            mailSender.send(mailMessage);
            System.out.println(mailMessage);
        }
}