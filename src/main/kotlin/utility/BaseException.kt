package utility

import org.valiktor.ConstraintViolationException
import org.valiktor.i18n.toMessage
import model.ErrorResponse

open class BaseException {

    fun ConstraintViolationException.validateDomain()
    {
        var items: MutableList<ErrorResponse> = mutableListOf()

        this.constraintViolations
            .forEach { items.add(ErrorResponse(it.property, it.toMessage().message)) }

        items.forEach(::println)
//        return  items
    }

}