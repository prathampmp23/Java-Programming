import java.util.HashSet;

public class DepartmentGrouping {
	public HashSet<String> employeeSet = new HashSet<String>();

	public HashSet<String> getEmployeeSet() {
		return employeeSet;
	}

	public void setEmployeeSet(HashSet<String> employeeSet) {
		this.employeeSet = employeeSet;
	}

	public void addEmployeeId(String details) {
		String info[] = details.split(":");
		if(info[0].length() != 4) return; 
		if(info[0].charAt(0) != 'P' && info[0].charAt(0) != 'Q' && info[0].charAt(0) != 'M' && info[0].charAt(0) != 'S') {
			return;
		} 
		for(int i=1; i<=3; i++) {
			if (!Character.isDigit(info[0].charAt(i))) return;
		}
		employeeSet.add(info[0]);
	}
	
	public HashSet<String> findDepartmentNameWithEmployeeId() {
		HashSet<String> depWithName = new HashSet<String>();
		for(String emp : employeeSet) {
			StringBuilder str = new StringBuilder();
			if(emp.charAt(0) == 'P') {
				str.append(emp);
				str.append(":");
				str.append("Product");
				depWithName.add(str.toString());
			}
			else if(emp.charAt(0) == 'Q') {
				str.append(emp);
				str.append(":");
				str.append("Quality Control");
				depWithName.add(str.toString());
			}
			else if(emp.charAt(0) == 'M') {
				str.append(emp);
				str.append(":");
				str.append("Maintenance");
				depWithName.add(str.toString());
			}
			else if(emp.charAt(0) == 'S') {
				str.append(emp);
				str.append(":");
				str.append("Sales");
				depWithName.add(str.toString());
			}
		}
		return depWithName;
	}
}