package com.speelyaal.draailier.transformers.responses

import com.speelyaal.draailier.datamodel.ResourceType

class ResponseMapper {

    lateinit var draailierType: ResourceType
    lateinit var listPath: String
    lateinit var singleInstancePath: String
    lateinit var mapping: HashMap<String, String>

}