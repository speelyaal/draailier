package com.speelyaal.draailier.transformers.utils

import com.speelyaal.draailier.datamodel.Location
import com.speelyaal.draailier.datamodel.ResourceType
import com.speelyaal.draailier.datamodel.DraailierResource
import com.speelyaal.draailier.datamodel.network.FloatingIP
import com.speelyaal.draailier.datamodel.network.Network
import com.speelyaal.draailier.datamodel.vm.OperatingSystemImage
import com.speelyaal.draailier.datamodel.vm.SSHKey
import com.speelyaal.draailier.datamodel.vm.VirtualMachine
import com.speelyaal.draailier.datamodel.vm.VirtualMachineType
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class ResourceTypeFactory {

    private val LOG: Logger = LogManager.getLogger(ResourceTypeFactory::class.java)



    companion object {

        private val LOG: Logger = LogManager.getLogger(ResourceTypeFactory::class.java)
        fun getInstance(resource: ResourceType): DraailierResource? {

            when (resource) {
                ResourceType.Location -> return Location()
                ResourceType.VirtualMachine -> return VirtualMachine()
                ResourceType.VirtualMachineType -> return VirtualMachineType()
                ResourceType.OperatingSystemImage -> return OperatingSystemImage()
                ResourceType.SSHKey -> return SSHKey()
                ResourceType.Network -> return Network()
                ResourceType.FloatingIP -> return FloatingIP()
                else -> {
                    LOG.error("Resource not found  $resource")
                }
            }

            return null;

        }



    }
}