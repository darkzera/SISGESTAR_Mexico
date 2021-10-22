import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TarefaFormComponent } from './tarefa-form/tarefa-form.component';
import {TarefaListComponent} from './tarefa-list/tarefa-list.component';

const routes: Routes = [
    { path: '', component: TarefaListComponent},
    { path: 'form', component: TarefaFormComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TarefaRoutingModule { }
