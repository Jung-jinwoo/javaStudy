package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setGrade(1);
		s1.setMajor("cs");
		
		Person p1 = s1; // up casting(암시적으로 캐스팅됨, Implicity)
		p1.setName("둘라");
		
		//Student s2 = (Student)p1; // down casting(명시적으로 캐스팅필요, explicity)
		((Student)p1).setMajor("cs");
		
		
	}
}
