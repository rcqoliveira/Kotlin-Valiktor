import domain.Employee
import org.junit.jupiter.api.Test
import org.valiktor.ConstraintViolationException
import service.EmployeeService
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class EmployeeServiceTest {

    @Test
    fun givenInvalidParameterName_thenThrowsConstraintViolationException()   {

        //Given
        var employee = Employee(id = -1, name = "Ro", email = "Roberto@yahoo.com", salary = 9999.99)

        //When

        //Then
        assertFailsWith<ConstraintViolationException> { EmployeeService().save(employee) }

    }

    @Test
    fun givenInvalidParameterEmail_thenThrowsConstraintViolationException()   {

        //Given
        var employee = Employee(id = -1, name = "Robert", email = "Roberto.com", salary = 9999.99)

        //When

        //Then
        assertFailsWith<ConstraintViolationException> { EmployeeService().save(employee) }

    }

    @Test
    fun givenInvalidParameterSalary_thenThrowsConstraintViolationException()   {

        //Given
        var employee = Employee(id = -1, name = "Robert", email = "Robert@yahoo.com", salary = 9999.999)

        //When

        //Then
        assertFailsWith<ConstraintViolationException> { EmployeeService().save(employee) }

    }

    @Test
    fun givenAllParametersValid_thenNotThrowsConstraintViolationException()   {

        //Given
        var employee = Employee(id = -1, name = "Robert", email = "Robert@yahoo.com", salary = 9999.99)

        //When
        var result = EmployeeService().save(employee);

        //Then
        assertTrue { result.id == 10 }

    }

}