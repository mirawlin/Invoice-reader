package au.com.mir.engine

import au.com.mir.io.Parser
import au.com.mir.model.TaxInvoice

object TaxEngine {
    fun execute(customer: Int, taxType: String, filePath: String): String {
        val records = Parser.readFile(filePath)

        val taxInvoice = records.map { TaxInvoice.csvRecordToTaxInvoice(it) }

        val findRelevantRecords = TaxCalculator.getInvoiceAmounts(taxInvoice, customer, taxType)
        val calculateTax = TaxCalculator.calculateTotalTax(findRelevantRecords)

        return "For tax $taxType, customer $customer has declared \$$calculateTax"
    }
}
