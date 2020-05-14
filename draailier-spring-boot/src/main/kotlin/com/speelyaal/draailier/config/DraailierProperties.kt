package com.speelyaal.draailier.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "draailier")
class DraailierProperties {
    lateinit var version: String
    lateinit var mappersPath: String
    lateinit var providers: Array<String>



}
