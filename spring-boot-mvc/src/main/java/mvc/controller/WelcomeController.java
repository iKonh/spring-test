package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.Optional;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {
//    ResourceHandlerRegistry
    @Autowired
    WebMvcAutoConfiguration webMvcAutoConfiguration;
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public ModelAndView userUpdateInfo() {
        return new ModelAndView("welcome");
    }
}
