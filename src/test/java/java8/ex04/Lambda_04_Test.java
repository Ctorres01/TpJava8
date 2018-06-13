package java8.ex04;


import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Exercice 04 - FuncCollection
 * Exercice synthèse des exercices précédents
 */
public class Lambda_04_Test {

    // tag::interfaces[]
    interface GenericPredicate<T> {
        boolean test(T t);
    }

    interface GenericMapper<T, E> {
        E map(T t);
    }

    interface Processor<T> {
        void process(T t);
    }
    // end::interfaces[]

    // tag::FuncCollection[]
    class FuncCollection<T> {

        private Collection<T> list = new ArrayList<>();

        public void add(T t) {
            list.add(t);
        }

        public void addAll(Collection<T> all) {
            for(T el:all) {
                list.add(el);
            }
        }
    // end::FuncCollection[]

        // tag::methods[]
        private FuncCollection<T> filter(GenericPredicate<T> predicate) {
            FuncCollection<T> result = new FuncCollection<>();
            this.forEach(p -> {
    			if(predicate.test(p)) {
    				result.add(p);
    			}
    		});
            return result;
        }

        private <E> FuncCollection<E> map(GenericMapper<T, E> mapper) {
            FuncCollection<E> result = new FuncCollection<>();
            for(T t : this.list) {
            	result.add(mapper.map(t));
            }
            return result;
        }

        private void forEach(Processor<T> processor) {
           for(T t : this.list) {
        	   processor.process(t);
           }
        }
        // end::methods[]

    }



    // tag::test_filter_map_forEach[]
    @Test
    public void test_filter_map_forEach() throws Exception {

        List<Person> personList = Data.buildPersonList(100);
        FuncCollection<Person> personFuncCollection = new FuncCollection<>();
        personFuncCollection.addAll(personList);

        personFuncCollection
                .filter(t -> t.getAge()>50)
                .map(t -> new Account(t, 1000))
                .forEach(t -> {
                	assert(t.getBalance() == 1000);
                	assert(t.getOwner().getAge()>50);
                });
    }
    // end::test_filter_map_forEach[]

    // tag::test_filter_map_forEach_with_vars[]
    @Test
    public void test_filter_map_forEach_with_vars() throws Exception {

        List<Person> personList = Data.buildPersonList(100);
        FuncCollection<Person> personFuncCollection = new FuncCollection<>();
        personFuncCollection.addAll(personList);

        GenericPredicate<Person> filterByAge = t -> t.getAge()>50;
        GenericMapper<Person, Account> mapToAccount = t -> new Account(t, 1000);
        Processor<Account> verifyAccount = t -> {
        	assert(t.getBalance() == 1000);
        	assert(t.getOwner().getAge() > 50);
        };

        personFuncCollection
                .filter(filterByAge)
                .map(mapToAccount)
                .forEach(verifyAccount);
    }
    // end::test_filter_map_forEach_with_vars[]


}
