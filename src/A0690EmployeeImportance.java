import java.util.List;

public class A0690EmployeeImportance {
    int sum = 0;
    public int getImportance(List<Employee> employees, int id) {
        Employee[] e = new Employee[2001];
        for (Employee employee : employees) {
            e[employee.id]=employee;
        }
        f(e[id],e);
        return sum;
    }

    private void f(Employee employee,Employee[] e){
        sum+=employee.importance;
        for (int i = 0; i < employee.subordinates.size(); i++) {
            f(e[employee.subordinates.get(i)],e);
        }
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
}
