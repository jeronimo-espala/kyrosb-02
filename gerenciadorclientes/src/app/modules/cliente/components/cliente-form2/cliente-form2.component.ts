import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-cliente-form2',
  templateUrl: './cliente-form2.component.html',
  styleUrls: ['./cliente-form2.component.css']
})
export class ClienteForm2Component {

  constructor(public dialogRef: MatDialogRef<ClienteForm2Component>) {}

}
