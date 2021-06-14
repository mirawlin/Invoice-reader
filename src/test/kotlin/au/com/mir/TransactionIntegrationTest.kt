package au.com.mir

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object TransactionIntegrationTest: Spek({
    describe("the main"){
        it("should take a customer and tax type as arguments, calculate the tax and print the results") {
            // GIVEN
            val input = "GST 123 short_sample.csv"

            // WHEN
            val result = main(arrayOf(input))

            // THEN
            assertEquals("For tax GST, customer 123 has declared \$1", result)
        }
    }

})
