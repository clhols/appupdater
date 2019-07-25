package dk.youtec.appupdater

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

open class AppUpdaterTest {

    @Test
    fun testParser() {
        val metaString = String(File("src/test/java/dk/youtec/appupdater/meta.json").readBytes())

        val versionCode = extractVersionCode(metaString)

        assertEquals(1907242000, versionCode)
    }
}