import java.time.LocalTime;
import java.util.Calendar;
import java.util.stream.Stream;

public class codingTest{
	
	public static void main(String[] args) {
		
		System.out.println(Stream.of("green", "yellow", "blue").max((s1,s2)->s1.compareTo(s2)).filter(s->s.endsWith("n")).orElse("yellow"));
		
		int x =5, y =0;
		
		try {
			try {
				System.out.println(x/y);
			}
			catch (ArithmeticException ex) {
				System.out.println("innerCatch1");
			}
			catch(RuntimeException ex) {
				System.out.println("innerCatch2");
			}
			finally {
				System.out.println("innerCatch3");
			}
		}
		catch(Exception ex) {
			System.out.println("innerCatch5");
		}
		
		System.out.println(String.format("Local time: %1$tB", Calendar.getInstance()));
		System.out.println(String.format("Local time: %tT", Calendar.getInstance()));
		System.out.println(String.format("Local time: %tH:%tM:%tS", LocalTime.now(),LocalTime.now(),LocalTime.now()));
		System.out.println(String.format("Local time: %tT", LocalTime.now()));
	}
	
}