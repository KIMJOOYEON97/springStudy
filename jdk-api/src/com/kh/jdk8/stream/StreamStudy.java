package com.kh.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class StreamStudy {
	
	public static void main(String[] args) {
		StreamStudy study = new StreamStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
//		study.test5();
//		study.test6();
//		study.test7();
//		study.test8();
//		study.test9();
	}
	
	/**
	 * reduce
	 * 스트림의 요소로 연산처리후 하나의 결과값을 리턴
	 * 
	 * BinaryOperator : 매개변수 2개와 리턴값의 자료형이 같은 Function
	 * (UnaryOperator)
	 * 
	 */
	public void test9() {
		Integer result =
			Arrays
				.asList(1,2,3,4,5,6,7,8,9,10)
				.stream()
				.reduce(0, (sum,n) ->{
					System.out.println("sum = "+sum+",n ="+n);
					return sum + n;
				}); //reduce(Integer identity, BinaryOperator<Integer> accumulator)
					//       초기값(시작값)
//		System.out.println("result = "+ result);
		
		result =
				Arrays
					.asList(1,2,3,4,5,6,7,8,9,10)
					.stream()
					.reduce(0, (max, n) -> max > n? max:n);
//		System.out.println("max ="+result);
		
		List<Person> list = Arrays.asList(
				new Person("홍길동",35),
				new Person("신사임당",40),
				new Person("세종",45),
				new Person("홍난파",80),
				new Person("전달력",69)
			);
				
				
		Person maxAgePerson =
			list.stream()
				.reduce((p1,p2) -> p1.age >p2.age ? p1:p2) 
				.get();
		//reduce(BinaryOperator<Person> accumulator)
		//Optional<Person>을 리턴
		System.out.println(maxAgePerson);
		
		Person person =
			list.stream()
				.reduce(new Person("",0), (identity,p) ->{
					identity.age += p.age;
					identity.name += p.name;
					return identity;
				});
		System.out.println(person); //누적적립 StreamStudy.Person(name=홍길동신사임당세종홍난파전달력, age=269)
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	static class Person{
		private String name;
		private int age;
		
	}
	
	
	/**
	 * 구구단
	 */
	public void test8() {
		IntStream
			.range(2, 10) //2부터 9까지
			.forEach(dan -> {
				IntStream.range(1, 10)
						 .forEach(n -> {
							 System.out.println(dan +"*"+n+"="+(dan*n));
							 if(n == 9) System.out.println();
						 });
			});
		
	}
	
	/**
	 * 기본형 stream
	 * - IntStream
	 * - LongStream
	 * - DoubleStream
	 * 
	 */
	public void test7(){
		int[] arr = {1,2,3};
		IntStream intStream = Arrays.stream(arr);
		
		DoubleStream doubleStream = DoubleStream.of(1.1,2.3,4.56);
		doubleStream.forEach(System.out::println);
		
		//range | rangeClosed
		IntStream
			.range(1, 10) //시작하는 숫자 포함 끝나는 숫자는 포함X 1~9가 된다
			.forEach(System.out::println);
		
		IntStream
			.rangeClosed(1, 10) //시작하는 숫자 포함 끝나는 숫자는 포함 1~10가 된다
			.forEach(System.out::println);
		int sum =
			IntStream
				.rangeClosed(1, 10)
				.sum(); //숫자들의 합 리턴
		System.out.println(sum); //55
		
		double avg=
			IntStream
				.rangeClosed(1, 100)
				.average() // OptionalDouble 리턴
				.getAsDouble();
		System.out.println(avg); //50.5
		
		IntSummaryStatistics summary =
			IntStream
				.of(32, 50, 80, 77, 100, 27, 88)
				.summaryStatistics();
		System.out.println(summary);
		//IntSummaryStatistics{count=7, sum=454, min=27, average=64.857143, max=100}
		System.out.println(summary.getCount()); //7
		
	}
	
	/**
	 * anyMatch 스트림의 요소중 Predicate결과가 하나라도 true이면 true 리턴
	 *  
	 * noneMatch 스트림의 요소 모두가 Predicate에 만족하지 않으면 true 리턴
	 */
	public void test6() {
		boolean bool =
		Arrays
			.asList("a1","b2","c","d4","5")
			.stream()
			.anyMatch(s -> s.startsWith("a")); //리턴형 불린
		System.out.println(bool);	//true
		
		bool =
			Arrays
				.asList("홍길동","123a","가나다") //자바스크립트와 자바에서의 정규식은 차이가 있다.
				.stream() 		//자바에서 정규표현식할때 주의할 것  .=> 0개 이상
				.noneMatch(s -> Pattern.matches(".[0-9].", s));
		System.out.println("nonMatch = " + bool);
		
		System.out.println("-----");
		System.out.println(Pattern.matches("[0-9]", "1a"));
	}
	
	/**
	 * collect
	 */	
	private void test5() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,4,3,2,1);
		List<Double> result1 =
					list.stream()
						.map(n -> Math.pow(n,2))
						.collect(Collectors.toList());
		System.out.println(result1);
		
		Set<Integer> result2 =
						list.stream()
						.filter(n -> n % 2==0)
						.collect(Collectors.toSet());
		System.out.println(result2);
		
		Map<Integer, String> result3 =
						list.stream()
						.distinct()
							.collect(Collectors.toMap(
										n -> n, 
										n -> n+""+n+""+n
									));
		System.out.println(result3);
		
	}


	/**
	 * stream 처리과정
	 * 1. collection, array로부터 stream생성
	 * 2. 중간연산	Intermediate Operations : peek, filter, map 요소에 대한 중간 작업
	 * 3. 단말연산 Terminal Operations : forEach, collect
	 * 
	 * 최종단말연산 전까지는 중간연산을 완료하지 않는 특징이 있다.
	 *	단말연산이 있어야 중간연산이 실행된다.
	 * 
	 * peek -> stream 과정 중간 확인용
	 */
	
	private void test4() {
		Arrays
			.asList(1,2,3,4,5,6,7,8,9,10)
			.stream()
			.peek(n -> System.out.println("2의 배수인가? : "+n))
			.filter(n -> n%2 == 0)
			.peek(n -> System.out.println("4의 배수인가? : "+n))
			.filter(n -> n%4 == 0)
			.forEach(System.out::println);
	}


	/**
	 * map
	 * a -> b
	 * 
	 * stream은 읽기전용을 생성된다.
	 */
	private void test3() {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		list.stream()
			.map(n -> n*10)
			.forEach(System.out::println);
		
		List<Integer> another = list.stream()
									.map(n -> n*10)
									.collect(Collectors.toList());
			
		
		System.out.println("list = "+list);
		System.out.println("another = "+another);
		
		Stream
			.of("홍길동","신사임당","세종") 
			.map(str -> str.length()) //배열의 map
			.forEach(System.out::println);
		
		//요소의 공백을 모두 제거하고, List<String>으로 반환
		String[] wordArr = {"a b c d","홍 길동","hello world"};
		List<String> wordList =	
		Arrays
			  .stream(wordArr)
			  .map(s -> s.replaceAll(" ", ""))
			  .collect(Collectors.toList());
		System.out.println("wordList ="+wordList);
		
	}
	
	
	/**
	 * distinct
	 * filter
	 */
	private void test2() {
		List<Integer> list= Arrays.asList(5,1,2,3,3,3,4,2,1,1,2,4,5);
		Stream<Integer> stream = list.stream();
		stream
			.distinct()
		  /*1
			2
			3
			4
			5
			*/
			.filter(n -> n%2 != 0) //Predicate<? super Integer> predicate
			.sorted()	
			.forEach(n -> System.out.println(n));
			//forEach는 void를 리턴(마지막에 호출해야할 메소드가 됌 중간에 들어가면 오류남)
		
		String[] names = {"강감찬","강원래","홍길동","강형욱"};
//		Stream<String> stringStream = Arrays.stream(names);
		Arrays
					.stream(names)
//					.filter(s -> s.indexOf("강")==0)
					.filter(s -> s.startsWith("강"))
					.sorted()
					.forEach(s -> System.out.println(s));
		
	}


	/**
	 * stream
	 * 배열이나 컬렉션등을 일관되게 제어하려는 추상화 객체
	 * 
	 */
	private void test1() {
		int[] arr = {3,1,4,5,2};

		IntStream arrStream = Arrays.stream(arr);
//		arrStream.forEach(n -> System.out.println(n));
		arrStream
			.sorted()
			.forEach(System.out::println);
		
		List<String> list = new ArrayList<>();
		list.add("홍현희");
		list.add("홍길동");
		list.add("홍진경");
		list.add("홍난파");
		
		Stream<String> listStream = list.stream(); //stream 객체가 됌
		listStream
			.sorted()
			.forEach(System.out::println);
		
		//public static<T> Stream<T> of(T... values)
		Stream<Double> doubleStream = Stream.of(0.1,1.2,3.456);
		
		
	}
	
}
