import { ClienteModel } from './../../model/cliente.model';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { SelectionModel } from '@angular/cdk/collections';


@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent {

  private readonly ELEMENT_DATA: ClienteModel[] = [
    {id: 1, nome: 'Hydrogen', dataNasc: new Date(), endereco: 'H', cpfcnpj: "123", tipoPessoa: "daskdja", lancamentos: "dasuiadus"},
    {id: 1, nome: 'Hydrogen', dataNasc: new Date(), endereco: 'H', cpfcnpj: "123", tipoPessoa: "daskdja", lancamentos: "dasuiadus"},
    {id: 1, nome: 'Hydrogen', dataNasc: new Date(), endereco: 'H', cpfcnpj: "123", tipoPessoa: "daskdja", lancamentos: "dasuiadus"},
    {id: 1, nome: 'Hydrogen', dataNasc: new Date(), endereco: 'H', cpfcnpj: "123", tipoPessoa: "daskdja", lancamentos: "dasuiadus"},
  ];

  displayedColumns: string[] = Object.keys(this.ELEMENT_DATA);
  dataSource = new MatTableDataSource<ClienteModel>(this.ELEMENT_DATA);
  selection = new SelectionModel<ClienteModel>(true, []);

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.data.length;
    return numSelected === numRows;
  }

  toggleAllRows() {
    if (this.isAllSelected()) {
      this.selection.clear();
      return;
    }

    this.selection.select(...this.dataSource.data);
  }

  checkboxLabel(row?: ClienteModel): string {
    if (!row) {
      return `${this.isAllSelected() ? 'deselect' : 'select'} all`;
    }
    return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.id + 1}`;
  }

}
