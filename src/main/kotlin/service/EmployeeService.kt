package service

import domain.Employee
import org.valiktor.ConstraintViolationException
import org.valiktor.functions.*
import org.valiktor.validate
import utility.BaseException

class EmployeeService : BaseException() {

    fun save(employee: Employee) : Employee {

        try {
            validate(employee) {
                validate(Employee::id).isNotNull()
                validate(Employee::name).hasSize(min = 3, max = 30)
                validate(Employee::email).isNotBlank().isEmail()
                validate(Employee::salary).hasDecimalDigits(max = 2)
            }

            employee.id = 10;

            return employee

        } catch (ex: ConstraintViolationException) {
            ex.validateDomain();
            throw ex
        }
    }
}