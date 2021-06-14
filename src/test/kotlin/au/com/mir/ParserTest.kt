package au.com.mir

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
            // Given
            val currentRelativePath: Path = Paths.get("")
            val s = currentRelativePath.toAbsolutePath().toString()
            val filePath = "$s/src/test/resources/short_sample.csv"

            // When
            val result = Parser.readFile(filePath)

            // Then
            assertEquals("10d7ce2f43e35fa57d1bbf8b1e2", result[0].get(0))
            assertEquals("2014-04-29T13:15:54", result[0].get(1))
            assertEquals("10.00", result[0].get(2))
            assertEquals(3, result.size)


            // WHEN

            // THEN
        }

        it("should throw a ") {
            // Given
            val currentRelativePath: Path = Paths.get("")
            val s = currentRelativePath.toAbsolutePath().toString()
            val filePath = "$s/src/test/resources/short_sample11.csv"

            // When
            val result = assertThrows<IOException> {
                Parser.readFile(filePath)
            }

            // Then
            assertEquals("Wrong file name", result.msg)
        }
    }
})
