package au.com.mir.io

import au.com.mir.logger
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import java.io.FileNotFoundException
import java.nio.file.Paths
import java.util.logging.Level

object Parser {

    fun readFile(filePath: String): List<CSVRecord> {
        try {
            val buffReader = Paths.get(filePath).toFile().bufferedReader()
            val parser = CSVParser(
                buffReader,
                CSVFormat.DEFAULT.withTrim()
            )
            return parser.records
        } catch (e: FileNotFoundException) {
            logger.log(Level.SEVERE, e.message)
            throw au.com.mir.io.FileNotFoundException("Wrong file name")
        }
    }
}
