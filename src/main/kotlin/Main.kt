import domain.Employee
import service.EmployeeService

fun main() {

    var employee = Employee(
        id = -1,
        name = "Roberto",
        email = "Robert@yahoo.com",
        salary = 9999.99
    )

    println(EmployeeService().save(employee))
}