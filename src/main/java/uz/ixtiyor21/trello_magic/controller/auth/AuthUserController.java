package uz.ixtiyor21.trello_magic.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.ixtiyor21.trello_magic.config.Session;
import uz.ixtiyor21.trello_magic.controller.AbstractController;
import uz.ixtiyor21.trello_magic.dto.auth.AuthUserUpdateDto;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.service.auth.AuthUserService;

@Controller
@RequestMapping("/auth/*")
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = "login")
    private String loginPage() {
        return "auth/login";
    }

    @RequestMapping(value = "profile/{id}")
    public ModelAndView profilePage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        AuthUser user = service.getById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("auth/Profile");
        return modelAndView;
    }

    @RequestMapping(value = "profile/{id}", method = RequestMethod.POST)
    public String profileUpdate(@PathVariable Long id, @ModelAttribute AuthUserUpdateDto authUserUpdateDto) {
        service.updateProfile(id, authUserUpdateDto);
        return "redirect:/";
    }

    @RequestMapping(value = "logout")
    public String logoutPage() {
        return "auth/Logout";
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public void logout() {
        Session.setSession();
    }

}
