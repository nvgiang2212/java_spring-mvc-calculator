package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping
    public ModelAndView welcome() {
        return new ModelAndView("index");
    }

    @RequestMapping("/calculate")
    public ModelAndView calculate(@RequestParam String arg1, @RequestParam String arg2,
                                  @RequestParam String operator, Model model) {
        float result;
        switch (operator) {
            case "+":
                result = Float.parseFloat(arg1) + Float.parseFloat(arg2);
                model.addAttribute("result", "Result Addition : " + result);
                break;
            case "-":
                result = Float.parseFloat(arg1) - Float.parseFloat(arg2);
                model.addAttribute("result","Result Substraction : " + result);
                break;
            case "x":
                result = Float.parseFloat(arg1) * Float.parseFloat(arg2);
                model.addAttribute("result", "Result Multiplication : " + result);
                break;
            case "/":
                if (Float.parseFloat(arg2) == 0) {
                    model.addAttribute("result", "Can't divide 0");
                    break;
                } else {
                    result = Float.parseFloat(arg1) / Float.parseFloat(arg2);
                    model.addAttribute("result", "Result Division : " + result);
                }
                break;
        }
        return new ModelAndView("index");
    }
}
