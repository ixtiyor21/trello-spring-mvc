package uz.ixtiyor21.trello_magic.controller.projectMember;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.ixtiyor21.trello_magic.controller.AbstractController;
import uz.ixtiyor21.trello_magic.dto.projectMember.ProjectMemberCreateDto;
import uz.ixtiyor21.trello_magic.service.projectMember.ProjectMemberService;

@Controller
@RequestMapping(value = "/projectMember/*")
public class projectMemberController extends AbstractController<ProjectMemberService> {

    public projectMemberController(ProjectMemberService service) {
        super(service);
    }

    @RequestMapping(value = "create")
    public String addMember(@ModelAttribute ProjectMemberCreateDto projectMemberCreateDto) {
        service.create(projectMemberCreateDto);
        return "redirect:/";
    }
}
