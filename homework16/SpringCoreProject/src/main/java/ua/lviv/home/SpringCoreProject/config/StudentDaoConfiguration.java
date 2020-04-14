package ua.lviv.home.SpringCoreProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.lviv.home.SpringCoreProject.dao.StudentDao;

@Configuration
public class StudentDaoConfiguration {

    @Bean(name = "student")
    StudentDao studentDao() {
        return new StudentDao();
    }
}
