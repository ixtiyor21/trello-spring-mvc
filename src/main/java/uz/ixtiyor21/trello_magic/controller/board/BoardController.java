package uz.ixtiyor21.trello_magic.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.ixtiyor21.trello_magic.controller.AbstractController;
import uz.ixtiyor21.trello_magic.dto.project.ProjectDto;
import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;
import uz.ixtiyor21.trello_magic.entity.task.Task;
import uz.ixtiyor21.trello_magic.service.project.ProjectService;
import uz.ixtiyor21.trello_magic.service.projectColumn.ProjectColumnService;
import uz.ixtiyor21.trello_magic.service.task.TaskService;

import java.util.List;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController extends AbstractController<ProjectService> {

    private final ProjectColumnService projectColumnService;
    private final TaskService taskService;

    public BoardController(ProjectService service, ProjectColumnService projectColumnService, TaskService taskService) {
        super(service);
        this.projectColumnService = projectColumnService;
        this.taskService = taskService;
    }

    @RequestMapping(value = "project/{id}")
    public ModelAndView boardPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        List<ProjectColumn> projectColumns = projectColumnService.getColumnByProjectId(id);
        ProjectDto project = service.getById(id);
        List<Task> tasks = taskService.getAllByProjectId(id);
        Integer countClosedTasks = taskService.getCountClosedTasksList(tasks);
        Integer countCompletedTasks = taskService.getCountCompletedTasksList(tasks);
        modelAndView.addObject("columns", projectColumns);
        modelAndView.addObject("countClosed", countClosedTasks);
        modelAndView.addObject("countCompleted", countCompletedTasks);
        modelAndView.addObject("tasks", tasks);
        modelAndView.addObject("project", project);
        modelAndView.setViewName("board/Board");
        return modelAndView;
    }

}
