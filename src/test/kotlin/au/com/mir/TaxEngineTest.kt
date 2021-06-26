package au.com.mir

import org.junit.jupiter.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class TaxEngineTest: Spek({
    describe("taxEngine") {
        it("should take in an array of arguments and calculate the total tax") {
            // GIVEN

            val expected = "For tax GST, customer 123 has declared \$6.000"
            // WHEN
            val result = TaxEngine.execute( 123, "GST", "./src/test/resources/short_sample.csv")

            // THEN
            assertEquals(expected, result)
        }
    }
})
