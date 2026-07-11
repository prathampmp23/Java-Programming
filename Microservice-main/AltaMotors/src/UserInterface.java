import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of details");
		int n = Integer.parseInt(sc.next());
		sc.nextLine();
		
        if (n <= 0) {
            System.out.println(n + " is an invalid input");
            sc.close();
            return;
        }
	
		DepartmentGrouping dg = new DepartmentGrouping();

		System.out.println("Enter the details");
		for (int i = 1; i <= n; i++) {
			dg.addEmployeeId(sc.nextLine());
		}
		HashSet<String> empInfo = dg.findDepartmentNameWithEmployeeId();
		if(empInfo.size() == 0) {
			System.out.println("All the provided employee ids are invalid");
			sc.close();
			return;
		}
		for(String emp : empInfo) {
			System.out.println(emp);
		}
		sc.close();
	}
}