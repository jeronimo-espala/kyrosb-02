import { MatCheckboxModule } from '@angular/material/checkbox';
import { ClienteFormComponent } from './components/cliente-form/cliente-form.component';
import { MatTableModule } from '@angular/material/table';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClienteRoutingModule } from './cliente-routing.module';


@NgModule({
  declarations: [ClienteFormComponent],
  imports: [
    CommonModule,
    ClienteRoutingModule,
    MatTableModule,
    MatCheckboxModule
  ]
})
export class ClienteModule { }
