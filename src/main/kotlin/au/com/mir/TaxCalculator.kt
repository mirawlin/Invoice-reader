package au.com.mir

import java.math.BigDecimal

object TaxCalculator {
    fun getInvoiceAmounts(invoice: List<TaxInvoice>, customer: Int, taxType: String)
            : List<BigDecimal> {
        return invoice
            .filter { it.customerId == customer && it.taxType == taxType}
            .map { it.amount }.toList()
    }

    fun calculateTotalTax(amounts: List<BigDecimal>): BigDecimal {
        val totalInvoiceAmount = amounts.reduce{ a, b -> a + b }
        return totalInvoiceAmount.times(0.1.toBigDecimal())
    }
}
