package codegym.controller;

import codegym.model.ClassRoom;
import codegym.model.Student;
import codegym.service.IClassRoomService;
import codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;

    @Autowired
    IClassRoomService classRoomService;

    @ModelAttribute
    public ArrayList<ClassRoom> listClassRoom(){
        return classRoomService.findAll();
    }

    @GetMapping("/show")
    public ModelAndView show(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "3") int sizePage){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", studentService.findAll(PageRequest.of(pageNumber,sizePage)));
        return modelAndView;
    }
    @GetMapping("/create")
    private ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message",e.getMessage());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/show");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable long id){
       ModelAndView modelAndView = new ModelAndView("edit");
       modelAndView.addObject("student", studentService.findById(id));
       return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("edit");
            return modelAndView;
        }
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/show");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id){
        studentService.delete(studentService.findById(id));
        ModelAndView modelAndView = new ModelAndView("redirect:/show");
        return modelAndView;
    }
    @GetMapping("/findByName")
    public  ModelAndView findByName(@RequestParam String findName){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", studentService.findAllByName(findName));
        return modelAndView;
    }
}
