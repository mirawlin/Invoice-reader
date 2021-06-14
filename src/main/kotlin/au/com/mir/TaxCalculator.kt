package au.com.mir

import org.apache.commons.csv.CSVRecord
import java.math.BigDecimal

object TaxCalculator {
    fun getInvoiceAmounts(records: List<CSVRecord>, customer: String, taxType: String)
            : List<BigDecimal> {
        return records
            .filter { it.get(0) == customer && it.get(4) == taxType}
            .map { it.get(3).toBigDecimal() }.toList()
    }

    fun calculateTotalTax(amounts: List<BigDecimal>): BigDecimal {
        val totalInvoiceAmount = amounts.reduce{ a, b -> a + b }
        return totalInvoiceAmount.times(0.1.toBigDecimal())
    }
}
