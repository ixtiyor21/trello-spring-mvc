package uz.ixtiyor21.trello_magic.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.ixtiyor21.trello_magic.config.Session;
import uz.ixtiyor21.trello_magic.controller.AbstractController;
import uz.ixtiyor21.trello_magic.dto.org.OrganizationDto;
import uz.ixtiyor21.trello_magic.dto.project.ProjectCreateDto;
import uz.ixtiyor21.trello_magic.dto.project.ProjectDto;
import uz.ixtiyor21.trello_magic.dto.project.ProjectUpdateDto;
import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
import uz.ixtiyor21.trello_magic.entity.org.Organization;
import uz.ixtiyor21.trello_magic.service.auth.AuthUserService;
import uz.ixtiyor21.trello_magic.service.organization.OrganizationService;
import uz.ixtiyor21.trello_magic.service.project.ProjectService;

import java.util.List;

@Controller
@RequestMapping("/project/*")
public class ProjectController extends AbstractController<ProjectService> {

    private final OrganizationService organizationService;
    private final AuthUserService authUserService;

    public ProjectController(ProjectService service, OrganizationService organizationService, AuthUserService authUserService) {
        super(service);
        this.organizationService = organizationService;
        this.authUserService = authUserService;
    }

    @RequestMapping(value = "home")
    public ModelAndView projectHome() {
        ModelAndView modelAndView = new ModelAndView();
        if (Session.getSession().getRole().getCode().equals("ADMIN")) {
            OrganizationDto organization = organizationService.getByName(Session.getSession().getOrganization().getName());
            List<ProjectDto> projects = service.getAllByOrgId(organization.getId());
            modelAndView.addObject("projects", projects);
            modelAndView.addObject("organization", organization);
        } else {
            if (Session.getSession().getRole().getCode().equals("MANAGER")) {
                OrganizationDto organization = organizationService.getByName(Session.getSession().getOrganization().getName());
                List<ProjectDto> projects = service.getProjectsByUserIdWithProjectMembers(Session.getSession().getId());
                modelAndView.addObject("projects", projects);
                modelAndView.addObject("organization", organization);
            } else if (Session.getSession().getRole().getCode().equals("EMPLOYEE")) {
                OrganizationDto organization = organizationService.getByName(Session.getSession().getOrganization().getName());
                List<ProjectDto> projects = service.getAllByOrgId(organization.getId());
                modelAndView.addObject("projects", projects);
                modelAndView.addObject("organization", organization);
            }
        }
        modelAndView.setViewName("project/ProjectHome");
        return modelAndView;
    }

    @RequestMapping(value = "create")
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Organization> all = organizationService.getAll();
        modelAndView.setViewName("project/ProjectCreate");
        modelAndView.addObject("organizations", all);
        return modelAndView;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProjectCreateDto projectCreateDto) {
        service.create(projectCreateDto);
        return "redirect:/project/home";
    }

    @RequestMapping(value = "detail/{id}")
    public ModelAndView detailPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        ProjectDto projectDto = service.getById(id);
        modelAndView.addObject("project", projectDto);
        modelAndView.setViewName("project/ProjectDetail");
        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id) {
        if (Session.getSession().getRole().getCode().equals("ADMIN")) {
            service.delete(id);
            return "redirect:/project/home";
        } else {
            return "redirect:/project/home";
        }
    }

    @RequestMapping(value = "update/{id}")
    public ModelAndView updatePage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        if (Session.getSession().getRole().getCode().equals("ADMIN")) {
            ProjectDto byId = service.getById(id);
            modelAndView.addObject("project", byId);
            modelAndView.setViewName("/project/ProjectUpdate");
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/project/home");
            return modelAndView;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable Long id, @ModelAttribute ProjectUpdateDto projectUpdateDto) {
        if (Session.getSession().getRole().getCode().equals("ADMIN")) {
            service.update(id, projectUpdateDto);
            return "redirect:/project/home";
        } else {
            return "redirect:/project/home";
        }
    }

    @RequestMapping(value = "addMember")
    public ModelAndView addMemberPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<ProjectDto> projectDtos = service.getAllByOrgId(Session.getSession().getOrganization().getId());
        List<AuthUser> all = authUserService.getAll();
        modelAndView.addObject("projects", projectDtos);
        modelAndView.addObject("users", all);
        modelAndView.setViewName("project/ProjectAddMember");
        return modelAndView;
    }

}
