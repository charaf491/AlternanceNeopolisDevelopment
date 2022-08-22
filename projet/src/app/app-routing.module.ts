import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistreComponent } from './registre/registre.component';

const routes: Routes = [
  {
    path: 'home', component: HomeComponent
  },
  {
    path: '',redirectTo:'home',pathMatch:'full'
  },
  {
    path: 'registre', component: RegistreComponent
  },
  {
    path: 'login', component: LoginComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
