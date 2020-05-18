import { TestBed } from '@angular/core/testing';

import { CloudProviderService } from './cloud-provider.service';

describe('CloudProviderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CloudProviderService = TestBed.get(CloudProviderService);
    expect(service).toBeTruthy();
  });
});
