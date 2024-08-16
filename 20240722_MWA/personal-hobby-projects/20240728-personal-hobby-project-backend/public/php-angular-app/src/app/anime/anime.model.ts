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

  fillFormData(animeForm: FormGroup) {
    if (animeForm.value.id !== undefined && animeForm.value.id !== '') {
      this._id = animeForm.value.id;
    }
    this.name = animeForm.value.name;
    this.studio = animeForm.value.studio;
    this.releaseDate = animeForm.value.releaseDate;

    const characters = new Array<Character>();

    const charactersFormArray = animeForm.get("characters") as FormArray;

    charactersFormArray.controls.forEach(control => {
      const character = new Character('', []);

      if (control.value.id) {
        character._id = control.value.id;
      }
      character.name = control.value.name;
      character.characteristics = control.value.characteristics.split(',').map((item: string) => item.trim());

      characters.push(character);
    });

    this.characters = characters;


    console.log(characters);
  }
}
