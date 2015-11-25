package mvc.controller;

import mvc.controller.dto.TestDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {
//    ResourceHandlerRegistry
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public ModelAndView userUpdateInfo() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    @ResponseBody
    public List<TestDataDto> test() {
        List<TestDataDto> testDataDtoList = new ArrayList<>();
        TestDataDto testDataDto = new TestDataDto();
        testDataDto.setName("Bill");
        testDataDto.setAge(15);
        testDataDtoList.add(testDataDto);
        TestDataDto testDataDto2 = new TestDataDto();
        testDataDto2.setName("Kate");
        testDataDto2.setAge(16);
        testDataDtoList.add(testDataDto2);
        return testDataDtoList;
    }
}
