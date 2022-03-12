package uz.ixtiyor21.trello_magic.controller.task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uz.ixtiyor21.trello_magic.controller.AbstractController;
import uz.ixtiyor21.trello_magic.dto.task.TaskCreateDto;
import uz.ixtiyor21.trello_magic.dto.task.TaskDto;
import uz.ixtiyor21.trello_magic.dto.task.TaskLevelUpdateDto;
import uz.ixtiyor21.trello_magic.dto.task.TaskStatusUpdateDto;
import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;
import uz.ixtiyor21.trello_magic.service.projectColumn.ProjectColumnService;
import uz.ixtiyor21.trello_magic.service.task.TaskService;

import java.util.List;

@Controller
@RequestMapping(value = "/task/*")
public class TaskController extends AbstractController<TaskService> {

    private final ProjectColumnService projectColumnService;

    public TaskController(TaskService service, ProjectColumnService projectColumnService) {
        super(service);
        this.projectColumnService = projectColumnService;
    }

    @RequestMapping(value = "create/{id}")
    public ModelAndView createPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        ProjectColumn column = projectColumnService.getById(id);
        modelAndView.addObject("column", column);
        modelAndView.setViewName("task/TaskCreate");
        return modelAndView;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute TaskCreateDto taskCreateDto) {
        service.create(taskCreateDto);
        return "redirect:/board/project/%s".formatted(taskCreateDto.getProject_id());
    }

    @RequestMapping(value = "detail/{id}")
    public ModelAndView detail(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        TaskDto dto = service.getTask(id);
        List<ProjectColumn> projectColumns = projectColumnService.getColumnByProjectId(dto.getProject().getId());
        modelAndView.addObject("task", dto);
        modelAndView.addObject("columns", projectColumns);
        modelAndView.setViewName("task/TaskDetail");
        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id) {
        TaskDto task = service.getTask(id);
        service.delete(id);
        return "redirect:/board/project/%s".formatted(task.getProject().getId());
    }

    @RequestMapping(value = "status/change")
    public String updateStatus(@ModelAttribute TaskStatusUpdateDto taskStatusUpdateDto) {
        service.updateColumnId(taskStatusUpdateDto.getTask_id(), taskStatusUpdateDto.getColumn_id());
        TaskDto task = service.getTask(taskStatusUpdateDto.getTask_id());
        return "redirect:/board/project/%s".formatted(task.getProject().getId());
    }

    @RequestMapping(value = "level/change")
    public String updateLevel(@ModelAttribute TaskLevelUpdateDto taskLevelUpdateDto) {
        service.updateLevel(taskLevelUpdateDto.getTask_id(), taskLevelUpdateDto.getLevel());
        TaskDto task = service.getTask(taskLevelUpdateDto.getTask_id());
        return "redirect:/board/project/%s".formatted(task.getProject().getId());
    }

    @RequestMapping(value = "closed/change/{id}")
    public String updateClosed(@PathVariable Long id) {
        TaskDto task = service.getTask(id);
        return "redirect:/board/project/%s".formatted(task.getProject().getId());
    }
}
