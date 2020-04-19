package dk.youtec.appupdater

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

open class AppUpdaterTest {

    @Test
    fun testParser() {
        val metaString = String(File("src/test/java/dk/youtec/appupdater/meta.json").readBytes())

        val versionCode = extractVersionCode(metaString)

        assertEquals(2003041900, versionCode)
    }
}