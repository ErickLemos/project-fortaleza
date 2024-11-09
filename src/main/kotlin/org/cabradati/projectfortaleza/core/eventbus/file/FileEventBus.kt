package org.cabradati.projectfortaleza.core.eventbus.file

import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import org.cabradati.projectfortaleza.core.utils.log
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardOpenOption

object FileEventBus {
    private val queue = BehaviorSubject.create<FileEvent>()

    init {
        queue.subscribeOn(Schedulers.io()).subscribe(
            {
                Files.newBufferedWriter(Path.of("config/villages/${it.name}"), StandardCharsets.UTF_8, StandardOpenOption.CREATE)
                    .use { writer ->
                        writer.write(it.content)
                        writer.flush()
                    }
            },
            {
                log("error: ${it.message}")
            }
        )
    }

    fun publish(fileEvent: FileEvent) {
        queue.onNext(fileEvent)
    }

}