    package uz.ixtiyor21.trello_magic.config;

    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.Transaction;
    import uz.ixtiyor21.trello_magic.entity.auth.AuthUser;
    import uz.ixtiyor21.trello_magic.entity.org.Organization;
    import uz.ixtiyor21.trello_magic.entity.project.Project;
    import uz.ixtiyor21.trello_magic.entity.project.ProjectColumn;
    import uz.ixtiyor21.trello_magic.entity.role.Role;
    import uz.ixtiyor21.trello_magic.entity.task.Task;
    import uz.ixtiyor21.trello_magic.enums.priority.Priority;
    import uz.ixtiyor21.trello_magic.enums.status.Status;
    import uz.ixtiyor21.trello_magic.utils.HibernateUtil;

    import java.time.Instant;

    public class Migrate {
       /* public static void main(String[] args) {
            SessionFactory sessionFactory = HibernateUtil.sessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            transaction.begin();

            Organization organization = new Organization();
            organization.setName("PdpAcademy");
            organization.setCode(String.valueOf(System.currentTimeMillis()));
            organization.setEmail("pdp@gmail.com");
            organization.setDescription("lorem bfhdsdbf ");
            organization.setStatus(String.valueOf(Status.ACTIVE));
            organization.setCreated_at(Instant.now());
            organization.setCreated_by(1L);
            session.save(organization);

            Role role = new Role();
            role.setName("Admin");
            role.setCode("ADMIN");
            role.setCreated_at(Instant.now());
            role.setCreated_by(-1L);
            session.save(role);

            AuthUser authUser = new AuthUser();
            authUser.setFirstName("Ixtiyor");
            authUser.setLastName("Qozoqboyev");
            authUser.setIs_SuperUser(false);
            authUser.setEmail("ixtiyorqozoqboyev@gmail.com");
            authUser.setLang("EN");
            authUser.setPassword(new PasswordEncoderConfigurer().passwordEncoder().encode("123"));
            authUser.setCode(String.valueOf(System.currentTimeMillis()));
            authUser.setUsername("ixtiyor21");
            authUser.setCreated_at(Instant.now());
            authUser.setCreated_by(-1L);
            session.save(authUser);

            Project project = new Project();
            project.setCode(String.valueOf(System.currentTimeMillis()));
            project.setName("Todo App");
            project.setClosed(false);
            project.setCreated_at(Instant.now());
            project.setCreated_by(2L);
            session.save(project);

            ProjectColumn projectColumn1 = new ProjectColumn();
            projectColumn1.setCode(String.valueOf(System.currentTimeMillis()));
            projectColumn1.setName("Todo");
            projectColumn1.setActive(true);
            projectColumn1.setCreated_at(Instant.now());
            projectColumn1.setCreated_by(-1L);
            session.save(projectColumn1);

            ProjectColumn projectColumn2 = new ProjectColumn();
            projectColumn2.setCode(String.valueOf(System.currentTimeMillis()));
            projectColumn2.setName("In Progress");
            projectColumn2.setActive(true);
            projectColumn2.setCreated_at(Instant.now());
            projectColumn2.setCreated_by(-1L);
            session.save(projectColumn2);

            ProjectColumn projectColumn3 = new ProjectColumn();
            projectColumn3.setCode(String.valueOf(System.currentTimeMillis()));
            projectColumn3.setName("Review");
            projectColumn3.setActive(true);
            projectColumn3.setCreated_at(Instant.now());
            projectColumn3.setCreated_by(-1L);
            session.save(projectColumn3);

            ProjectColumn projectColumn4 = new ProjectColumn();
            projectColumn4.setCode(String.valueOf(System.currentTimeMillis()));
            projectColumn4.setName("Done");
            projectColumn4.setActive(true);
            projectColumn4.setCreated_at(Instant.now());
            projectColumn4.setCreated_by(-1L);
            session.save(projectColumn4);


            Task task = new Task();
            task.setCompleted(false);
            task.setLevel(Priority.HIGH.getCode());
            task.setName("SEO System");
            task.setCreated_at(Instant.now());
            task.setCreated_by(-1L);
            task.setStatus(Status.ACTIVE.getCode());
            session.save(task);

            transaction.commit();
            session.close();
            sessionFactory.close();
        }*/
    }
