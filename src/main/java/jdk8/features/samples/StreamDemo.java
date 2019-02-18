package jdk8.features.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class StreamDemo {

	public static void main(String[] args){
		List<Person> list =
		Arrays.asList(new Person("john", "kothrud", "pune", 123),
				      new Person("ram", "jd road", "moline", 456),
				      new Person("person", "kothrud", "pune", 5555),
				      new Person("testperson", "jd road","moline", 4444));

		// filter list of persons whose salary is greater than 1000
		List<Person> listOfPersonSalaryGreater1000 = list.stream().filter(p->p.getSalary() > 1000).collect(Collectors.toList());

		// filter list of persons staying in particular city
		List<Person> listOfPersonStayingInPune = list.stream().filter(p->p.getCity().equalsIgnoreCase("pune")).collect(Collectors.toList());

		// map, IntStream, sum and average
		IntStream intStream = list.stream().mapToInt(e-> e.getSalary());
		System.out.println(intStream.sum());
		int sumOfSalary = list.stream().mapToInt(e->e.getSalary()).sum();
		OptionalDouble optionalAverageOfSalary = list.stream().mapToInt(e->e.getSalary()).average();
		// optional no null checks required. check for isPresent and then call get() method to get data
		if(optionalAverageOfSalary.isPresent()){
			System.out.println(optionalAverageOfSalary.getAsDouble());
		}

		// peek for debuging
		List<Person> listOfPersonUsingPeek = list.stream().filter(p->p.getSalary() > 1000).peek(p->System.out.println(p.getName())).collect(Collectors.toList());

		// stream count
		boolean isAnyPersonInCityPune= list.stream().anyMatch(p->p.getCity().equals("pune"));
		boolean isAllPersonInCityPune = list.stream().allMatch(p->p.getCity().equals("pune"));

		// foreach terminal operator
		list.stream().mapToInt(p->p.getSalary()).forEach(s->System.out.println(s));

		// reduce operation
		int sumOfSalaryOfAllPerson = list.stream().mapToInt(p->p.getSalary()).reduce(0, (a,b)->a+b);

		// sorted based on natural order or comparable
		List<Person> sortedList = list.stream().sorted().collect(Collectors.toList());
		sortedList.stream().forEach(p-> System.out.println(p));

		// sorting based on comparator
		
		Comparator<Person> personComparator = (first, second)->{
																	int result = 0;
																	if(first.getSalary() == second.getSalary() ){
																		result = 0;
																	} else {
																		if(first.getSalary() > second.getSalary()){
																			result = 1;
																		} else { result = -1;
																		}
																	}
																	return result;
																};
																
		List<Person> sortedListUsingComparator = list.stream().sorted(personComparator).collect(Collectors.toList());
		sortedListUsingComparator.stream().forEach(p-> System.out.println(p));


		//collect method takes supplier, biconsumer (accumulator) and biconsumer (combiner)
		ArrayList<Person> arrayListPerson = list.stream().collect(ArrayList<Person>::new, ArrayList::add, ArrayList::addAll);
		Supplier<ArrayList<Person>> supplier1 =  ()-> new ArrayList<Person>(); // supplier lambda expression
		BiConsumer<ArrayList<Person>, Person> biconsumerAccumulator = (list1, p)-> list1.add(p); // biconsumer add
		BiConsumer<ArrayList<Person>, ArrayList<Person>> biconsumerCombiner = (list1, list2)->list1.addAll(list2);


		// collectors map and joining
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(p->p.getName(), p->p.getSalary()));
		String str = list.stream().map(p->p.getName()).collect(Collectors.joining(","));
		System.out.println(str);

		// collectors groupingby
		Map<String, List<Person>> mapPersonByCity = list.stream().collect(Collectors.groupingBy(p->p.getCity()));
		Set<Entry<String, List<Person>>> setOfEntry =  mapPersonByCity.entrySet();
		for(Entry<String, List<Person>>  entry : setOfEntry){
			String key = entry.getKey();
			List<Person> listOfPerson = entry.getValue();
			System.out.println("Key " + key);
			System.out.println("Values " );
			listOfPerson.stream().forEach(p->System.out.println(p));
		}

		// map foreach method
		mapPersonByCity.forEach((key, personList)->{
			System.out.println("key " + key);
			personList.stream().forEach(p->System.out.println(p));
		});

	};
}
