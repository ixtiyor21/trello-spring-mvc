package uz.ixtiyor21.trello_magic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.ixtiyor21.trello_magic.config.Session;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationCreateDto;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationDto;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationUpdateDto;
import uz.ixtiyor21.trello_magic.entity.org.Organization;
import uz.ixtiyor21.trello_magic.service.organization.OrganizationService;

import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    private final OrganizationService organizationService;

    public HomeController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
        if (Session.getSession().getIs_SuperUser()) {
            List<Organization> organizations = organizationService.getAll();
            List<OrganizationDto> organizationDtos = organizationService.getAllAndParse(organizations);
            modelAndView.addObject("organizations", organizationDtos);
            modelAndView.setViewName("home/OrganizationHome");
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/project/home");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/organization/{name}")
    public ModelAndView detail(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView();
        OrganizationDto organizationDto = organizationService.getByName(name);
        modelAndView.addObject("obj", organizationDto);
        modelAndView.setViewName("home/OrganizationDetail");
        return modelAndView;
    }

    @RequestMapping(value = "/organization/create", method = RequestMethod.GET)
    public String createPage() {
        return "home/OrganizationCreate";
    }

    @RequestMapping(value = "/organization/create", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto organizationCreateDto) {
        organizationService.create(organizationCreateDto);
        return "redirect:/";
    }

    @RequestMapping(value = "/organization/delete/{name}")
    public String deleteOrg(@PathVariable String name) {
        organizationService.deleteOrg(name);
        return "redirect:/";
    }

    @RequestMapping(value = "/organization/update/{name}", method = RequestMethod.GET)
    public ModelAndView updateOrg(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView();
        OrganizationDto org = organizationService.getByName(name);
        modelAndView.addObject("obj", org);
        modelAndView.setViewName("home/OrganizationUpdate");
        return modelAndView;
    }

    @RequestMapping(value = "/organization/update/{id}", method = RequestMethod.POST)
    public String updateOrgPage(@PathVariable Long id, @ModelAttribute OrganizationUpdateDto organizationUpdateDto) {
        organizationService.updateOrg(id, organizationUpdateDto);
        return "redirect:/";
    }
}
