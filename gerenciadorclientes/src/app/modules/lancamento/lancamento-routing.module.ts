import { LancamentoFormComponent } from './components/lancamento-form/lancamento-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '/lancamento', component: LancamentoFormComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LancamentoRoutingModule {}
