import { Component, OnInit, ViewChild } from '@angular/core';
import { finalize } from 'rxjs/operators';
import { TarefaModel } from 'src/app/shared-models/tarefa-model';
import { TarefaService } from 'src/app/shared-services/tarefa-service';
import {BlockUI, NgBlockUI} from 'ng-block-ui';
import {CardModule} from 'primeng/card'; 
import { UsuarioService } from 'src/app/shared-services/usuario-service';
import { UsuarioModel } from "src/app/shared-models/usuario-model";
import { Router } from '@angular/router';
import { ConfirmationService } from 'primeng';
import {NgModule} from '@angular/core';
import { ComentariosListModel } from 'src/app/shared-models/comentarioslist-model';

@Component({
    selector: 'app-modal-comentarios-tarefa',
    templateUrl: './tarefa-comentarios.component.html',
    styleUrls: ['tarefa-comentarios.component.scss']
})
export class TarefaComentariosModalComponent implements OnInit {

    comentarios: ComentariosListModel = {};
    @BlockUI() blockUI: NgBlockUI;
    t: number;

    constructor(protected tarefaService: TarefaService,
        // protected comentarioService: Comentari
        private router: Router,
    ) {}

    ngOnInit(): void { }


    loadDetailsByIdTarefa(idTarefa: number) {
        this.blockUI.start();
    }

}