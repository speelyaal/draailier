package com.speelyaal.draailier.transformers.requests

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.speelyaal.draailier.config.ConfigLoader
import com.speelyaal.draailier.datamodel.CloudProviderName
import com.speelyaal.draailier.datamodel.Location


import com.speelyaal.draailier.datamodel.DraailierResource
import com.speelyaal.draailier.datamodel.network.FloatingIP
import com.speelyaal.draailier.datamodel.network.Network
import com.speelyaal.draailier.datamodel.vm.OperatingSystemImage
import com.speelyaal.draailier.datamodel.vm.SSHKey
import com.speelyaal.draailier.datamodel.vm.VirtualMachine
import com.speelyaal.draailier.datamodel.vm.VirtualMachineType
import com.speelyaal.draailier.datamodel.ResourceType
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class RequestTransformer {

    private val LOG: Logger = LogManager.getLogger(RequestTransformer::class.java)

    @Autowired
    lateinit var config:  ConfigLoader

    private val jsonObjectMapper: ObjectMapper = ObjectMapper(JsonFactory());

    fun transformResourceToPost(cloudProvider: CloudProviderName,
                                resourceType: ResourceType,
                                resourceToCreate: Any,
                                mapping: HashMap<String, String>): Map<String, Any?> {




        var resultMap = HashMap<String, Any?>()
        var resourceObject = this.castToResourceType(resourceType, resourceToCreate)
        mapping.forEach {property ->

            var tempVal: Any? = resourceObject.getPropertyValue(property.value)


            resultMap[property.key] = tempVal

        }


        return resultMap
    }


    private fun castToResourceType(resourceType: ResourceType, resourceToCreate: Any): DraailierResource {


        var jsonString = this.jsonObjectMapper.writeValueAsString(resourceToCreate)


        when(resourceType){
           ResourceType.VirtualMachine ->  return this.jsonObjectMapper.readValue(jsonString, VirtualMachine::class.java )
           ResourceType.SSHKey ->  return this.jsonObjectMapper.readValue(jsonString, SSHKey::class.java )
           ResourceType.Network ->  return this.jsonObjectMapper.readValue(jsonString, Network::class.java )
           ResourceType.FloatingIP ->  return this.jsonObjectMapper.readValue(jsonString, FloatingIP::class.java )
            ResourceType.Location ->  return this.jsonObjectMapper.readValue(jsonString, Location::class.java )
            ResourceType.VirtualMachineType ->  return this.jsonObjectMapper.readValue(jsonString, VirtualMachineType::class.java )
            ResourceType.OperatingSystemImage ->  return this.jsonObjectMapper.readValue(jsonString, OperatingSystemImage::class.java )
            ResourceType.None -> {
                LOG.error("Resource type not found")
                TODO("Implement error handling")
            }
            else ->{
                LOG.error("Resource type not found")
                TODO("Implement error handling")
            }



        }



    }







}

