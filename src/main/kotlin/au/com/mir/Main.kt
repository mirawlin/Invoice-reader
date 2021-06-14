package au.com.mir

import java.util.logging.Level
import java.util.logging.Logger

val logger: Logger = Logger.getLogger("main")

fun main(args: Array<String>) {

    logger.log(Level.INFO, "##### Tax invoices result #####")
}
