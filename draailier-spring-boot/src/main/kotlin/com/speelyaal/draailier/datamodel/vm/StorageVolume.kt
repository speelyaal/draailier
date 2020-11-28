package com.speelyaal.draailier.datamodel.vm

import com.speelyaal.draailier.datamodel.DraailierResource

class StorageVolume : DraailierResource() {
    var size: Int = 10
    var vmVendorIdentifier: String = ""
    var availability: StorageVolumeAvailability = StorageVolumeAvailability.creating
}