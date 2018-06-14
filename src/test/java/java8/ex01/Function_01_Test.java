package java8.ex01;

import java8.data.Account;
import java8.data.Person;
import org.junit.Test;

import java.util.function.Function;


/**
 * Exercice 01 - java.util.function.Function
 */
public class Function_01_Test {

    /******** PART 1 - Integer -> Person *******/

    // tag::intToPerson[]
    private Function<Integer, Person> intToPerson = i -> new Person("first_"+i, "last_"+i, i, "pass_"+i);
    // end::intToPerson[]

    @Test
    public void test_intToPerson() throws Exception {

        Person result = this.intToPerson.apply(10);

        
        assert result.getFirstname().equals("first_10");
        assert result.getLastname().equals("last_10");
        assert result.getAge().equals(10);
        assert result.getPassword().equals("pass_10");
    }

    /******** PART 2 - Person -> Account *******/

    // tag::personToAccount[]
    private Function<Person, Account> personToAccount = p -> new Account(p);
    // end::personToAccount[]

    @Test
    public void test_personToAccount() throws Exception {

        Person person = new Person("Jules", "France", 10, "pass");

        Account result = this.personToAccount.apply(person);

        assert result.getOwner().equals(person);
        assert result.getBalance().equals(1000);
    }


    /******** PART 3 - Integer -> Account avec compose *******/

    // tag::intToAccountWithCompose[]
    private Function<Integer, Account> intToAccountWithCompose = personToAccount.compose(intToPerson);
    // end::intToAccountWithCompose[]


    @Test
    public void test_intToAccount_with_Compose() throws Exception {

        Account result = intToAccountWithCompose.apply(10);

        assert result.getOwner().getFirstname().equals("first_10");
        assert result.getBalance().equals(1000);
    }

    /******** PART 4 - Integer -> Account avec andThen *******/

    // tag::intToAccountWithAndThen[]
    private Function<Integer, Account> intToAccountWithAndThen = intToPerson.andThen(personToAccount);
    // end::intToAccountWithAndThen[]

    @Test
    public void test_intToAccount_with_AndThen() throws Exception {

        Account result = intToAccountWithAndThen.apply(11);

        assert result.getOwner().getFirstname().equals("first_11");
        assert result.getBalance().equals(1000);
    }
}
