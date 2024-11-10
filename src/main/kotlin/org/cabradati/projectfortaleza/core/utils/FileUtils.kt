package org.cabradati.projectfortaleza.core.utils

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

fun saveFile(
    path: String,
    fileName: String,
    content: Any
) {
    Thread.ofVirtual().start {
        val pathForCreate = File(path)
        if (!pathForCreate.exists()) pathForCreate.mkdirs()

        val fullPathFile = Path.of(pathForCreate.toString(), fileName)
        Files.newBufferedWriter(fullPathFile, StandardCharsets.UTF_8, StandardOpenOption.CREATE)
            .use { writer ->
                writer.write(objectMapper.writeValueAsString(content))
                writer.flush()
            }
    }
}