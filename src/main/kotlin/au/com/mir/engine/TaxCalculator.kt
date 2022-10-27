package au.com.mir.engine

import au.com.mir.model.TaxInvoice
import java.math.BigDecimal

object TaxCalculator {
    fun getInvoiceAmounts(invoice: List<TaxInvoice>, customer: Int, taxType: String)
            : List<BigDecimal> {
        return invoice
            .filter { it.customerId == customer && it.taxType.toString() == taxType}
            .map { it.amount }
            .toList()
    }

    fun calculateTotalTax(amounts: List<BigDecimal>): BigDecimal {
        val totalInvoiceAmount = amounts.reduce{ a, b -> a + b }
        return totalInvoiceAmount.times(0.1.toBigDecimal()).setScale(2)
    }
}
