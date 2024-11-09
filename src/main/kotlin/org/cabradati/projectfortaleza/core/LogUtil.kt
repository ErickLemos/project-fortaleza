package org.cabradati.projectfortaleza.core

import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("project-fortaleza")

fun log(message: String) {
    logger.info(message)
}