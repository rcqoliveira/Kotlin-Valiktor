package service

import domain.Employee
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.*
import org.valiktor.validate
import utility.BaseException

class EmployeeService : BaseException() {

    fun save() {
        var employee = Employee(
            id = -1,
            name = "Ro",
            email = "Robert@yahoo.com",
            salary = 9999.99
        )

        try {
            validate(employee) {
                validate(Employee::id).isNotNull()
                validate(Employee::name).hasSize(min = 3, max = 30)
                validate(Employee::email).isNotBlank().isEmail()
                validate(Employee::salary).hasDecimalDigits(max = 2)
            }
            println("Save success!!!")

        } catch (ex: ConstraintViolationException) {
            ex.validateDomain();
            println("Error at validation!!!")
        }
    }
}