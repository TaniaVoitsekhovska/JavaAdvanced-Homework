package ua.lviv.home.SpringDataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        UniversityService universityService = (UniversityService) applicationContext.getBean("universityService");

        University u1 = new University("Європейський університет (ЄУ)", 4,
                7, 25000, "м.Київ, бульвар Академіка Вернадського, 16-В ");
        University u2 = new University("ДВНЗ Ужгородський національний університет(УжНУ)", 4,
                20, 14300, "Закарпатська обл., м.Ужгород, вул. Підгірна, 46");
        University u3 = new University("Київський університет культури", 3,
                8, 9500, "м.Київ, вул. Коновальця, 36");
        University u4 = new University("Львівський національний університет ім. Франка (ЛНУ)",
                4, 11, 31000, "м.Львів, вул. Університетська 1 ");
        University u5 = new University("Національний університет «Львівська політехніка» (НУ «ЛП»)",
                4, 21, 35000, "м.Львів, вул. С. Бандери, 12 ");

        List<University> universities = Arrays.asList(u1, u2, u3, u4, u5);

        universityService.saveAll(universities);
        System.out.println();
        List<University> universityList = universityService.findAll();

        universityList.stream().forEach(System.out::println);
        System.out.println();

        Optional<University> universityById = universityService.findById(4);
        System.out.println(universityById);

        Optional<University> universityByName =
                universityService.findByName("Львівський національний університет ім. Франка (ЛНУ)");
        System.out.println(universityByName);

        System.out.println();

        universityService.deleteById(2);
        List<University> afterDeletingList = universityService.findAll();
        afterDeletingList.stream().forEach(System.out::println);
        System.out.println();

        UniversityDTO universityDTO = universityService.getNameAndAddressById(1);
        System.out.println(String.format("University %s,located %s", universityDTO.getName(),
                universityDTO.getAddress()));

        List<UniversityDTO> list = universityService.findByAmountOfStudentsWhereMoreThan(30000);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            UniversityDTO uDTO = (UniversityDTO) iterator.next();
            System.out.println(String.format("University %s,id = %d,located %s with amount of students = %d",
                    uDTO.getName(), uDTO.getId(), uDTO.getAddress(),uDTO.getStudents()));
        }

        universityService.updateNameById(5,"Some university");
        List<University> afterUpdate = universityService.findAll();
        afterUpdate.stream().forEach(System.out::println);
    }

}


