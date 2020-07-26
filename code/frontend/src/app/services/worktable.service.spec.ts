import { TestBed } from '@angular/core/testing';

import { WorktableService } from './worktable.service';

describe('WorktableService', () => {
  let service: WorktableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorktableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
