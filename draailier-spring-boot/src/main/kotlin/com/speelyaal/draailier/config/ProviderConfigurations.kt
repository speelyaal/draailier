package com.speelyaal.draailier.config

import com.speelyaal.draailier.datamodel.ResourceType

class ProviderConfigurations {

    //Properties with default values
    var apiVersion: String = "v1"
    var apiUrl: String ="[URL]"
    var authorizationType: AuthorizationType = AuthorizationType.bearerToken
    var resources: List<ResourceType> = arrayListOf(
            ResourceType.Location,
            ResourceType.OperatingSystemImage,
            ResourceType.VirtualMachineType,
            ResourceType.VirtualMachine,
            ResourceType.SSHKey
    )

    enum class AuthorizationType {
        bearerToken,
        basicAuth

    }


}

