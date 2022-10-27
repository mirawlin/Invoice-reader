package au.com.mir

import au.com.mir.engine.TaxEngine
import java.util.logging.Level
import java.util.logging.Logger

val logger: Logger = Logger.getLogger("main")

fun main(args: Array<String>) {
    val getParams = args[0].split(" ")
    val filePath = getParams[2]
    val taxType = getParams[0]
    val customer = getParams[1].toInt()

    val result = TaxEngine.execute(customer, taxType, filePath)

    logger.log(Level.INFO, "##### Tax invoices result #####")
    logger.log(Level.INFO, result)
}
