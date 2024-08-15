import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AnimeListComponent} from './anime-list/anime-list.component';
import {AnimeDetailComponent} from './anime-detail/anime-detail.component';
import {AddAnimeComponent} from './add-anime/add-anime.component';
import {UpdateAnimeComponent} from './update-anime/update-anime.component';
import {RouterLink} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AnimeListComponent,
    AnimeDetailComponent,
    AddAnimeComponent,
    UpdateAnimeComponent
  ],
  imports: [
    CommonModule,
    RouterLink,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [
    AnimeListComponent,
  ]
})
export class AnimeModule {
}
