import { ClienteModel } from './../../model/cliente.model';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { SelectionModel } from '@angular/cdk/collections';
import { ClienteService } from '../../services/cliente.service';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import { ClienteForm2Component } from '../cliente-form2/cliente-form2.component';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];

@Component({
  selector: 'app-cliente-form',
  templateUrl: './cliente-form.component.html',
  styleUrls: ['./cliente-form.component.css']
})
export class ClienteFormComponent implements OnInit {

  displayedColumns: string[] = ['select', 'id', 'nome', 'dataNasc', 'endereco', 'cpfCnpj', 'tipoPessoa', 'actions'];
  dataSource = new MatTableDataSource<ClienteModel>();
  selection = new SelectionModel<ClienteModel>(true, []);

  constructor(
    private clienteService: ClienteService,
    private dialog: MatDialog
  ) {

  }

  ngOnInit(): void {
    this.inicarTela();
  }

  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(ClienteForm2Component, {
      width: '250px',
      enterAnimationDuration,
      exitAnimationDuration,
    });
  }


  private inicarTela(): void {
    this.carregarTabela()
  }

  private carregarTabela() {
    this.clienteService.getAll().subscribe(
      (res) => {
        this.dataSource.data = res;
      }
    );
  }

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
