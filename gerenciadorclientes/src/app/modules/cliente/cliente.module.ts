import { MatCheckboxModule } from '@angular/material/checkbox';
import { ClienteFormComponent } from './components/cliente-form/cliente-form.component';
import { MatTableModule } from '@angular/material/table';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClienteRoutingModule } from './cliente-routing.module';
import { MatButtonModule } from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from '@angular/material/dialog';
import { ClienteForm2Component } from './components/cliente-form2/cliente-form2.component';


@NgModule({
  declarations: [ClienteFormComponent, ClienteForm2Component],
  imports: [
    CommonModule,
    ClienteRoutingModule,
    MatTableModule,
    MatCheckboxModule,
    MatButtonModule,
    MatIconModule,
    MatDialogModule
  ]
})
export class ClienteModule { }
