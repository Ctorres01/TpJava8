package java8.ex04;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Exercice 4 - java.util.function.Predicate
 */
public class Function_04_Test {

    // tag::filterMethod[]
    <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T el : list) {
            if (predicate.test(el)) {
                result.add(el);
            }
        }
        return result;
    }
    // end::filterMethod[]

    // PART 1 - ADULT

    // tag::adult[]
    Predicate<Person> adult = p -> p.getAge()>=18;
    // end::adult[]

    @Test
    public void test_predicate() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode filter pour que le test soit passant
        List<Person> result  = new ArrayList<Person>();
        for(Person p : personList) {
        	if(adult.test(p)) {
        		result.add(p);
        	}
        }

        assert result.size() == 4;

    }

    // PART 2 - ADULT AND LASTNAME=France AND FIRSTNAME=Armor

    // tag::predicateand[]
    Predicate<Person> lastnameIsFrance = p -> p.getLastname().equals("France");
    Predicate<Person> firstnameIsArmor = p -> p.getFirstname().equals("Armor");
    // end::predicateand[]

    @Test
    public void test_predicate_and() throws Exception {

        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode filter pour que le test soit passant
        // TODO chaîner les prédicats adult, lastnameIsFrance et firstnameIsArmor avec la méthode and
        List<Person> result = new ArrayList<Person>();
        for(Person p : personList) {
        	if(adult.and(firstnameIsArmor).and(lastnameIsFrance).test(p)) {
        		result.add(p);
        	}
        }
        		
        assert result.size() == 1;
        assert result.get(0).getFirstname().equals("Armor");
        assert result.get(0).getLastname().equals("France");
        assert result.get(0).getAge().equals(25);

    }
}
