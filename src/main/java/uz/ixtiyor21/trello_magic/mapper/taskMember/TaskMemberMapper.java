package uz.ixtiyor21.trello_magic.mapper.taskMember;

import org.springframework.stereotype.Component;
import uz.ixtiyor21.trello_magic.dto.taskMember.TaskMemberCreateDto;
import uz.ixtiyor21.trello_magic.dto.taskMember.TaskMemberDto;
import uz.ixtiyor21.trello_magic.dto.taskMember.TaskMemberUpdateDto;
import uz.ixtiyor21.trello_magic.entity.task.TaskMember;
import uz.ixtiyor21.trello_magic.mapper.BaseMapper;

import java.util.List;

@Component
public class TaskMemberMapper implements BaseMapper<TaskMember, TaskMemberDto, TaskMemberCreateDto, TaskMemberUpdateDto> {
    @Override
    public TaskMemberDto toDto(TaskMember taskMember) {
        return null;
    }

    @Override
    public List<TaskMemberDto> toDto(List<TaskMember> e) {
        return null;
    }

    @Override
    public TaskMember fromCreateDto(TaskMemberCreateDto taskMemberCreateDto) {
        return null;
    }

    @Override
    public TaskMember fromUpdateDto(TaskMemberUpdateDto taskMemberUpdateDto) {
        return null;
    }
}
