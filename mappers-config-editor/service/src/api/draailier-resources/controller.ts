import * as Hapi from '@hapi/hapi';
import * as Boom from '@hapi/boom';
import Logger from '../../helper/logger';
import newResponse from '../../helper/response';
import * as _ from 'lodash';
import fsUtils from '../../common/file-system-utils';


export default class DraailierResourcesController {
  constructor() {
  }

  public getDraailierResources = async (
    request: Hapi.Request,
    toolkit: Hapi.ResponseToolkit
  ): Promise<any> => {
    try {
      Logger.info(`GET - ${request.url.href}`);
      let response: any = {};

      const draailierConfigFilePath = fsUtils.getDraailierConfigFilePath();

      // config file path - validation
      if (!fsUtils.isPathExists(draailierConfigFilePath)) {
        Logger.error(`Controller: DraailierResourcesController, Method: getDraailierResources - draailier config file Not found. 
                           Given file path: ${draailierConfigFilePath}`);
        return toolkit.response(
          newResponse(request, {
            boom: Boom.notFound(),
          })
        );
      }

      //Convert Yaml as Object
      response = fsUtils.getFileAsObject(draailierConfigFilePath);

      return toolkit.response(
        newResponse(request, {
          value: response,
        })
      );

    } catch (error) {
      return toolkit.response(
        newResponse(request, {
          boom: Boom.badImplementation(error),
        })
      );
    }
  };

}
