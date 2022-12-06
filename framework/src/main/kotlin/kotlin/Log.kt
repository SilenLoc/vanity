package kotlin

import mu.KotlinLogging


object Log {

  private val logger = KotlinLogging.logger(Thread.currentThread().stackTrace[2].className)

  fun info(msg: () -> Any?) = logger.info(msg().toString())


}