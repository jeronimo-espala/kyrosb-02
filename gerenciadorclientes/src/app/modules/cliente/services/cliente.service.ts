import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { ClienteModel } from '../model/cliente.model';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  resourceUrl = environment.serviceUrl + '/clientes';

  constructor(private http: HttpClient) { }

  save(cliente: ClienteModel): Observable<ClienteModel> {
    return this.http.post<ClienteModel>(this.resourceUrl, cliente);
  }

  getAll(): Observable<ClienteModel[]> {
    return this.http.get<ClienteModel[]>(this.resourceUrl);
  }

}
