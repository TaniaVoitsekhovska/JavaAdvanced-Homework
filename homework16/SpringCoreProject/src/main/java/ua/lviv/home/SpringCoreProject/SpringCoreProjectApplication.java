package ua.lviv.home.SpringCoreProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.lviv.home.SpringCoreProject.dao.StudentDao;
import ua.lviv.home.SpringCoreProject.entity.Student;

@SpringBootApplication
public class SpringCoreProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringCoreProjectApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(SpringCoreProjectApplication.class, args);

		StudentDao studentDao = (StudentDao) context.getBean("student");

		studentDao.create(new Student(1,"John", 18));
		studentDao.create(new Student(25,"Andrew", 34));
		studentDao.create(new Student(33,"Olia", 25));
		studentDao.create(new Student(2,"Mathew", 53));
		studentDao.readAll().stream().forEach(System.out::println);
		System.out.println();

		studentDao.update(1, new Student("Ira", 20));
		System.out.println("After updating:");
		studentDao.readAll().stream().forEach(System.out::println);
		System.out.println();

		System.out.println(studentDao.readById(2));
		System.out.println();

		studentDao.delete(33);
		System.out.println("After deleting student:");
		studentDao.readAll().stream().forEach(System.out::println);

		System.out.println(studentDao.readById(22));
	}
}
