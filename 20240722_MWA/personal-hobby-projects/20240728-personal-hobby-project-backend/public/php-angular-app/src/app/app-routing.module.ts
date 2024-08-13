import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AnimeListComponent} from "./anime/anime-list/anime-list.component";
import {AddAnimeComponent} from "./anime/add-anime/add-anime.component";
import {UpdateAnimeComponent} from "./anime/update-anime/update-anime.component";
import {ErrorComponent} from "./core/error/error.component";
import {LoginComponent} from "./authentication/login/login.component";
import {RegisterComponent} from "./authentication/register/register.component";
import {AnimeDetailComponent} from "./anime/anime-detail/anime-detail.component";

const routes: Routes = [
  {
    path: '', redirectTo: 'home', pathMatch: 'full',
  },
  {
    path: 'anime', redirectTo: 'home', pathMatch: 'full'
  },
  {
    path: 'home', component: AnimeListComponent,
  },
  {
    path: 'anime/add', component: AddAnimeComponent,
  },
  {
    path: 'anime/:id', component: AnimeDetailComponent,
  },
  {
    path: 'anime/:id/edit', component: UpdateAnimeComponent,
  },
  {
    path: 'login', component: LoginComponent,
  },
  {
    path: 'register', component: RegisterComponent,
  },
  {
    path: '**', component: ErrorComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
