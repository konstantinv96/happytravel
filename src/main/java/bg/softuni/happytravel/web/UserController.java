package bg.softuni.happytravel.web;

import bg.softuni.happytravel.model.UserEntity;
import bg.softuni.happytravel.model.dto.UserRegistrationDTO;
import bg.softuni.happytravel.model.views.UserProfileView;
import bg.softuni.happytravel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO initForm(){
        return new UserRegistrationDTO();
    }


    @GetMapping("/register")
    public String register(Model model){

        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegistrationDTO userRegistrationDTO,
                             BindingResult bindingResult , RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);

            return "redirect:/register";
        }

            this.userService.register(userRegistrationDTO);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

    @PostMapping("/login/error")
    public String onFailLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.
            SPRING_SECURITY_FORM_USERNAME_KEY) String username , RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY , username);
        redirectAttributes.addFlashAttribute("bad_credentials" , true);

        return"redirect:/login";
    }

    @GetMapping("/profile")
    public String profile(Principal principal , Model model){

        String username = principal.getName();
        UserEntity user = userService.getUser(username);

        UserProfileView userProfileView = new UserProfileView(
                username,
                user.getEmail(),
                user.getFullName());

        model.addAttribute("user" , userProfileView);


        return "profile";
    }
}
