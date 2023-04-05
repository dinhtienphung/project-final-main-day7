package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AccountBanking;
import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.service.AccountBankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/")
public class AccountBankingController {

    @Autowired
    AccountBankingService accountBankingService;

    @RequestMapping(value = "/addBankingCart",method = RequestMethod.GET)
    public String showNewBanking(Model model){
        model.addAttribute("accountBanking", new AccountBanking());
        return "banking";
    }
    @RequestMapping(value = "/addBankingCart",method = RequestMethod.POST)
    public String saveBanking(@ModelAttribute("accountBanking") AccountBanking accountBanking,
                              @RequestParam("fullName") String fullName,
                              @RequestParam("cardNumber") int cardNumber,
                              @RequestParam("balance") double balance,
                              @RequestParam("cvc") int cvc, Model model, HttpSession session) {
        accountBanking.setFullName(fullName);
        accountBanking.setCardNumber(cardNumber);
        accountBanking.setCvc(cvc);
        accountBanking.setBalance(balance);
        AccountEntity accountEntity = (AccountEntity) session.getAttribute("account");
        accountBanking.setAccount(accountEntity);
        accountBankingService.save(accountBanking);
        return "redirect:/cart";
    }
}
