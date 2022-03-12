package uz.ixtiyor21.trello_magic.service.taskMember;

import org.springframework.stereotype.Service;
import uz.ixtiyor21.trello_magic.mapper.taskMember.TaskMemberMapper;
import uz.ixtiyor21.trello_magic.repository.taskMember.TaskMemberRepository;
import uz.ixtiyor21.trello_magic.service.AbstractService;
import uz.ixtiyor21.trello_magic.utils.BaseUtils;
import uz.ixtiyor21.trello_magic.validator.taskMember.TaskMemberValidator;

/**
 * Author : Qozoqboyev Ixtiyor
 * Time : 12.03.2022 9:44
 * Project : Trello_magic
 */
@Service
public class TaskMemberService extends AbstractService<TaskMemberRepository, TaskMemberMapper, TaskMemberValidator> {

    protected TaskMemberService(TaskMemberRepository repository, TaskMemberMapper mapper, TaskMemberValidator validator, BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }
}
