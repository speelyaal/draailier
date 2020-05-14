package com.speelyaal.draailier

import com.speelyaal.draailier.config.DraailierProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(DraailierProperties::class)
class DraailierApplication

fun main(args: Array<String>) {
	runApplication<DraailierApplication>(*args)
}
