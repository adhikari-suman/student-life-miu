import { Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { GameComponent } from './game/game.component';
import { GamesComponent } from './games/games.component';

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
        path: "game", component: GameComponent
    }

];
