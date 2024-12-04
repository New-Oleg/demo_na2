package com.example.razrabotca_programm_modula_dla_ucheta_orders_na_rem_orgt.Controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.razrabotca_programm_modula_dla_ucheta_orders_na_rem_orgt.Obj.Orders;
import com.example.razrabotca_programm_modula_dla_ucheta_orders_na_rem_orgt.Obj.User;
import com.example.razrabotca_programm_modula_dla_ucheta_orders_na_rem_orgt.repos.OrderRepos;
import com.example.razrabotca_programm_modula_dla_ucheta_orders_na_rem_orgt.repos.UserRepos;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;





@Controller
public class Controllers {

    @Autowired
    OrderRepos or;
    @Autowired
    UserRepos ur;

    User me = new User(-1,"","","","","","","");

    @GetMapping("/main")
    public String getMethodName(Model model) {
        model.addAttribute("orders", or.findAll());
        return "main";
    }
    @PostMapping("/main")
    public String find(@RequestParam int id) {
        Orders order = new Orders();
        return "";
    }
    




    @GetMapping("/add")
    public String getAddPage() {
        return "add";
    }
    @PostMapping("/add")
    public String addOrder(@RequestParam String problem,
                        @RequestParam String model,
                        @RequestParam String dis,
                        @RequestParam String status) {
        Orders order = new Orders();
        order.setDateAdd(LocalDate.now());
        order.setModel(model);
        order.setDis(dis);
        order.setStatus(status);
        order.setPoroblem(problem);
        order.setAuthorId(me.getId());
        or.save(order);
        return "redirect:/main";
    }
    
    @GetMapping("/red{id}")
    public String getredPage() {
        return "red";
    }
    @PostMapping("/red{id}")
    public String addOrewrder(@RequestParam String worcer,
                        @RequestParam String dis,
                        @RequestParam String status,
                        @RequestPart int id) {
        Orders order = or.findById(id);
        order.setDateAdd(LocalDate.now());
        order.setDis(dis);
        order.setStatus(status);
        order.setAuthorId(me.getId());
        or.save(order);
        return "redirect:/main";
    }
    

    

 

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login"; // Имя вашего шаблона Thymeleaf (login.html)
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String login, @RequestParam String pass, Model model) {
        User a = ur.findByLogin(login);
        if (login.equals(a.getLogin()) && pass.equals(a.getPass())) {
            // Успешный вход
            me=a;
            model.addAttribute("message", "Успешный вход!");
            return "redirect:/main"; 
        } else {
            // Неудачный вход
            model.addAttribute("error", "Неверный логин или пароль");
            return "redirect:/login"; // Возвращаемся на форму логина
        }
    }

}
