import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorktablesComponent } from './worktables.component';

describe('WorktablesComponent', () => {
  let component: WorktablesComponent;
  let fixture: ComponentFixture<WorktablesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorktablesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorktablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
