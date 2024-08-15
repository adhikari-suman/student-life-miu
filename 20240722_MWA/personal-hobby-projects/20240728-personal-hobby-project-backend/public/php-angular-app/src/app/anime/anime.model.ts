import {Character} from "./character.model";
import {FormArray, FormGroup} from "@angular/forms";

export class Anime {
  public _id?: string;  // Optional property
  public name: string;
  public characters: Character[];
  public studio: string;
  public releaseDate: Date;

  constructor(
    releaseDate: Date,
    name: string,
    characters: Character[],
    studio: string,
    _id?: string,
  ) {
    this._id = _id;
    this.name = name;
    this.studio = studio;
    this.characters = characters;
    this.releaseDate = releaseDate;
  }

  fillFormData(updateAnimeForm: FormGroup) {
    this._id = updateAnimeForm.value.id;
    this.name = updateAnimeForm.value.name;
    this.studio = updateAnimeForm.value.studio;
    this.releaseDate = updateAnimeForm.value.releaseDate;

    const characters = new Array<Character>();

    const charactersFormArray = updateAnimeForm.get("characters") as FormArray;

    charactersFormArray.controls.forEach(control => {
      const character = new Character('', []);

      if (control.value.id) {
        character._id = control.value.id;
      }
      character.name = control.value.name;
      character.characteristics = [];

      characters.push(character);
    });

    this.characters = characters;


    console.log(characters);
  }
}
