import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SigninComponent } from './signin/signin.component';
import { FloorComponent } from './floor/floor.component';
import { ZonesComponent } from './zones/zones.component';
import { TableComponent } from './table/table.component';
import { WorktablesComponent } from './worktables/worktables.component';


const routes: Routes = [
  {path: '', component : SigninComponent},
  {path: 'floor', component: FloorComponent},
  {path: 'zones/:id', component: ZonesComponent},
  {path: 'worktables/:id', component: WorktablesComponent},
  {path: 'table/:id', component: TableComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
