package au.com.mir

import au.com.mir.engine.TaxEngine
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object TransactionIntegrationTest: Spek({
    describe("the TaxEngine"){
        it("should take a customer, tax type and filePath as arguments and return the calculated tax") {
            // GIVEN
            val taxType = "GST"
            val customer = 123
            val filePath = "./src/test/resources/short_sample.csv"

            val expectedResult = "For tax GST, customer 123 has declared $6.00"

            // WHEN
            val result = TaxEngine.execute(customer, taxType, filePath)

            // THEN
            assertEquals(expectedResult, result)
        }
    }
})
