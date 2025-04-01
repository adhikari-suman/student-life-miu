import { Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { GameComponent } from './game/game.component';
import { GamesComponent } from './games/games.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
    {
        path: "", redirectTo: "home", pathMatch: "full"
    },
    {
        path: "home", component: HomeComponent
    },
    {
        path: "games", component: GamesComponent
    },
    {
        path: "game/:gameId", component: GameComponent
    },
    {
        path: "register", component: RegisterComponent
    },
    {
        path: "login", component: LoginComponent
    },
    {
        path: "**", component: ErrorPageComponent
    },

];
