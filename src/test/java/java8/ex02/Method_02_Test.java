package java8.ex02;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();
        
        default int countPersons() {
			int counter = 0;
			for(Person p : findAll()) {
				counter++;
			}
			return counter;
		}
        
        default String format() {
        	StringBuilder stringBuilder = new StringBuilder();
        	stringBuilder.append("[").append(countPersons()).append("persons]");
			return stringBuilder.toString();
        }
    }
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }
        
        
        @Override
        public String format() {
        	StringBuilder stringBuilder = new StringBuilder();
        	stringBuilder.append(this.getClass().getName()).append(IDao.super.format());
			return null;
        }

    }
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();

        String result = null;
        result = daoA.format();

        "DaoA[20 persons]".equals(result);
    }
}
