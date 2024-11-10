package org.cabradati.projectfortaleza.modules.village

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.cabradati.projectfortaleza.core.models.Village
import org.cabradati.projectfortaleza.modules.Module
import java.util.UUID
import java.util.concurrent.TimeUnit

object VillagerManagerModule : Module {
    private val villagers = listOf<Village>()
    private val timedObservable = Flowable.interval(1, TimeUnit.SECONDS)
        .observeOn(Schedulers.computation())

    override fun init() {
        initEvents()

    }

    private fun initEvents() {
        timedObservable.subscribe {
            Thread.ofVirtual()
                .name(UUID.randomUUID().toString())
                .start {
                println("dispatch event: $it - ${Thread.currentThread().name}")
                Thread.currentThread().interrupt()
            }
        }
    }
}