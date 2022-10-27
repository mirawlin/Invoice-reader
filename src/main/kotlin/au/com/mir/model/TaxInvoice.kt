package au.com.mir.model

import org.apache.commons.csv.CSVRecord
import java.math.BigDecimal
import java.time.LocalDateTime

data class TaxInvoice(
    val customerId: Int,
    val commercialInvoiceNumber: String,
    val timestamp: LocalDateTime,
    val amount: BigDecimal,
    val taxType: TaxType
) {
    companion object {
        private fun taxTypeToEnum(value: String): TaxType {
            return TaxType.valueOf(value)
        }

        fun csvRecordToTaxInvoice(csvRecord: CSVRecord): TaxInvoice {
            return TaxInvoice(
                customerId = csvRecord[0].toInt(),
                commercialInvoiceNumber = csvRecord[1],
                timestamp = LocalDateTime.parse(csvRecord[2]),
                amount = csvRecord[3].toBigDecimal(),
                taxType = taxTypeToEnum(csvRecord[4])
            )
        }
    }
}

enum class TaxType {
    GST, PAYROLL, COMPANY_TAX, LAND_TAX, CAPITOL_GAIN
}
