package mvc.controller;

import mvc.controller.dto.TestDataDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {
//    ResourceHandlerRegistry
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public ModelAndView userUpdateInfo() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value = {"/welcome_2"}, method = RequestMethod.GET)
    public String userUpdateInfo_2() {
        return "redirect:welcome";
    }

    @RequestMapping(value = {"/welcome_3"}, method = RequestMethod.GET)
    public String userUpdateInfo_3() {
        return "forward:welcome";
    }

    @RequestMapping(value = {"/welcome_4"}, method = RequestMethod.GET)
    public String userUpdateInfo_4() {
        return "redirect:http://www.baidu.com";
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
