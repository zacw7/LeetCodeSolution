/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap();
        for (Employee e : employees) {
            employeeMap.put(e.id, e);
        }
        Queue<Employee> employeeQ = new LinkedList();
        if (employeeMap.get(id) != null) employeeQ.add(employeeMap.get(id));
        int sum = 0;
        while (!employeeQ.isEmpty()) {
            Employee curEmployee = employeeQ.poll();
            sum += curEmployee.importance;
            for (int eid : curEmployee.subordinates) {
                employeeQ.add(employeeMap.get(eid));
            }
        }
        return sum;
    }
}