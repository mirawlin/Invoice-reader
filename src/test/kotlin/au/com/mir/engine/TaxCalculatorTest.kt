package au.com.mir.engine

import au.com.mir.model.TaxInvoice
import au.com.mir.model.TaxType
import org.junit.jupiter.api.Assertions.*
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal
import java.time.LocalDateTime

class TaxCalculatorTest: Spek({
  describe("getCustomerAndTaxRecords") {
      it("should filter a list of CSV records for matching Customer and Tax Type") {
          // GIVEN
          val customer = 123
          val taxType = "GST"

          val invoice1 = TaxInvoice(
              customerId = 123,
              commercialInvoiceNumber = "InvoiceNumber/555",
              timestamp = LocalDateTime.of(2021,2,15,2,1,1),
              amount = BigDecimal.TEN,
              taxType = TaxType.GST
          )

          val invoice2 = TaxInvoice(
              customerId = 123,
              commercialInvoiceNumber = "InvoiceNumber/444",
              timestamp = LocalDateTime.of(2021,2,15,2,1,1),
              amount = BigDecimal.valueOf(50L),
              taxType = TaxType.GST
          )

          val listOfInvoices = listOf(invoice1, invoice2)

          // WHEN
          val result = TaxCalculator.getInvoiceAmounts(listOfInvoices, customer, taxType)
          println(result)

          // THEN
          assertEquals(2, result.size)
          assertEquals(BigDecimal.valueOf(10), result[0])
          assertEquals(BigDecimal.valueOf(50), result[1])
      }
  }

    describe("calculateTotalTax") {
        it("should sum up all the values and calculate the 10% value") {
            // GIVEN
            val amounts = listOf(10.00.toBigDecimal(),50.00.toBigDecimal())

            // WHEN
            val result = TaxCalculator.calculateTotalTax(amounts)

            // THEN
            assertTrue(BigDecimal.valueOf(6.00).compareTo(result) == 0)
        }
    }
})
