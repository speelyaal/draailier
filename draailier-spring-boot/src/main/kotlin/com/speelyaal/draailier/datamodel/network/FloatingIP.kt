package com.speelyaal.draailier.datamodel.network

import com.speelyaal.draailier.datamodel.DraailierResource

class FloatingIP: DraailierResource() {
    var ip: String = ""
    var ipType: IPType = IPType.ipv4
    var ipLocationIdentifier: String = ""
    var vmVendorReference: String = ""
}