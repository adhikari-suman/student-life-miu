import {Component, OnInit} from '@angular/core';
import {AnimeService} from "../anime.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormArray, FormBuilder, FormGroup} from "@angular/forms";
import {formatDate} from "@angular/common";
import {Anime} from "../anime.model";

@Component({
  selector: 'app-update-anime',
  templateUrl: './update-anime.component.html',
  styleUrl: './update-anime.component.css'
})
export class UpdateAnimeComponent implements OnInit {

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

    const animeId = this._activatedRoute.snapshot.params['id'];

    this._animeService.getOne(animeId).subscribe(anime => {
      const characterFormArray: FormArray = this._formBuilder.array([]);

      for (const character of anime.characters) {
        // const characteristicsFormArray = this._formBuilder.array(character.characteristics);

        const characterGroup = this._formBuilder.group({
          'id': character._id,
          'name': character.name,
          'characteristics': character.characteristics.join(', '),
        });

        characterFormArray.push(characterGroup);
      }


      this.updateAnimeForm.patchValue(
        {
          id: anime._id,
          name: anime.name,
          studio: anime.studio,
          releaseDate: formatDate(anime.releaseDate, 'yyyy-MM-dd', 'en-US', 'UTC'),
        }
      );

      this.updateAnimeForm.setControl('characters', characterFormArray);

      console.log(this.updateAnimeForm);
    })
  }

  updateAnime(updateAnimeForm: FormGroup) {
    const anime = new Anime(new Date(), '', [], '');

    anime.fillFormData(updateAnimeForm);

    this._animeService.updateOne(anime._id ?? '', anime).subscribe(
      () => {
        this._router.navigate(['/anime', anime._id]);
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

  // getCharacteristicsFormArray(character: AbstractControl): FormArray {
  //
  //   console.log((character as FormGroup).get('characteristics') as FormArray);
  //   return (character as FormGroup).get('characteristics') as FormArray;
  // }

  protected readonly console = console;
}
