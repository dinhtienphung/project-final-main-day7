package com.mycompany.spring_mvc_project_final.controller;


import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.RoleEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.repository.RoleRepository;
import com.mycompany.spring_mvc_project_final.service.AccountService;
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
//        RoleEntity role = roleRepository.getRoleUser();

        Set<RoleEntity> roles = new HashSet<>();
        roles.add(role);
        accountEntity.setUserRoles(roles);
        accountEntity.setStatus(UserStatus.UNACTIVE);
        accountEntity.setRegistration_date(new Date());
        accountService.save(accountEntity);

//
//       int id = accountEntity.getId();
//
//      String email = accountEntity.getEmail();
//      sendEmail(email, "kích hoạt mail","bam vô");
//        model.addAttribute("accountEntity", accountEntity);
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
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailSender.send(mailMessage);
        System.out.println(mailMessage);
    }
}