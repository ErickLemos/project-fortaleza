package org.cabradati.projectfortaleza.modules.village

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.cabradati.projectfortaleza.core.interfaces.InitModule
import java.util.concurrent.TimeUnit

object VillageManagerModule : InitModule {
    private val timedObservable = Flowable.interval(1, TimeUnit.SECONDS)
        .observeOn(Schedulers.computation())

    override fun init() {
        initEvents()
    }

    private fun initEvents() {
        timedObservable.subscribe {
        }
    }
}