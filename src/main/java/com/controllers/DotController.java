package com.controllers;

import com.entities.Dot;
import com.entities.DotRepository;
import com.entities.DotRequest;
import com.entities.User;
import com.services.DotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.transaction.Transactional;
import java.util.List;


@RestController
public class DotController {

    @Autowired
    private DotService dotService;

    @Autowired
    private DotRepository dotRepository;

    @PostMapping(path="/adddot")
    public @ResponseBody
    Dot addDot (@RequestBody DotRequest point) {
        System.out.println(point.getX() + " " + point.getY() + " " + point.getX());
        if(dotService.validate(point.getX(), point.getY(), point.getR())) {
            Dot dot = new Dot();
            dot.setR(point.getR());
            dot.setX(point.getX());
            dot.setY(point.getY());
            dot.setLogin(point.getLogin());
            dot.setIngress(dotService.checkArea(point.getX(), point.getY(), point.getR()));
            dotRepository.save(dot);
            System.out.println(dot.getLogin() + " пипурка");
            return dot;
        }
        else{
            System.out.println("Пипурка");
            return null;
        }
    }

    @GetMapping(value = "/adddot")
    public List<Dot> getAll(@RequestParam("login") String login) {
        try {
            return dotRepository.getAllByLogin(login);
        }
        catch (Exception e){
            return null;
        }
    }

    @DeleteMapping("/adddot")
    @Transactional
    public void deleteAll(@RequestParam("login") String login) {
        dotRepository.deleteDotsByLogin(login);
    }

}
