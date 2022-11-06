package au.com.mir.io

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.nio.file.Path
import java.nio.file.Paths

class ParserTest: Spek({
    describe("readCsvFile") {
        it("should take an input file and read its contents") {
            // GIVEN
            val currentRelativePath: Path = Paths.get("")
            val s = currentRelativePath.toAbsolutePath().toString()
            val filePath = "$s/src/test/resources/short_sample.csv"

            // WHEN
            val result = Parser.readFile(filePath)
            println(result)

            // THEN
            assertEquals("123", result[0].get(0))
            assertEquals("2021/04/customer1-12212", result[0].get(1))
            assertEquals("2021-04-29T13:15:54", result[0].get(2))
            assertEquals("10.00", result[0].get(3))
            assertEquals("GST", result[0].get(4))
            assertEquals(4, result.size)
        }

        it("should throw a File Not Found Exception") {
            // Given
            val currentRelativePath: Path = Paths.get("")
            val s = currentRelativePath.toAbsolutePath().toString()
            val filePath = "$s/src/test/resources/short_sample11.csv"

            // When
            val result = assertThrows<FileNotFoundException> {
                Parser.readFile(filePath)
            }

            // Then
            assertEquals("Wrong file name", result.msg)
        }
    }
})
