package au.com.mir

import java.util.logging.Level
import java.util.logging.Logger

val logger: Logger = Logger.getLogger("main")

fun main(args: Array<String>) {

    val filePath = args[2]
    val taxType = args[0]
    val customer = args[1].toInt()
    println(filePath)
    val taxResult = TaxEngine.execute(customer, taxType, filePath)

    logger.log(Level.INFO, "##### Tax invoices result #####")
    logger.log(Level.INFO, taxResult)

}
