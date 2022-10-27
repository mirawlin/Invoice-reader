package au.com.mir.model

import au.com.mir.io.Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.math.BigDecimal
import java.nio.file.Path
import java.nio.file.Paths
import java.time.LocalDateTime

object TaxInvoiceTest: Spek({
    describe("A csv record") {
        it("should be mapped to a Tax Invoice") {
            // Given
            val expected = TaxInvoice(
                customerId = 999,
                commercialInvoiceNumber = "2021/04/customer3-44444",
                timestamp = LocalDateTime.of(2021, 4, 10, 13,15,54),
                amount = BigDecimal.valueOf(50.00).setScale(2),
                taxType = TaxType.COMPANY_TAX
            )

            val currentRelativePath: Path = Paths.get("")
            val s = currentRelativePath.toAbsolutePath().toString()
            val filePath = "$s/src/test/resources/short_sample.csv"
            val record = Parser.readFile(filePath)[3]

            // When
            val result = TaxInvoice.csvRecordToTaxInvoice(record)

            // Then
            assertEquals(expected, result)
        }
    }
})
