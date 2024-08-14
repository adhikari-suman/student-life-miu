import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AnimeListComponent} from "./anime/anime-list/anime-list.component";
import {AddAnimeComponent} from "./anime/add-anime/add-anime.component";
import {UpdateAnimeComponent} from "./anime/update-anime/update-anime.component";
import {ErrorComponent} from "./core/error/error.component";
import {AnimeDetailComponent} from "./anime/anime-detail/anime-detail.component";
import {HomeComponent} from "./home/home/home.component";
import {AuthenticationModule} from "./authentication/authentication.module";
import {RegisterComponent} from "./authentication/register/register.component";

const routes: Routes = [
  {
    path: '', redirectTo: 'home', pathMatch: 'full',
  },
  {
    path: 'home', component: HomeComponent,
  },
  {
    path: 'anime', component: AnimeListComponent,
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
    path: 'register', component: RegisterComponent,
  },
  {
    path: '**', component: ErrorComponent,
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    AuthenticationModule,
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
