import {HttpClient, HttpHeaders, HttpClientModule} from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {UsuarioModel} from '../shared-models/usuario-model';
import {ComentariosListModel} from '../shared-models/comentarioslist-model';
@Injectable({
    providedIn: 'root'
})export class UsuarioService {

    private apiUrl = 'api/usuarios';
    private apiComentario = 'api/comentarios';

    constructor(protected http: HttpClient) {
    }

    insert(entity: UsuarioModel): Observable<UsuarioModel> {
        return this.http.post<UsuarioModel>(this.apiUrl+"/", entity);
    }

    findById(id: number): Observable<UsuarioModel> {
        return this.http.get<UsuarioModel>(this.apiUrl + '/' + id);
    }

    findAll(): Observable<UsuarioModel[]> {
        return this.http.get<UsuarioModel[]>(this.apiUrl + '/');
    }

    update(entity: UsuarioModel): Observable<UsuarioModel> {
        return this.http.put<UsuarioModel>(this.apiUrl, entity);
    }

    delete(id: number): Observable<void> {
        return this.http.delete<void>(this.apiUrl + '/' + id);
    }

    findComentariosDoUsuario(idUsuario: number): Observable<UsuarioModel[]> {
        const test2 = this.http.get<UsuarioModel[]>(this.apiUrl + '/' + idUsuario);
        console.log(this.http.get<UsuarioModel[]>(this.apiUrl + '/' + idUsuario));
        return test2;
    }

    login(hash: string) {
        return this.http.get<UsuarioModel>(this.apiUrl + '/obter-por-hash/' + hash);
    }

}
