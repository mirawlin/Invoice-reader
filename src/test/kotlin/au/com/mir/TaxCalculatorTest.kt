package au.com.mir

import org.junit.jupiter.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal
import java.nio.file.Path
import java.nio.file.Paths

class TaxCalculatorTest: Spek({
  describe("getCustomerAndTaxRecords") {
      it("should filter a list of CSV records for matching Customer and Tax Type") {
          // GIVEN
          val customer = "123"
          val taxType = "GST"

          val currentRelativePath: Path = Paths.get("")
          val s = currentRelativePath.toAbsolutePath().toString()
          val filePath = "$s/src/test/resources/short_sample.csv"

          val csvRecords = Parser.readFile(filePath)

          // WHEN
          val result = TaxCalculator.getInvoiceAmounts(csvRecords, customer, taxType)
          println(result)

          // THEN
          assertEquals(2, result.size)
          assertEquals(BigDecimal.valueOf(10).setScale(2), result[0])
          assertEquals(BigDecimal.valueOf(50).setScale(2), result[1])
      }
  }

    describe("calculateTotalTax") {
        it("should sum up all the values and calculate the 10% value") {
            // GIVEN
            val amounts = listOf(BigDecimal.valueOf(10), BigDecimal.valueOf(50))

            // WHEN
            val result = TaxCalculator.calculateTotalTax(amounts)

            // THEN
            assertEquals(BigDecimal.valueOf(6.0), result)
        }
    }
})
