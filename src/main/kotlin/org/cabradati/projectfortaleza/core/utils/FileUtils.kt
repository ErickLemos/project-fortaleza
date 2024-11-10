package org.cabradati.projectfortaleza.core.utils

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption
import java.util.concurrent.CompletableFuture

private data class SaveFileObject(
    val path: String,
    val fileName: String,
    val content: Any
)

fun saveFile(
    path: String,
    fileName: String,
    content: Any,
) {
    CompletableFuture
        .supplyAsync<SaveFileObject> {
            SaveFileObject(
                path = path,
                fileName = fileName,
                content = content
            )
        }
        .thenAccept {
            val pathForCreate = File(it.path)
            if (!pathForCreate.exists()) pathForCreate.mkdirs()

            val fullPathFile = Path.of(pathForCreate.toString(), it.fileName)
            Files.newBufferedWriter(fullPathFile, StandardCharsets.UTF_8, StandardOpenOption.CREATE)
                .use { writer ->
                    writer.write(objectMapper.writeValueAsString(it.content))
                    writer.flush()
                }

            log("new file saved: ${it.path}/${it.fileName}")
        }
}