package com.speelyaal.draailier.transformers.responses

import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.jsonpath.JsonPath
import com.speelyaal.draailier.config.ConfigLoader
import com.speelyaal.draailier.datamodel.CloudProviderName
import com.speelyaal.draailier.transformers.exceptions.ResponseMapperNotFoundException
import com.speelyaal.draailier.datamodel.ResourceType
import com.speelyaal.draailier.transformers.utils.ResourceTypeFactory
import net.minidev.json.JSONArray
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component


@Component
class ResponseTransformer {

    private val LOG: Logger = LogManager.getLogger(ResponseTransformer::class.java)

    private val jsonObjectMapper: ObjectMapper = ObjectMapper();

    @Autowired
    lateinit var config: ConfigLoader

    fun transformListResponse(cloudProvider: CloudProviderName, resource: ResourceType, result: ResponseEntity<String>): Any {

        var responseMapper = this.getResponseMapper(cloudProvider, resource)
        var mapping = responseMapper.mapping

        //TODO: Actual stuff goes here, create  new Response Type, map properties and put them in list

        var listResult: JSONArray = JsonPath.parse(result.body).read(responseMapper.listPath)

       // var responseList: List<DraailierResource>? = ResourceTypeFactory.getListInstance(responseMapper.draailierType)
        var responseList = ArrayList<Any>()
        listResult.forEach { region ->


            var jsonObject = this.jsonObjectMapper.writeValueAsString(region);


            var tmpObject= ResourceTypeFactory.getInstance(responseMapper.draailierType);

            mapping.forEach { property ->


               lateinit var tempVal: Any;
                try {
                     tempVal = JsonPath.parse(jsonObject).read(property.value);
                    tmpObject?.setProperty(property.key, tempVal)

                }catch (exception: ClassCastException){
                    LOG.error("Casting error for ${property.key}    - > ${property.value}")
                    LOG.error(exception.message)
                }catch (exception: IllegalStateException){
                    LOG.error("Error with property ${property.key} - ${property.value}")
                    LOG.error(exception.message)

                }

            }

            if (tmpObject != null) {
                responseList.add(tmpObject)
            }


        }


        return responseList

    }

    fun transformSingleResourceResponse(cloudProvider: CloudProviderName, resource: ResourceType, result: ResponseEntity<Any>): Any {
        var responseMapper = this.getResponseMapper(cloudProvider, resource)

        var mapping = responseMapper.mapping

        //TODO: Actual stuff goes here, create  new Response Type, map properties and put them in list

        var singleResult = this.jsonObjectMapper.writeValueAsString(result.body)
        var jsonObject: Any = JsonPath.parse(singleResult).read(responseMapper.singleInstancePath)

        var tmpResultObject = ResourceTypeFactory.getInstance(responseMapper.draailierType);

            mapping.forEach { property ->


                lateinit var tempVal: Any;
                try {
                    tempVal = JsonPath.parse(jsonObject).read(property.value);
                    tmpResultObject?.setProperty(property.key, tempVal)
                }catch (exception: ClassCastException){
                    LOG.error("Casting error for ${property.key}    - > ${property.value}")
                    LOG.error(exception.message)
                }catch (exception: IllegalStateException){
                    LOG.error("Error Parsing property ${property.key}    - > ${property.value}")
                    LOG.error(exception.message)
                }

            }





        return tmpResultObject as Any
    }

    private fun getResponseMapper(cloudProvider: CloudProviderName, resource: ResourceType): ResponseMapper {

        this.config.responseObjectMappers[cloudProvider].let {
            var responseMapper = it?.get(resource)
            if(responseMapper != null){
                return responseMapper
            }else{
                //TODO: Log the problem with finding Response mapper
                throw ResponseMapperNotFoundException
            }
        }

    }


    /*  @Suppress("UNCHECKED_CAST")
      fun <R> getProperty(instance: Any, propertyName: String): R {
          val property = instance::class.memberProperties
                  // don't cast here to <Any, R>, it would succeed silently
                  .first { it.name == propertyName } as KProperty1<Any, *>

          // force a invalid cast exception if incorrect type here
          return property.get(instance) as R
      }*/


}