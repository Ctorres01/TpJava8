package java8.ex03;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 03 - Méthode statique
 */
public class Method_03_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();
        
        static IDao getDefaultInstance() {
			return new Method_03_Test.DaoA();
        }

    }
    // end::IDao[]

    static class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

    }

    @Test
    public void test_getDefaultInstance() throws Exception {
        IDao result = IDao.getDefaultInstance();

        assert result.findAll().size() == 20;
    }
}
