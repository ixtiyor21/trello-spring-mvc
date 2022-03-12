package uz.ixtiyor21.trello_magic.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.ixtiyor21.trello_magic.config.Session;
import uz.ixtiyor21.trello_magic.controller.AbstractController;
import uz.ixtiyor21.trello_magic.dto.auth.AuthUserCreateDto;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.entity.org.Organization;
import uz.ixtiyor21.trello_magic.service.auth.AuthUserService;
import uz.ixtiyor21.trello_magic.service.organization.OrganizationService;

import java.util.List;

@Controller
@RequestMapping(value = "/user/*")
public class UserController extends AbstractController<AuthUserService> {

    private final OrganizationService organizationService;

    public UserController(AuthUserService service, OrganizationService organizationService) {
        super(service);
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "all")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        List<AuthUser> users = service.getAll();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("user/UserHome");
        return modelAndView;
    }

    @RequestMapping(value = "detail/{id}")
    public ModelAndView detailPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        AuthUser user = service.getById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/UserDetail");
        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id) {
        if (Session.getSession().getIs_SuperUser()) {
            service.delete(id);
            return "redirect:/user/all";
        } else {
            if (Session.getSession().getRole().getCode().equals("ADMIN")) {
                service.delete(id);
                return "redirect:/user/all";
            } else {
                return "redirect:/user/all";
            }
        }
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Organization> all = organizationService.getAll();
        modelAndView.addObject("organizations", all);
        modelAndView.setViewName("user/UserCreate");
        return modelAndView;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute AuthUserCreateDto authUserCreateDto) {
        System.out.println(authUserCreateDto);
        service.create(authUserCreateDto);
        return "redirect:/user/all";
    }
}
