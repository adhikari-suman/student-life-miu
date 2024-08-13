import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AnimeListComponent} from './anime-list/anime-list.component';
import {AnimeDetailComponent} from './anime-detail/anime-detail.component';
import {AddAnimeComponent} from './add-anime/add-anime.component';
import {UpdateAnimeComponent} from './update-anime/update-anime.component';


@NgModule({
  declarations: [
    AnimeListComponent,
    AnimeDetailComponent,
    AddAnimeComponent,
    UpdateAnimeComponent
  ],
  imports: [
    CommonModule
  ]
})
export class AnimeModule {
}