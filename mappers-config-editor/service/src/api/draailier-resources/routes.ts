import * as Hapi from '@hapi/hapi';
import validate from '../draailier-resources/validate';
import Logger from '../../helper/logger';
import IRoute from '../../helper/route';
import DraailierResourcesController from './controller';

export default class DraailierResourcesRoutes implements IRoute {
  public async register(server: Hapi.Server): Promise<any> {
    return new Promise(resolve => {
      Logger.info('draailier-resources - Start adding routes');

      const controller = new DraailierResourcesController();

      server.route([
        {
          method: 'GET',
          path: `/api/draailier-resources`,
          options: {
            handler: controller.getDraailierResources,
            description: 'Method that gets draailier-resources.',
            tags: ['api', 'draailier-resources'],
            auth: false,
          },
        }
      ]);

      Logger.info('draailier-resources - Finish adding routes');

      resolve();
    });
  }
}
