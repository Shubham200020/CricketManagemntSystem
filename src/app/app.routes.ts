import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { LoginComponent } from './login/login.component';
import { FormComponent } from './form/form.component';
import { CitylocComponent } from './cityloc/CitylocComponent.1';

import { PlayersComponent } from './players/players.component';
import { DashboardComponent } from './dashboard/dashboard.component';

export const routes: Routes = [
    {path:"" , component:HomeComponent},
    {path:"login",component:LoginComponent},
    {path:"insert",component:FormComponent},
    {path:"city",component:CitylocComponent},
    {path:"action",component:PlayersComponent},
    {path:"dashboard",component:DashboardComponent},
    {path:"**",component:NotfoundComponent},
 
   
];
