import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup} from "@angular/forms";
import {AnimeService} from "../anime.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Anime} from "../anime.model";

@Component({
  selector: 'app-add-anime',
  templateUrl: './add-anime.component.html',
  styleUrl: './add-anime.component.css'
})
export class AddAnimeComponent implements OnInit {

  updateAnimeForm!: FormGroup;

  constructor(private _animeService: AnimeService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute,
              private _formBuilder: FormBuilder,
  ) {
  }

  get characters(): FormArray {
    return this.updateAnimeForm.get('characters') as FormArray;
  }


  ngOnInit(): void {
    this.updateAnimeForm = this._formBuilder.group({
      id: null,
      name: null,
      studio: null,
      releaseDate: null,
      characters: this._formBuilder.array([])
    });
  }

  addAnime(addAnimeForm: FormGroup) {
    const anime = new Anime(new Date(), '', [], '');

    anime.fillFormData(addAnimeForm);

    this._animeService.addOne(anime).subscribe(
      (animeAdded) => {
        this._router.navigate(['/anime', animeAdded._id]);
      }
    );
  }

  addCharacter() {
    const characterGroup = this._formBuilder.group({
      'id': null,
      'name': null,
      // 'characteristics': this._formBuilder.array([]),
      'characteristics': null,
    });

    this.characters.push(characterGroup);
  }

  deleteCharacter(characterIndex: number) {
    this.characters.removeAt(characterIndex);
  }

  protected readonly console = console;
}
