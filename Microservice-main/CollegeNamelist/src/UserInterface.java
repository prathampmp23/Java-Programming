import java.util.List;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		
		
		int choice;
		while(true) {
			System.out.println("1.Add");
			System.out.println("2.Display");
			System.out.println("3.Remove");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
				case 1:{
					System.out.println("Enter the student name");
					stu.addStudentToList(sc.next());
					break;
				}
				case 2: {
					List<String> stuList = stu.getStudentList();
					if(stuList.size() == 0) {
						System.out.println("The student list is empty");
						break;
					}
					stu.sortStudentList();
					stuList.forEach(n -> System.out.println(n));
					break;
				}
				case 3: {
					List<String> stuList = stu.getStudentList();
					if(stuList.size() == 0) {
						System.out.println("The student list is empty");
						break;
					}
					System.out.println("Enter the student name");
					stu.removeStudentFromList(sc.next());
					break;
				}
				case 4: {
					System.out.println("Thank you for using the application");
					sc.close();
					return;
				} 
			}
		}
	}

}
