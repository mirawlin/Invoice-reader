package au.com.mir

import java.util.logging.Level
import java.util.logging.Logger

val logger: Logger = Logger.getLogger("main")

fun main(args: Array<String>) {

    val filePath = args[0].split(" ")[2]
    println(filePath)
    val records = Parser.readFile(filePath)

    logger.log(Level.INFO, "##### Tax invoices result #####")
}
